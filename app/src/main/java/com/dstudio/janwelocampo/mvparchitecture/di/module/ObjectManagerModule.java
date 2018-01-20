package com.dstudio.janwelocampo.mvparchitecture.di.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.dstudio.janwelocampo.mvparchitecture.data.database.DatabaseHelper;
import com.dstudio.janwelocampo.mvparchitecture.data.prefs.ObjectManager;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Janwel Ocampo on 18/01/2018.
 */

@Module
public class ObjectManagerModule {
    @Singleton
    @Provides
    public SharedPreferences provideSharedPreferences(Context context){
        return context.getSharedPreferences(context.getPackageName(),Context.MODE_PRIVATE);
    }

    @Singleton @Provides
    public Gson provideGson(){
        return new Gson();
    }

    @Singleton @Provides
    public ObjectManager provideObjectManager(SharedPreferences sharedPreferences, Gson gson){
        return new ObjectManager(sharedPreferences, gson);
    }

    @Singleton @Provides
    public DatabaseHelper provideDatabaseHelper(Context context){
        return new DatabaseHelper(context);
    }
}