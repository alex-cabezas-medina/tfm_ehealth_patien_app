package com.acabezas.ehealth_patient_app.schedule_appointment;

import android.app.Activity;

/**
 * Created by alexandercabezas on 16/4/18.
 */

public class ScheduleAppointmentRouter implements ScheduleAppointmentContracts.Router{

    private Activity activity;

    public ScheduleAppointmentRouter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void unRegister() {

    }
}
