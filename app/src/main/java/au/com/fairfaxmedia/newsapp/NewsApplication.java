package au.com.fairfaxmedia.newsapp;

import android.app.Application;
import android.support.annotation.VisibleForTesting;

import au.com.fairfaxmedia.newsapp.di.components.AppComponent;
import au.com.fairfaxmedia.newsapp.di.components.DaggerAppComponent;
import au.com.fairfaxmedia.newsapp.di.modules.AppModule;

public class NewsApplication extends Application {
    private AppComponent mAppComponent;
    private static NewsApplication sApplication;

    public static NewsApplication getInstance() {
        return sApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }

    public AppComponent getAppComponent() {
        if (mAppComponent == null) {
            mAppComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }

        return mAppComponent;
    }

    @VisibleForTesting
    public void setAppComponent(AppComponent appComponent) {
        mAppComponent = appComponent;
    }
}