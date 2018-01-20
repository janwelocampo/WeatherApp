package com.dstudio.janwelocampo.mvparchitecture.ui.dashboard.listfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dstudio.janwelocampo.mvparchitecture.MvpApp;
import com.dstudio.janwelocampo.mvparchitecture.R;
import com.dstudio.janwelocampo.mvparchitecture.data.api.model.city.City;
import com.dstudio.janwelocampo.mvparchitecture.ui.detail.DetailActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Janwel Ocampo on 19/01/2018.
 */

public class ListFragment extends Fragment implements ListFragmentView, AdapterView.OnItemClickListener {

    @Inject
    ListFragmentPresenter listFragmentPresenter;

    @BindView(R.id.progressbar)
    ProgressBar progressBar;

    @BindView(R.id.list_weather)
    ListView listViewWeather;

    private ListWeatherAdapter listWeatherAdapter;
    private List<City> cityList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container,false);
        ButterKnife.bind(this, view);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MvpApp) getActivity().getApplication()).getAppComponent(getActivity()).inject(this);
        listFragmentPresenter.onAttachView(this);

        cityList = new ArrayList<>();
        listWeatherAdapter = new ListWeatherAdapter(getActivity(), R.layout.list_weather, cityList);
        listViewWeather.setAdapter(listWeatherAdapter);

//        LayoutInflater inflater = getLayoutInflater();
//        ViewGroup header = (ViewGroup)inflater.inflate(R.layout.list_weather_header, listViewWeather, false);
//        listViewWeather.addHeaderView(header, null, false);

        listViewWeather.setOnItemClickListener(this);

        listFragmentPresenter.getWeatherList();
    }

    public void requestRefreshList(){
        listFragmentPresenter.getWeatherList();
    }

    @Override
    public void populateWeatherList(List<City> cityList) {
        this.cityList.clear();
        this.cityList.addAll(cityList);

        listWeatherAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        listFragmentPresenter.onClickWeatherDetail(position);
    }

    @Override
    public void onWeatherDetail(int position) {
        int cityId = cityList.get(position).getId();
        DetailActivity.startAsIntent(getActivity(), cityId);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
        listViewWeather.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
        listViewWeather.setVisibility(View.VISIBLE);
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
        Toast.makeText(getActivity(), getString(R.string.no_internet_connection), Toast.LENGTH_LONG).show();
    }



}
