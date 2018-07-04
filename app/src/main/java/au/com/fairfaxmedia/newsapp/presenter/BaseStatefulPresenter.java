package au.com.fairfaxmedia.newsapp.presenter;

public interface BaseStatefulPresenter<T, S> extends BasePresenter<T>, BaseState {
    S getSavedState();

    void setSavedState(S state);
}