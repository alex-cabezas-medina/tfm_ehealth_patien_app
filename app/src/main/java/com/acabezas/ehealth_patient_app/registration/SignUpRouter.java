package com.acabezas.ehealth_patient_app.registration;

import android.app.Activity;

import com.acabezas.ehealth_patient_app.home.HomeActivity;
import com.acabezas.ehealth_patient_app.login.LoginActivity;

/**
 * Created by alexandercabezas on 14/4/18.
 */

public class SignUpRouter implements SignUpContracts.Router{
    private Activity activity;

    public SignUpRouter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void unRegister() {

    }

    @Override
    public void presentHomeScreen() {
        HomeActivity.startHomectivity(activity);
    }

    @Override
    public void presentLoginScreen() {
        LoginActivity.startLoginctivity(activity);
    }
}
