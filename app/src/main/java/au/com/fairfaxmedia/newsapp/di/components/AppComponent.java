package au.com.fairfaxmedia.newsapp.di.components;

import javax.inject.Singleton;

import au.com.fairfaxmedia.newsapp.di.modules.AppModule;
import au.com.fairfaxmedia.newsapp.di.modules.NetworkModule;
import au.com.fairfaxmedia.newsapp.repository.RemoteDataSource;
import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class
})
public interface AppComponent {
    // expose to ActivityComponent
    RemoteDataSource getRemoteDataSource();
}