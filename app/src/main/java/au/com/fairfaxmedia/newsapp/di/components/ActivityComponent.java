package au.com.fairfaxmedia.newsapp.di.components;

import au.com.fairfaxmedia.newsapp.di.modules.ActivityModule;
import au.com.fairfaxmedia.newsapp.view.fragment.BaseFragment;
import au.com.fairfaxmedia.newsapp.view.fragment.NewsListFragment;
import dagger.Component;

@PerActivity
@Component(dependencies = {AppComponent.class}, modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(BaseFragment fragment);
    void inject(NewsListFragment fragment);
}