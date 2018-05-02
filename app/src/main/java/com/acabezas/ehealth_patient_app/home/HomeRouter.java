package com.acabezas.ehealth_patient_app.home;

import android.app.Activity;

import com.acabezas.ehealth_patient_app.appointment_list.AppointmentListActivity;
import com.acabezas.ehealth_patient_app.schedule_appointment.ScheduleAppointmentActivity;
import com.acabezas.ehealth_patient_app.video_conference.VideoConferenceActivity;

/**
 * Created by alexandercabezas on 16/4/18.
 */

public class HomeRouter implements HomeContracts.Router{

    private Activity activity;

    public HomeRouter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void unRegister() {

    }

    @Override
    public void goToScheduleAppointment() {
        ScheduleAppointmentActivity.startScheduleAppointmentActivity(activity);
    }

    @Override
    public void goToVideoConference() {
        VideoConferenceActivity.startVideoConferenceActivity(activity);
    }

    @Override
    public void goToScheduledAppointments() {
        AppointmentListActivity.startAppointmentListActivity(activity);
    }
}
