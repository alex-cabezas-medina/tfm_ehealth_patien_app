package com.acabezas.ehealth_patient_app.appointment_list;

import com.acabezas.ehealth_pacient_sdk.PacientAPImpl;
import com.acabezas.ehealth_pacient_sdk.callbacks.GetScheduledAppointmentsCallback;
import com.acabezas.ehealth_pacient_sdk.model.ScheduledAppointmentData;

import java.util.List;

/**
 * Created by alexandercabezas on 16/4/18.
 */

public class AppointmentListInteractor implements AppointmentListContracts.Interactor{

    private AppointmentListContracts.InteractorOutput output;

    public AppointmentListInteractor(AppointmentListContracts.InteractorOutput output) {
        this.output = output;
    }

    @Override
    public void unRegister() {
        output = null;
    }

    @Override
    public void getAppointmentList() {
        PacientAPImpl.getInstance().getScheduledAppointments(new GetScheduledAppointmentsCallback() {
            @Override
            public void success(List<ScheduledAppointmentData> data) {
                output.scheduledAppointmentsSuccess(data);
            }

            @Override
            public void failure() {
                output.scheduledAppointmentsFailure();
            }
        });
    }
}
