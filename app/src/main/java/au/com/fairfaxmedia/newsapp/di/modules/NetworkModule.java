package au.com.fairfaxmedia.newsapp.di.modules;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import au.com.fairfaxmedia.newsapp.BuildConfig;
import au.com.fairfaxmedia.newsapp.repository.NewsApi;
import au.com.fairfaxmedia.newsapp.repository.RemoteDataSource;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    NewsApi provideApiInterface(Retrofit retrofit) {
        return retrofit.create(NewsApi.class);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClientBuilder.addInterceptor(loggingInterceptor);
        }

        httpClientBuilder
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS);

        return httpClientBuilder.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        List<CallAdapter.Factory> factories = new ArrayList<>();
        factories.add(RxJava2CallAdapterFactory.create());

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    RemoteDataSource provideRemoteDataSource(NewsApi newsApi) {
        return new RemoteDataSource(newsApi);
    }
}