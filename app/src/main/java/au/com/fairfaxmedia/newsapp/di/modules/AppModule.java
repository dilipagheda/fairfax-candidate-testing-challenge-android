package au.com.fairfaxmedia.newsapp.di.modules;

import android.app.Application;
import android.content.res.Resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    Resources provideResources() {
        return mApplication.getResources();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().create();
    }
}