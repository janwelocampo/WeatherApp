package com.dstudio.janwelocampo.mvparchitecture.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by Janwel Ocampo on 18/01/2018.
 */

public interface MvpView {
    void showLoading();

    void hideLoading();


    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    void noInternetConnection();
}
