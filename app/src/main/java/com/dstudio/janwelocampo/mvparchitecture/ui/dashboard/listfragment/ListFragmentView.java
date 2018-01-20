package com.dstudio.janwelocampo.mvparchitecture.ui.dashboard.listfragment;

import com.dstudio.janwelocampo.mvparchitecture.data.api.model.city.City;
import com.dstudio.janwelocampo.mvparchitecture.ui.base.MvpView;

import java.util.List;

/**
 * Created by Janwel Ocampo on 19/01/2018.
 */

public interface ListFragmentView extends MvpView {

    void populateWeatherList(List<City> cityList);

    void onWeatherDetail(int position);
}
