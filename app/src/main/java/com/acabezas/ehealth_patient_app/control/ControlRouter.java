package com.acabezas.ehealth_patient_app.control;

import android.app.Activity;

import com.acabezas.ehealth_patient_app.splash.SplashActivity;

/**
 * Created by alexandercabezas on 9/4/18.
 */

public class ControlRouter implements ControlContracts.Router {
    private Activity activity;

    public ControlRouter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void unRegister() {
        activity = null;
    }

    @Override
    public void presentSplashScreen() {
        SplashActivity.startSplashActivity(activity);
    }
}
