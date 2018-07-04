package au.com.fairfaxmedia.newsapp.repository;

import au.com.fairfaxmedia.newsapp.model.NewsList;
import io.reactivex.Observable;

public class RemoteDataSource {

    private NewsApi mNewsApi;

    public RemoteDataSource(NewsApi newsApi) {
        mNewsApi = newsApi;
    }

    public Observable<NewsList> getNewsList() {
        return mNewsApi.getNewsList();
    }
}