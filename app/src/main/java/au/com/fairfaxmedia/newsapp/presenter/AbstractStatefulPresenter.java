package au.com.fairfaxmedia.newsapp.presenter;

import au.com.fairfaxmedia.newsapp.view.BaseView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * This abstract Presenter handles Android-independent state by implementing {@link BaseStatefulPresenter}.
 *
 * @param <T>
 * @param <S>
 */
public abstract class AbstractStatefulPresenter<T extends BaseView, S extends BaseState> implements BaseStatefulPresenter<T, S> {
    private T mView;
    private S mSavedState;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    public T getView() {
        return mView;
    }

    @Override
    public void attachView(T view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
        mCompositeDisposable.clear();
    }

    @Override
    public boolean isViewAttached() {
        return mView != null;
    }

    public void addDisposable(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    @Override
    public S getSavedState() {
        return mSavedState;
    }

    @Override
    public void setSavedState(S state) {
        mSavedState = state;
    }
}