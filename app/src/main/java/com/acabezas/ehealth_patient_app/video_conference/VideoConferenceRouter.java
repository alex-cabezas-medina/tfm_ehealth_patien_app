package com.acabezas.ehealth_patient_app.video_conference;

import android.app.Activity;

import com.acabezas.ehealth_patient_app.home.HomeActivity;
import com.acabezas.ehealth_patient_app.rate.RateActivity;

/**
 * Created by alexandercabezas on 14/4/18.
 */

public class VideoConferenceRouter implements VideoConferenceContracts.Router{

    private Activity activity;

    public VideoConferenceRouter(Activity activity) {
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
    public void presentRateScreen() {
        RateActivity.startRateActivity(activity);
    }
}
