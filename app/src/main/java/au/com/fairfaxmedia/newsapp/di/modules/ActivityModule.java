package au.com.fairfaxmedia.newsapp.di.modules;

import au.com.fairfaxmedia.newsapp.NewsListContract;
import au.com.fairfaxmedia.newsapp.di.components.PerActivity;
import au.com.fairfaxmedia.newsapp.presenter.NewsListPresenter;
import au.com.fairfaxmedia.newsapp.repository.RemoteDataSource;
import au.com.fairfaxmedia.newsapp.usecase.NewsListUseCase;
import au.com.fairfaxmedia.newsapp.view.activity.BaseActivity;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private BaseActivity mBaseActivity;

    public ActivityModule(BaseActivity activity) {
        mBaseActivity = activity;
    }

    @Provides
    @PerActivity
    BaseActivity provideBaseActivity() {
        return mBaseActivity;
    }

    @Provides
    @PerActivity
    NewsListUseCase provideNewsListUseCase(RemoteDataSource remoteDataSource) {
        return new NewsListUseCase(remoteDataSource);
    }

    @Provides
    @PerActivity
    NewsListContract.Presenter provideNewsListPresenter(NewsListUseCase usecase) {
        return new NewsListPresenter(usecase);
    }
}