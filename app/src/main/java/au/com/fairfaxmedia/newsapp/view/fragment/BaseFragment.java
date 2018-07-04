package au.com.fairfaxmedia.newsapp.view.fragment;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import au.com.fairfaxmedia.newsapp.di.components.ActivityComponent;
import au.com.fairfaxmedia.newsapp.di.components.HasComponent;
import au.com.fairfaxmedia.newsapp.view.BaseView;

public abstract class BaseFragment extends Fragment implements BaseView {

    @LayoutRes
    protected abstract int getLayoutRes();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutRes(), container, false);
    }

    // descendant should override to inject objects
    protected void injectDependencies() {
        getActivityComponent().inject(this);
    }

    protected ActivityComponent getActivityComponent() {
        return ((HasComponent<ActivityComponent>) getActivity()).getActivityComponent();
    }
}