package com.dstudio.janwelocampo.mvparchitecture.ui.dashboard.refreshfragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;

import com.dstudio.janwelocampo.mvparchitecture.MvpApp;
import com.dstudio.janwelocampo.mvparchitecture.R;
import com.dstudio.janwelocampo.mvparchitecture.data.database.DatabaseHelper;
import com.dstudio.janwelocampo.mvparchitecture.ui.base.MvpView;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * Created by Janwel Ocampo on 19/01/2018.
 */

public class RefreshFragmentPresenterImp implements RefreshFragmentPresenter {

    private RefreshFragmentView refreshFragmentView;
    private Context context;
    private FirebaseAnalytics mFirebaseAnalytics;

    public RefreshFragmentPresenterImp(Context context) {
        ((MvpApp) context).getAppComponent(context).inject(this);
        this.context = context;
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);
    }

    @Override
    public void onAttachView(MvpView view) {
        this.refreshFragmentView =(RefreshFragmentView) view;
    }

    @Override
    public void onDetach() {

    }

    @Override
    public void onClickRefresh() {
        refreshFragmentView.onListRefresh();
    }

    @Override
    public void onClickCopy() {
        Bundle params = new Bundle();
        params.putString("userClick", "Copy db");
        mFirebaseAnalytics.logEvent("onClickCopy", params);

        try {
            File sd = Environment.getExternalStorageDirectory();
            File currentDB = context.getDatabasePath(DatabaseHelper.DATABASE_NAME);
            if (sd.canWrite()) {
                File backupDB = new File(sd, "my_data_backup.db");
                if (currentDB.exists()) {
                    FileChannel src = new FileInputStream(currentDB).getChannel();
                    FileChannel dst = new FileOutputStream(backupDB).getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();
                }
                refreshFragmentView.showMessage(R.string.message_local_database);
            }
            else {
                refreshFragmentView.onError(R.string.message_local_database_error_no_permission);
            }
        }catch (Exception e){
            refreshFragmentView.onError(e.getLocalizedMessage());
        }

    }
}
