package com.dstudio.janwelocampo.mvparchitecture.ui.dashboard.listfragment;

import com.dstudio.janwelocampo.mvparchitecture.ui.base.MvpPresenter;

/**
 * Created by Janwel Ocampo on 19/01/2018.
 */

public interface ListFragmentPresenter extends MvpPresenter{

    void getWeatherList();

    void onClickWeatherDetail(int position);
}
