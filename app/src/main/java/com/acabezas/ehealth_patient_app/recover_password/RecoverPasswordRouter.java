package com.acabezas.ehealth_patient_app.recover_password;

import android.app.Activity;

import com.acabezas.ehealth_patient_app.login.LoginActivity;

/**
 * Created by alexandercabezas on 14/4/18.
 */

public class RecoverPasswordRouter implements RecoverPasswordContracts.Router{
    private Activity activity;

    public RecoverPasswordRouter(Activity activity) {
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
}
