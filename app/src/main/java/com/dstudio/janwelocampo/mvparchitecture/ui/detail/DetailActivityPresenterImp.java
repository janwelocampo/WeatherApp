package com.dstudio.janwelocampo.mvparchitecture.ui.detail;

import android.content.Context;

import com.dstudio.janwelocampo.mvparchitecture.MvpApp;
import com.dstudio.janwelocampo.mvparchitecture.data.api.model.city.City;
import com.dstudio.janwelocampo.mvparchitecture.data.database.DatabaseHelper;
import com.dstudio.janwelocampo.mvparchitecture.data.database.DatabaseParser;
import com.dstudio.janwelocampo.mvparchitecture.ui.base.MvpView;

import java.sql.SQLException;

import javax.inject.Inject;

/**
 * Created by Janwel Ocampo on 20/01/2018.
 */

public class DetailActivityPresenterImp implements DetailActivityPresenter {

    @Inject
    DatabaseHelper databaseHelper;

    private DetailActivityView detailActivityView;

    public DetailActivityPresenterImp(Context context) {
        ((MvpApp) context).getAppComponent(context).inject(this);
    }

    @Override
    public void onAttachView(MvpView view) {
        detailActivityView = (DetailActivityView) view;
    }

    @Override
    public void onDetach() {

    }


    @Override
    public void getWeatherDataDetails(int cityId) {
        try {
            City city = DatabaseParser.getCity(cityId, databaseHelper);
            detailActivityView.weatherDataDetails(city);

        } catch (SQLException e) {
            e.printStackTrace();
            detailActivityView.onError(e.getLocalizedMessage());
        }
    }
}
