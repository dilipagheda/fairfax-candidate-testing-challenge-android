package au.com.fairfaxmedia.newsapp.usecase;

import java.util.Collections;
import java.util.List;

import au.com.fairfaxmedia.newsapp.model.Asset;
import au.com.fairfaxmedia.newsapp.model.NewsList;
import au.com.fairfaxmedia.newsapp.repository.RemoteDataSource;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * This Use case class sits between the presenter and the repository in Clean Architecture.
 * It handles domain related business logic by interacting with LocalDataSource, RemoteDataSource or SharedPreferences, etc
 */
public class NewsListUseCase {

    private RemoteDataSource mRemoteDataSource;

    public NewsListUseCase(RemoteDataSource remoteDataSource) {
        mRemoteDataSource = remoteDataSource;
    }

    public Observable<List<Asset>> loadFromRemoteDataSource() {
        return mRemoteDataSource.getNewsList()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .map(NewsList::getAssets)
                .map(assets -> { // sort assets by timestamp for newest one to come first
                    Collections.sort(assets, (Asset t1, Asset t2) -> (int) (t2.getTimeStamp() - t1.getTimeStamp()));
                    return assets;
                })
                .observeOn(AndroidSchedulers.mainThread());
    }
}