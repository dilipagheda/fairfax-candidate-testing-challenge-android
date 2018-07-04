package au.com.fairfaxmedia.newsapp.view.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import au.com.fairfaxmedia.newsapp.NewsApplication;
import au.com.fairfaxmedia.newsapp.di.components.ActivityComponent;
import au.com.fairfaxmedia.newsapp.di.components.AppComponent;
import au.com.fairfaxmedia.newsapp.di.components.DaggerActivityComponent;
import au.com.fairfaxmedia.newsapp.di.components.HasComponent;
import au.com.fairfaxmedia.newsapp.di.modules.ActivityModule;

public abstract class BaseActivity extends AppCompatActivity implements HasComponent<ActivityComponent> {

    private ActivityComponent mActivityComponent;

    @LayoutRes
    protected abstract int getLayoutRes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutRes());
    }

    @Override
    public ActivityComponent getActivityComponent() {
        if (mActivityComponent == null) {
            AppComponent appComponent = ((NewsApplication) getApplication()).getAppComponent();
            mActivityComponent = DaggerActivityComponent.builder().appComponent(appComponent).activityModule(new ActivityModule(this))
                    .build();
        }
        return mActivityComponent;
    }

    protected void replaceFragment(int containerViewId, Fragment fragment) {
        final FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
        transaction.replace(containerViewId, fragment);
        transaction.commit();
    }
}