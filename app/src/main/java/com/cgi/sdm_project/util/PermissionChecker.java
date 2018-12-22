package com.cgi.sdm_project.util;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

public class PermissionChecker {
    public static final int MY_PERMISSIONS_CAMARA = 1;
    public static final String CAMARA_LOC = Manifest.permission.CAMERA;

    private static PermissionChecker instance;

    private boolean cameraPermissionGranted;

    private PermissionChecker() {

    }

    public static PermissionChecker getInstance() {
        if (instance == null)
            instance = new PermissionChecker();
        return instance;
    }

    public boolean isCameraPermissionGranted() {
        return cameraPermissionGranted;
    }

    public void pedirPermisos(String permiso, int codigo, Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, permiso) == PackageManager.PERMISSION_GRANTED) {
            cameraPermissionGranted = true;
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{permiso}, codigo);
        }
    }

    /**
     * Handles the result of the request for location permissions.
     */
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_CAMARA: {
                cameraPermissionGranted = grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED;
            }
        }
    }
}
