package com.dstudio.janwelocampo.mvparchitecture.ui.dashboard;

import com.dstudio.janwelocampo.mvparchitecture.data.api.model.city.City;
import com.dstudio.janwelocampo.mvparchitecture.ui.base.MvpView;

import java.util.List;

/**
 * Created by Janwel Ocampo on 18/01/2018.
 */

public interface MainActivityView  extends MvpView{

    void populateCityWeatherList(List<City> cityList);
}
