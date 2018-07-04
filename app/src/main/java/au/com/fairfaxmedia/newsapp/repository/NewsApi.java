package au.com.fairfaxmedia.newsapp.repository;

import io.reactivex.Observable;
import au.com.fairfaxmedia.newsapp.model.NewsList;
import retrofit2.http.GET;

public interface NewsApi {
    @GET("coding_test/13ZZQX/full")
    Observable<NewsList> getNewsList();
}