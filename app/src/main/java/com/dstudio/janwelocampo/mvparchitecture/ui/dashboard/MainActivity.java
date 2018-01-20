package com.dstudio.janwelocampo.mvparchitecture.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.dstudio.janwelocampo.mvparchitecture.MvpApp;
import com.dstudio.janwelocampo.mvparchitecture.R;
import com.dstudio.janwelocampo.mvparchitecture.data.api.model.city.City;
import com.dstudio.janwelocampo.mvparchitecture.ui.dashboard.listfragment.ListFragment;
import com.dstudio.janwelocampo.mvparchitecture.ui.dashboard.refreshfragment.RefreshFragment;
import com.dstudio.janwelocampo.mvparchitecture.utils.PermissionsDelegate;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityView, RefreshListener{

    @Inject
    MainActivityPresenter mainActivityPresenter;

    @BindView(R.id.container_refresh)
    FrameLayout containerRefresh;

    @BindView(R.id.container_list)
    FrameLayout containerList;

    private boolean hasExternalPermission;
    private final PermissionsDelegate permissionsDelegate = new PermissionsDelegate(this);

    private ListFragment listFragment;
    private RefreshFragment refreshFragment;

    public static void startAsIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MvpApp) getApplication()).getAppComponent(this).inject(this);
        ButterKnife.bind(this);

        mainActivityPresenter.onAttachView(this);

        hasExternalPermission = permissionsDelegate.hasExternalStoragePermission();
        if (!hasExternalPermission) {
            permissionsDelegate.requestExternalStoragePermission();
        }


        listFragment = new ListFragment();
        refreshFragment = new RefreshFragment();

        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(containerRefresh.getId(), refreshFragment, "Refresh_Tag");
        transaction.add(containerList.getId(), listFragment, "List_Tag");

        transaction.commit();

    }



    @Override
    protected void onResume() {
        super.onResume();

    }


    @Override
    public void initRefresh() {
        listFragment.requestRefreshList();
    }

    @Override
    public void populateCityWeatherList(List<City> cityList) {
        Log.v("TAG", ""+cityList.size());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (permissionsDelegate.resultGranted(requestCode, permissions, grantResults)) {

        }
        else {
            permissionsDelegate.requestExternalStoragePermission();
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {
    }

    @Override
    public void onError(int resId) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMessage(int resId) {

    }

    @Override
    public void noInternetConnection() {
        Toast.makeText(this,""+getString(R.string.no_internet_connection), Toast.LENGTH_SHORT).show();
    }



}
