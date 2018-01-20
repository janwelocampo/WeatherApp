package com.dstudio.janwelocampo.mvparchitecture.ui.dashboard.listfragment;

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
 * Created by Janwel Ocampo on 19/01/2018.
 */

public class ListFragmentPresenterImp implements ListFragmentPresenter {

    @Inject
    ApiInterface apiInterface;

    @Inject
    DatabaseHelper databaseHelper;

    private ListFragmentView listFragmentView;

    public ListFragmentPresenterImp(Context context) {
        ((MvpApp) context).getAppComponent(context).inject(this);
    }

    @Override
    public void onAttachView(MvpView view) {
        listFragmentView = (ListFragmentView) view;
    }

    @Override
    public void onDetach() {

    }

    @Override
    public void getWeatherList() {
        listFragmentView.showLoading();

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
                        listFragmentView.hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        listFragmentView.hideLoading();
                        if (e instanceof NoNetworkException) {
                            try {
                                listFragmentView.populateWeatherList(DatabaseParser.populateWeatherOffline(databaseHelper));
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                            listFragmentView.noInternetConnection();
                        }
                        else
                        {
                            listFragmentView.onError(e.getLocalizedMessage());
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

                        listFragmentView.populateWeatherList(cityList.getCityList());
                    }
                }) ;

    }

    @Override
    public void onClickWeatherDetail(int position) {
        listFragmentView.onWeatherDetail(position);
    }
}
