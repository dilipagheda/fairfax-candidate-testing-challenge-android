package au.com.fairfaxmedia.newsapp.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import au.com.fairfaxmedia.newsapp.NewsListContract;
import au.com.fairfaxmedia.newsapp.R;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListViewHolder> {
    final int VIEW_TYPE = 1;

    private NewsListContract.Presenter mNewsListPresenter;

    private NewsListViewHolder.OnItemClickListener mViewHolderListener = new NewsListViewHolder.OnItemClickListener() {
        @Override
        public void onItemClicked(int position) {
            mNewsListPresenter.onItemClicked(position);
        }
    };

    public NewsListAdapter(NewsListContract.Presenter newsListPresenter) {
        mNewsListPresenter = newsListPresenter;
    }

    @Override
    public NewsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list_item, parent, false);
        return new NewsListViewHolder(itemView, mViewHolderListener);
    }

    @Override
    public int getItemViewType(int position) {
        return VIEW_TYPE;
    }

    @Override
    public void onBindViewHolder(NewsListViewHolder holder, int position) {
        holder.itemView.setId(position);
        mNewsListPresenter.onBindViewHolderAtPosition(holder, position);
    }

    @Override
    public int getItemCount() {
        return mNewsListPresenter.getItemCount();
    }
}