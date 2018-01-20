package com.dstudio.janwelocampo.mvparchitecture.di.component;

import com.dstudio.janwelocampo.mvparchitecture.di.module.APIModule;
import com.dstudio.janwelocampo.mvparchitecture.di.module.ActivityModule;
import com.dstudio.janwelocampo.mvparchitecture.di.module.AppModule;
import com.dstudio.janwelocampo.mvparchitecture.di.module.ObjectManagerModule;
import com.dstudio.janwelocampo.mvparchitecture.ui.dashboard.MainActivity;
import com.dstudio.janwelocampo.mvparchitecture.ui.dashboard.MainActivityPresenterImp;
import com.dstudio.janwelocampo.mvparchitecture.ui.dashboard.listfragment.ListFragment;
import com.dstudio.janwelocampo.mvparchitecture.ui.dashboard.listfragment.ListFragmentPresenterImp;
import com.dstudio.janwelocampo.mvparchitecture.ui.dashboard.refreshfragment.RefreshFragment;
import com.dstudio.janwelocampo.mvparchitecture.ui.dashboard.refreshfragment.RefreshFragmentPresenterImp;
import com.dstudio.janwelocampo.mvparchitecture.ui.detail.DetailActivity;
import com.dstudio.janwelocampo.mvparchitecture.ui.detail.DetailActivityPresenterImp;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Janwel Ocampo on 18/01/2018.
 */

@Singleton
@Component(modules = {AppModule.class, ActivityModule.class, APIModule.class, ObjectManagerModule.class})
public interface AppComponent {

    //Main Activity
    void inject(MainActivity target);
    void inject(MainActivityPresenterImp target);

    //Detail Activity
    void inject(DetailActivity target);
    void inject(DetailActivityPresenterImp target);

    //List Fragment
    void inject(ListFragment target);
    void inject(ListFragmentPresenterImp target);

    //Refresh Fragment
    void inject(RefreshFragment target);
    void inject(RefreshFragmentPresenterImp target);
}
