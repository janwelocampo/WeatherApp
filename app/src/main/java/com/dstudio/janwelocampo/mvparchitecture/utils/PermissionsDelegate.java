package com.dstudio.janwelocampo.mvparchitecture.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by Janwel Ocampo on 19/01/2018.
 */

public class PermissionsDelegate {
    private static final int REQUEST_CODE = 10;
    private final Activity activity;

    public PermissionsDelegate(Activity activity) {
        this.activity = activity;
    }

    public boolean hasExternalStoragePermission() {
        int permissionCheckResult = ContextCompat.checkSelfPermission(
                activity, Manifest.permission.WRITE_EXTERNAL_STORAGE
        );
        return permissionCheckResult == PackageManager.PERMISSION_GRANTED;
    }

    public void requestExternalStoragePermission() {
        ActivityCompat.requestPermissions(
                activity,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                REQUEST_CODE
        );
    }

    public boolean resultGranted(int requestCode,
                                 String[] permissions,
                                 int[] grantResults) {

        if (requestCode != REQUEST_CODE) {
            return false;
        }

        if (grantResults.length < 1) {
            return false;
        }
        if (!(permissions[0].equals(Manifest.permission.WRITE_EXTERNAL_STORAGE))) {
            return false;
        }


        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            return true;
        }



        return false;
    }
}
