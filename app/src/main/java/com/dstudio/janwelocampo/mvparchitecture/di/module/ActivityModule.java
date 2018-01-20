package com.dstudio.janwelocampo.mvparchitecture.di.module;

import android.content.Context;

import com.dstudio.janwelocampo.mvparchitecture.ui.dashboard.MainActivityPresenter;
import com.dstudio.janwelocampo.mvparchitecture.ui.dashboard.MainActivityPresenterImp;
import com.dstudio.janwelocampo.mvparchitecture.ui.dashboard.listfragment.ListFragmentPresenter;
import com.dstudio.janwelocampo.mvparchitecture.ui.dashboard.listfragment.ListFragmentPresenterImp;
import com.dstudio.janwelocampo.mvparchitecture.ui.dashboard.refreshfragment.RefreshFragmentPresenter;
import com.dstudio.janwelocampo.mvparchitecture.ui.dashboard.refreshfragment.RefreshFragmentPresenterImp;
import com.dstudio.janwelocampo.mvparchitecture.ui.detail.DetailActivityPresenter;
import com.dstudio.janwelocampo.mvparchitecture.ui.detail.DetailActivityPresenterImp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Janwel Ocampo on 18/01/2018.
 */

@Module
public class ActivityModule {
    @Provides
    @Singleton
    MainActivityPresenter provideMainActivityPresenter(Context context) {
        return new MainActivityPresenterImp(context);
    }

    @Provides
    @Singleton
    ListFragmentPresenter provideListFragmentPresenter(Context context) {
        return new ListFragmentPresenterImp(context);
    }

    @Provides
    @Singleton
    RefreshFragmentPresenter provideRefreshFragmentPresenter(Context context) {
        return new RefreshFragmentPresenterImp(context);
    }

    @Provides
    @Singleton
    DetailActivityPresenter provideDetailActivityPresenter(Context context) {
        return new DetailActivityPresenterImp(context);
    }
}
