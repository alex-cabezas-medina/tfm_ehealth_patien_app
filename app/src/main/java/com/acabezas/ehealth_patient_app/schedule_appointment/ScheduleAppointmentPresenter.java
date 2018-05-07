package com.acabezas.ehealth_patient_app.schedule_appointment;

import android.app.Activity;

import com.acabezas.ehealth_pacient_sdk.model.ScheduleAppointmentRequest;

/**
 * Created by alexandercabezas on 16/4/18.
 */

public class ScheduleAppointmentPresenter implements ScheduleAppointmentContracts.Presenter, ScheduleAppointmentContracts.InteractorOutput{
    private ScheduleAppointmentContracts.Interactor interactor;
    private ScheduleAppointmentContracts.Router router;
    private ScheduleAppointmentContracts.View view;

    ScheduleAppointmentPresenter(ScheduleAppointmentContracts.View view) {
        interactor = new ScheduleAppointmentInteractor(this);
        router = new ScheduleAppointmentRouter((Activity) view);
        this.view = view;
    }
    @Override
    public void onDestroy() {
        interactor.unRegister();
        interactor = null;
        router.unRegister();
        router = null;
    }

    @Override
    public void scheduleAppointment(String date, String time, String doctor, String specialty) {

        if(!date.isEmpty() &&
                !time.isEmpty() &&
                !doctor.isEmpty() &&
                !specialty.isEmpty()) {

            //TODO: checj date higher than today
            if(!date.isEmpty()) {
                ScheduleAppointmentRequest request = new ScheduleAppointmentRequest();
                request.date = date;
                request.time = time;
                request.specialty = specialty;
                request.doctor = doctor;
                interactor.scheduleAppointment(request);
            } else {view.showError(2);}

        } else {
            view.showError(3);
        }
    }

    @Override
    public void scheduleSuccess() {
        view.showSuccess();
    }

    @Override
    public void scheduleFailed() {
        view.showError(1);
    }
}
