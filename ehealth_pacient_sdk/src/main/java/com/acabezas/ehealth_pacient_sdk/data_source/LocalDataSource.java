package com.acabezas.ehealth_pacient_sdk.data_source;

import com.acabezas.ehealth_pacient_sdk.callbacks.GetScheduledAppointmentsCallback;
import com.acabezas.ehealth_pacient_sdk.callbacks.LoginPacientCallback;
import com.acabezas.ehealth_pacient_sdk.callbacks.RateEvisitCallback;
import com.acabezas.ehealth_pacient_sdk.callbacks.RecoverPasswordCallback;
import com.acabezas.ehealth_pacient_sdk.callbacks.ScheduleAppointmentCallback;
import com.acabezas.ehealth_pacient_sdk.callbacks.SignUpPacientCallback;
import com.acabezas.ehealth_pacient_sdk.model.LoginRequest;
import com.acabezas.ehealth_pacient_sdk.model.RateData;
import com.acabezas.ehealth_pacient_sdk.model.RecoverPasswordRequest;
import com.acabezas.ehealth_pacient_sdk.model.ScheduleAppointmentRequest;
import com.acabezas.ehealth_pacient_sdk.model.ScheduledAppointmentData;
import com.acabezas.ehealth_pacient_sdk.model.SignUpRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandercabezas on 16/4/18.
 */

public class LocalDataSource implements PacientDataSource {

    @Override
    public void signUpPacient(SignUpRequest request, SignUpPacientCallback callback) {
        callback.success();
    }

    @Override
    public void loginPacient(LoginRequest request, LoginPacientCallback callback) {
        callback.success();
    }

    @Override
    public void recoverPassword(RecoverPasswordRequest request, RecoverPasswordCallback callback) {
        callback.success();
    }

    @Override
    public void rateEvisit(RateData request, RateEvisitCallback callback) {
        callback.success();
    }

    @Override
    public void scheduleAppointment(ScheduleAppointmentRequest request, ScheduleAppointmentCallback callback) {
        callback.success();
    }

    @Override
    public void getScheduledAppointments(GetScheduledAppointmentsCallback callback) {
        List<ScheduledAppointmentData> data = new ArrayList<>();
        ScheduledAppointmentData item = new ScheduledAppointmentData();
        item.id = "12345";
        item.doctor = "pedro";
        item.specialty = "general";
        item.date = "12/22/2000";
        data.add(item);
        item = new ScheduledAppointmentData();
        item.id = "12346";
        item.doctor = "pedro";
        item.specialty = "general";
        item.date = "12/22/2000";
        data.add(item);
        item = new ScheduledAppointmentData();
        item.id = "12347";
        item.doctor = "pedro";
        item.specialty = "general";
        item.date = "12/22/2000";
        data.add(item);
        item = new ScheduledAppointmentData();
        item.id = "12348";
        item.doctor = "pedro";
        item.specialty = "general";
        item.date = "12/22/2000";
        data.add(item);
        item = new ScheduledAppointmentData();
        item.id = "12349";
        item.doctor = "pedro";
        item.specialty = "general";
        item.date = "12/22/2000";
        data.add(item);
        item = new ScheduledAppointmentData();
        item.id = "12359";
        item.doctor = "pedro";
        item.specialty = "general";
        item.date = "12/22/2000";
        data.add(item);
        item = new ScheduledAppointmentData();
        item.id = "12369";
        item.doctor = "pedro";
        item.specialty = "general";
        item.date = "12/22/2000";
        data.add(item);
        callback.success(data);
    }
}
