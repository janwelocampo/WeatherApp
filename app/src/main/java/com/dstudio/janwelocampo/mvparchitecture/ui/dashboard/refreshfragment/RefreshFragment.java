package com.dstudio.janwelocampo.mvparchitecture.ui.dashboard.refreshfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.dstudio.janwelocampo.mvparchitecture.MvpApp;
import com.dstudio.janwelocampo.mvparchitecture.R;
import com.dstudio.janwelocampo.mvparchitecture.ui.dashboard.RefreshListener;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Janwel Ocampo on 19/01/2018.
 */

public class RefreshFragment extends Fragment implements RefreshFragmentView, View.OnClickListener{

    @Inject
    RefreshFragmentPresenter refreshFragmentPresenter;

    @BindView(R.id.button_copy)
    Button buttonCopy;

    @BindView(R.id.button_refresh)
    Button buttonRefresh;

    private RefreshListener refreshListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_refresh, container,false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MvpApp) getActivity().getApplication()).getAppComponent(getActivity()).inject(this);
        refreshListener = (RefreshListener)getActivity();

        refreshFragmentPresenter.onAttachView(this);

        buttonCopy.setOnClickListener(this);
        buttonRefresh.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.button_copy:
                    refreshFragmentPresenter.onClickCopy();
                    break;
                case R.id.button_refresh:
                    refreshFragmentPresenter.onClickRefresh();
                    break;
            }
    }

    @Override
    public void onListRefresh() {
        refreshListener.initRefresh();
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(int resId) {
        Toast.makeText(getActivity(), getString(resId), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(int resId) {
        Toast.makeText(getActivity(), getString(resId), Toast.LENGTH_LONG).show();
    }

    @Override
    public void noInternetConnection() {

    }



}
