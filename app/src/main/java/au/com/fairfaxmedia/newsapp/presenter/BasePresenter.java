package au.com.fairfaxmedia.newsapp.presenter;

public interface BasePresenter<T> {
    T getView();

    void attachView(T view);

    void detachView();

    boolean isViewAttached();
}
