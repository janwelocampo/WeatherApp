package com.dstudio.janwelocampo.mvparchitecture.ui.dashboard;

import android.content.Context;

import com.dstudio.janwelocampo.mvparchitecture.MvpApp;
import com.dstudio.janwelocampo.mvparchitecture.data.api.model.city.CityList;
import com.dstudio.janwelocampo.mvparchitecture.data.api.network.NoNetworkException;
import com.dstudio.janwelocampo.mvparchitecture.data.api.retrofit.ApiInterface;
import com.dstudio.janwelocampo.mvparchitecture.data.database.DatabaseHelper;
import com.dstudio.janwelocampo.mvparchitecture.data.database.DatabaseParser;
import com.dstudio.janwelocampo.mvparchitecture.ui.base.MvpView;
import com.dstudio.janwelocampo.mvparchitecture.utils.AppConstants;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Janwel Ocampo on 18/01/2018.
 */

public class MainActivityPresenterImp implements MainActivityPresenter  {
    @Inject
    ApiInterface apiInterface;

    @Inject
    DatabaseHelper databaseHelper;


    private MainActivityView mainActivityView;

    public MainActivityPresenterImp(Context context) {
        ((MvpApp) context).getAppComponent(context).inject(this);
    }

    @Override
    public void onAttachView(MvpView view) {
        this.mainActivityView = (MainActivityView) view;
    }

    @Override
    public void onDetach() {

    }

    @Override
    public void getWeatherData(){
        mainActivityView.showLoading();

        Map<String, String> params = new HashMap<>();
        params.put(ApiInterface.APP_ID, AppConstants.WEATHER_MAP_API_KEY);
        params.put(ApiInterface.ID, AppConstants.LONDON_ID + ","
                        + AppConstants.PRAGUE_ID + ","
                        + AppConstants.SAN_FRANCISCO_ID);

        apiInterface.getWeatherGroup(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CityList>() {
                    @Override
                    public void onCompleted() {
                        mainActivityView.hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mainActivityView.hideLoading();
                        if (e instanceof NoNetworkException) {
                            try {
                                mainActivityView.populateCityWeatherList(DatabaseParser.populateWeatherOffline(databaseHelper));
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                            mainActivityView.noInternetConnection();
                        }
                        else
                        {
                            mainActivityView.onError(e.getLocalizedMessage());
                        }
                    }

                    @Override
                    public void onNext(CityList cityList) {
                        //for Offline saving
                        try {
                            DatabaseParser.saveWeatherData(databaseHelper,cityList);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        mainActivityView.populateCityWeatherList(cityList.getCityList());
                    }
                }) ;

    }


}
