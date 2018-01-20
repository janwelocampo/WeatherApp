package com.dstudio.janwelocampo.mvparchitecture.ui.dashboard.refreshfragment;

import com.dstudio.janwelocampo.mvparchitecture.ui.base.MvpPresenter;

/**
 * Created by Janwel Ocampo on 19/01/2018.
 */

public interface RefreshFragmentPresenter extends MvpPresenter{

    void onClickRefresh();

    void onClickCopy();
}
