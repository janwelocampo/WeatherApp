package com.dstudio.janwelocampo.mvparchitecture.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Janwel Ocampo on 18/01/2018.
 */

@Module
public class AppModule {

    private Application application; public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }
}
