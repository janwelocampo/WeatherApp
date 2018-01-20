package com.dstudio.janwelocampo.mvparchitecture;

import android.app.Application;
import android.content.Context;

import com.dstudio.janwelocampo.mvparchitecture.di.component.AppComponent;
import com.dstudio.janwelocampo.mvparchitecture.di.component.DaggerAppComponent;
import com.dstudio.janwelocampo.mvparchitecture.di.module.AppModule;

/**
 * Created by Janwel Ocampo on 18/01/2018.
 */

public class MvpApp extends Application {

    private AppComponent component;

    protected AppComponent createComponent() {
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        return component;
    }

    public static AppComponent getAppComponent(Context context) {
        MvpApp app = (MvpApp) context.getApplicationContext();
        if (app.component == null) {
            app.component = app.createComponent();
        }
        return app.component;
    }
}
