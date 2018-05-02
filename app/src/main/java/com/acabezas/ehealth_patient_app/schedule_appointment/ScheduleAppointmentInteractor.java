package com.acabezas.ehealth_patient_app.schedule_appointment;

import com.acabezas.ehealth_pacient_sdk.PacientAPI;
import com.acabezas.ehealth_pacient_sdk.PacientAPImpl;
import com.acabezas.ehealth_pacient_sdk.callbacks.ScheduleAppointmentCallback;
import com.acabezas.ehealth_pacient_sdk.model.ScheduleAppointmentRequest;

/**
 * Created by alexandercabezas on 16/4/18.
 */

public class ScheduleAppointmentInteractor implements ScheduleAppointmentContracts.Interactor{
    private ScheduleAppointmentContracts.InteractorOutput output;

    public ScheduleAppointmentInteractor(ScheduleAppointmentContracts.InteractorOutput output) {
        this.output = output;
    }

    @Override
    public void unRegister() {
        output = null;
    }

    @Override
    public void scheduleAppointment(ScheduleAppointmentRequest request) {
        PacientAPImpl.getInstance().scheduleAppointment(request, new ScheduleAppointmentCallback() {
            @Override
            public void success() {
                output.scheduleSuccess();
            }

            @Override
            public void failure() {
                output.scheduleFailed();
            }
        });
    }
}
