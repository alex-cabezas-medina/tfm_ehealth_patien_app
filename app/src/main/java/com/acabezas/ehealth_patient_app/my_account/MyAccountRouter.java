package com.acabezas.ehealth_patient_app.my_account;

import android.app.Activity;

import com.acabezas.ehealth_patient_app.home.HomeActivity;

/**
 * Created by alexandercabezas on 3/5/18.
 */

public class MyAccountRouter implements MyAccountContracts.Router{
    private Activity activity;

    public MyAccountRouter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void unRegister() {

    }

    @Override
    public void presentHomeScreen() {
        HomeActivity.startHomectivity(activity);
    }
}
