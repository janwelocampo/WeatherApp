package com.dstudio.janwelocampo.mvparchitecture.ui.detail;

import com.dstudio.janwelocampo.mvparchitecture.ui.base.MvpPresenter;

/**
 * Created by Janwel Ocampo on 18/01/2018.
 */

public interface DetailActivityPresenter extends MvpPresenter {
    void getWeatherDataDetails(int cityId);
}

