package com.acabezas.ehealth_patient_app.appointment_list;

import android.app.Activity;

/**
 * Created by alexandercabezas on 16/4/18.
 */

public class AppointmentListRouter implements AppointmentListContracts.Router{

    private Activity activity;

    public AppointmentListRouter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void unRegister() {

    }
}
