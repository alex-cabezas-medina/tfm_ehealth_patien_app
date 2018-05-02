package com.acabezas.ehealth_patient_app.splash;

import android.app.Activity;

import com.acabezas.ehealth_patient_app.login.LoginActivity;

/**
 * Created by alexandercabezas on 9/4/18.
 */

public class SplashRouter implements SplashContracts.Router {
    private Activity activity;

    public SplashRouter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void unRegister() {
        activity = null;
    }

    @Override
    public void presentLoginScreen() {
        LoginActivity.startLoginctivity(activity);
    }

    @Override
    public void presentOnboardingScreen() {

    }
}
