package com.dstudio.janwelocampo.mvparchitecture.di.module;

import android.content.Context;

import com.dstudio.janwelocampo.mvparchitecture.utils.AppConstants;
import com.dstudio.janwelocampo.mvparchitecture.data.api.network.NetworkInterceptor;
import com.dstudio.janwelocampo.mvparchitecture.data.api.retrofit.ApiInterface;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Janwel Ocampo on 18/01/2018.
 */
@Module
public class APIModule {
    private static final String NAME_BASE_URL = AppConstants.BASE_URL;

    @Provides
    @Named(NAME_BASE_URL)
    String provideBaseUrlString() {
        return AppConstants.BASE_URL;
    }

    @Provides
    @Singleton
    Converter.Factory provideGsonConverter() {
        return GsonConverterFactory.create();
    }


    @Provides
    OkHttpClient provideOkHttpClient(Context context) {
        return new OkHttpClient.Builder()
                .addInterceptor(new NetworkInterceptor(context)).build();
    }


    @Provides
    @Singleton
    RxJavaCallAdapterFactory provideCallAdapterFactory(){return RxJavaCallAdapterFactory.create();}


    @Provides
    @Singleton
    Retrofit provideRetrofit(Converter.Factory converter, RxJavaCallAdapterFactory factory, @Named(NAME_BASE_URL) String baseUrl, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(converter)
                .addCallAdapterFactory(factory)
                .build();
    }

    @Provides
    @Singleton
    ApiInterface provideRetrofitAPI(Retrofit retrofit) {
        return retrofit.create(ApiInterface.class);
    }
}
