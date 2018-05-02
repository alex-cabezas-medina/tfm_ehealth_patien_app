package com.acabezas.ehealth_patient_app.login;

import android.app.Activity;

import com.acabezas.ehealth_patient_app.home.HomeActivity;
import com.acabezas.ehealth_patient_app.recover_password.RecoverPasswordActivity;
import com.acabezas.ehealth_patient_app.registration.SignUpActivity;

/**
 * Created by alexandercabezas on 11/4/18.
 */

public class LoginRouter implements LoginContracts.Router{

    private Activity activity;

    public LoginRouter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void unRegister() {
        activity = null;
    }

    @Override
    public void presentHomeScreen() {
        HomeActivity.startHomectivity(activity);
    }

    @Override
    public void presentRegisterScreen() {
        SignUpActivity.startSignUpActivity(activity);
    }

    @Override
    public void presentRecoverPasswordScreen() {
        RecoverPasswordActivity.startRecoverPasswordActivity(activity);
    }
}
