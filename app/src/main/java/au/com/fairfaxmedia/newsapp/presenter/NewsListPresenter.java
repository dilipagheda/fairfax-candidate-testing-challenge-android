package au.com.fairfaxmedia.newsapp.presenter;

import java.util.LinkedList;
import java.util.List;

import au.com.fairfaxmedia.newsapp.NewsListContract;
import au.com.fairfaxmedia.newsapp.model.Asset;
import au.com.fairfaxmedia.newsapp.usecase.NewsListUseCase;
import au.com.fairfaxmedia.newsapp.view.adapter.NewsListViewHolder;
import io.reactivex.observers.DisposableObserver;

public class NewsListPresenter extends AbstractStatefulPresenter<NewsListContract.View, NewsListContract.State>
        implements NewsListContract.Presenter, NewsListViewHolder.OnItemClickListener {

    private NewsListUseCase mNewsListUseCase;
    private List<Asset> mItems = new LinkedList();
    private int mCurrentPosition = 0;

    final private int mTestFault_MaxNewsCount = 10;

    public NewsListPresenter(NewsListUseCase newsListUseCase) {
        mNewsListUseCase = newsListUseCase;
    }

    public void onBindViewHolderAtPosition(NewsListContract.ViewHolder holder, int position) {
        final Asset asset = mItems.get(position);
        holder.bind(asset);
    }

    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public Asset getItem(int position) {
        return mItems.get(position);
    }

    public void setItems(List<Asset> assets) {
        mItems.clear();
        if (assets != null && assets.size() > 0) {
            int mMaxNewsCount = 0;
            for (Asset item : assets) {
                if (mTestFault_MaxNewsCount != 0) { // 0 indicates show all items
                    if (mMaxNewsCount >= mTestFault_MaxNewsCount) {
                        break;
                    }
                    mMaxNewsCount++;
                }
                mItems.add(item);
            }
        }
    }

    @Override
    public void attachView(NewsListContract.View view) {
        super.attachView(view);

        if (getSavedState() != null) {
            mCurrentPosition = getSavedState().getCurrentPosition();
        }

        loadData();
    }

    @Override
    public void onItemClicked(int position) {
        getView().openArticleScreen(mItems.get(position).getUrl());
    }

    public NewsListContract.State makeSavedState() {
        return new NewsListState(getView().getFirstVisibleItemPosition());
    }

    @Override
    public void loadData() {
        if (getSavedState() != null && mItems.size() > 0) {
            getView().showResult();
            getView().scrollToPosition(mCurrentPosition);
        } else {
            getView().showLoadingView();
            addDisposable(mNewsListUseCase.loadFromRemoteDataSource()
                    .subscribeWith(new RequestDisposableObserver()));
        }
    }

    private class RequestDisposableObserver extends DisposableObserver<List<Asset>> {
        @Override
        public void onNext(List<Asset> response) {
            setItems(response);
            getView().showResult();
            mCurrentPosition = 0;
        }

        @Override
        public void onError(Throwable e) {
            getView().showError(e.getMessage());
            getView().hideLoadingView();
        }

        @Override
        public void onComplete() {
            getView().hideLoadingView();
        }
    }
}