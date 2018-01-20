package com.dstudio.janwelocampo.mvparchitecture.ui.base;

/**
 * Created by Janwel Ocampo on 18/01/2018.
 */

public interface MvpPresenter  {

    void onAttachView(MvpView view);

    void onDetach();
}
