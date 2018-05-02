package com.acabezas.ehealth_patient_app.rate;

import android.app.Activity;

import com.acabezas.ehealth_patient_app.home.HomeActivity;

/**
 * Created by alexandercabezas on 14/4/18.
 */

public class RateRouter implements RateContracts.Router{
    private Activity activity;

    public RateRouter(Activity activity) {
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
