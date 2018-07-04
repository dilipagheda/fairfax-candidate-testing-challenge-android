package au.com.fairfaxmedia.newsapp.view.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import javax.inject.Inject;

import au.com.fairfaxmedia.newsapp.NewsListContract;
import au.com.fairfaxmedia.newsapp.R;
import au.com.fairfaxmedia.newsapp.view.activity.NewsArticleActivity;
import au.com.fairfaxmedia.newsapp.view.adapter.NewsListAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsListFragment extends BaseFragment implements NewsListContract.View {

    private static final String NEWS_LIST_INSTANCE_STATE = "news_list_state";

    @BindView(R.id.root_layout)
    FrameLayout mRootLayout;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    @Inject
    NewsListContract.Presenter mNewsListPresenter;

    private NewsListAdapter mNewsListAdapter;

    private LinearLayoutManager mLinearLayoutManager;

    public NewsListContract.Presenter getNewsListPresenter() {
        return mNewsListPresenter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mNewsListAdapter = new NewsListAdapter(mNewsListPresenter);

        setRetainInstance(true);
    }

    @Override
    protected void injectDependencies() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_listview;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(mNewsListAdapter);

        mNewsListPresenter.setSavedState(savedInstanceState != null ? readFromBundle(savedInstanceState) : null);
    }

    @Override
    public void onStart() {
        super.onStart();
        mNewsListPresenter.attachView(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        mNewsListPresenter.detachView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        writeBundle(outState, mNewsListPresenter.makeSavedState());
    }

    private NewsListContract.State readFromBundle(@Nullable Bundle bundle) {
        return bundle.getParcelable(NEWS_LIST_INSTANCE_STATE);
    }

    private void writeBundle(@NonNull Bundle bundle, @NonNull NewsListContract.State state) {
        bundle.putParcelable(NEWS_LIST_INSTANCE_STATE, (Parcelable) state);
    }

    @Override
    public void showLoadingView() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingView() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showResult() {
        mNewsListAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String error) {
        Snackbar.make(mRootLayout, error, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public int getFirstVisibleItemPosition() {
        return mLinearLayoutManager.findFirstVisibleItemPosition();
    }

    @Override
    public void scrollToPosition(int position) {
        mRecyclerView.postDelayed(() -> mLinearLayoutManager.scrollToPosition(position), 300);
    }

    @Override
    public void openArticleScreen(String url) {
        NewsArticleActivity.launchActivity(getActivity(), url);
    }
}