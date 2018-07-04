package au.com.fairfaxmedia.newsapp;

import au.com.fairfaxmedia.newsapp.model.Asset;
import au.com.fairfaxmedia.newsapp.presenter.BaseState;
import au.com.fairfaxmedia.newsapp.presenter.BaseStatefulPresenter;
import au.com.fairfaxmedia.newsapp.view.BaseView;
import au.com.fairfaxmedia.newsapp.view.adapter.BaseViewHolder;

public interface NewsListContract {

    interface View extends BaseView {
        void showResult();

        void showError(String error);

        int getFirstVisibleItemPosition();

        void scrollToPosition(int position);

        void openArticleScreen(String url);
    }

    interface Presenter extends BaseStatefulPresenter<View, State> {
        void loadData();

        void onBindViewHolderAtPosition(NewsListContract.ViewHolder holder, int position);

        int getItemCount();

        Asset getItem(int position);

        void onItemClicked(int position);

        NewsListContract.State makeSavedState();
    }

    interface ViewHolder extends BaseViewHolder {
        void bind(Asset asset);
    }

    interface State<S> extends BaseState {
        int getCurrentPosition();
    }
}