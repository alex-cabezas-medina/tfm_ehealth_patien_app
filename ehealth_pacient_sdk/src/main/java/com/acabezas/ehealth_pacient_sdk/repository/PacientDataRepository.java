package com.acabezas.ehealth_pacient_sdk.repository;

import com.acabezas.ehealth_pacient_sdk.callbacks.GetScheduledAppointmentsCallback;
import com.acabezas.ehealth_pacient_sdk.callbacks.LoginPacientCallback;
import com.acabezas.ehealth_pacient_sdk.callbacks.RateEvisitCallback;
import com.acabezas.ehealth_pacient_sdk.callbacks.RecoverPasswordCallback;
import com.acabezas.ehealth_pacient_sdk.callbacks.ScheduleAppointmentCallback;
import com.acabezas.ehealth_pacient_sdk.callbacks.SignUpPacientCallback;
import com.acabezas.ehealth_pacient_sdk.data_source.PacientDataSource;
import com.acabezas.ehealth_pacient_sdk.factory.PacientDataFactory;
import com.acabezas.ehealth_pacient_sdk.model.LoginRequest;
import com.acabezas.ehealth_pacient_sdk.model.RateData;
import com.acabezas.ehealth_pacient_sdk.model.RecoverPasswordRequest;
import com.acabezas.ehealth_pacient_sdk.model.ScheduleAppointmentRequest;
import com.acabezas.ehealth_pacient_sdk.model.SignUpRequest;

/**
 * Created by alexandercabezas on 16/4/18.
 */

public class PacientDataRepository implements PacientRepository {

    private static PacientDataRepository sRepository;

    private PacientDataRepository() {
    }

    public static PacientRepository getInstance() {
        if (sRepository == null) {
            sRepository = new PacientDataRepository();
        }

        return sRepository;
    }

    @Override
    public void signUpPacient(SignUpRequest request, SignUpPacientCallback callback) {
        PacientDataSource pacientDataStore = PacientDataFactory.create();
        pacientDataStore.signUpPacient(request, callback);
    }

    @Override
    public void loginPacient(LoginRequest request, LoginPacientCallback callback) {
        PacientDataSource pacientDataStore = PacientDataFactory.create();
        pacientDataStore.loginPacient(request, callback);
    }

    @Override
    public void recoverPassword(RecoverPasswordRequest request, RecoverPasswordCallback callback) {
        PacientDataSource pacientDataStore = PacientDataFactory.create();
        pacientDataStore.recoverPassword(request, callback);
    }

    @Override
    public void rateEvisit(RateData request, RateEvisitCallback callback) {
        PacientDataSource pacientDataStore = PacientDataFactory.create();
        pacientDataStore.rateEvisit(request, callback);
    }

    @Override
    public void scheduleAppointment(ScheduleAppointmentRequest request, ScheduleAppointmentCallback callback) {
        PacientDataSource pacientDataStore = PacientDataFactory.create();
        pacientDataStore.scheduleAppointment(request, callback);
    }

    @Override
    public void getScheduledAppointments(GetScheduledAppointmentsCallback callback) {
        PacientDataSource pacientDataStore = PacientDataFactory.create();
        pacientDataStore.getScheduledAppointments(callback);
    }
}
