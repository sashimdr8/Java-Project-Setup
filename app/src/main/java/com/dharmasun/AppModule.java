package com.dharmasun;

import android.content.Context;

import com.dharmasun.data.AppData;
import com.dharmasun.data.local.AppPrefs;
import com.dharmasun.data.local.LocalRepo;
import com.dharmasun.data.remote.Api;
import com.dharmasun.data.remote.BaseResponseConverter;
import com.dharmasun.data.remote.RemoteRepo;
import com.dharmasun.data.remote.Urls;
import com.dharmasun.utils.TypeFaceProvider;
import com.dharmasun.utils.rx.RxBus;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by brain on 1/8/18.
 */

@Module
public class AppModule {

    private final Context app;

    AppModule(Context app) {
        this.app = app;
    }

    @Provides
    Context provideContext() {
        return app;
    }

    @Provides
    @Singleton
    RxBus provideBus() {
        return new RxBus();
    }

    @Provides
    @Singleton
    Gson gson() {
        return new Gson();
    }

    @Provides
    @Singleton
    AppPrefs providePrefs(Gson gson) {
        return new AppPrefs(app, gson);
    }


    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client, Gson gson) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(new BaseResponseConverter())
//                .addConverterFactory(ScalarsConverterFactory.create())//To convert primitive and boxed types
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    RemoteRepo provideRemoteRepo(Api api, Gson gson) {
        return new RemoteRepo(api, gson);
    }

    @Provides
    @Singleton
    AppData provideData(LocalRepo localRepo, RemoteRepo remoteRepo) {
        return new AppData(localRepo, remoteRepo);
    }

    @Provides
    @Singleton
    TypeFaceProvider getTypefaceProvider() {
        return new TypeFaceProvider(app);
    }

}
