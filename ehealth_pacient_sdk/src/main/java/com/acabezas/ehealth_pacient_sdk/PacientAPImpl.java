package com.acabezas.ehealth_pacient_sdk;

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
import com.acabezas.ehealth_pacient_sdk.model.SignUpRequest;
import com.acabezas.ehealth_pacient_sdk.repository.PacientDataRepository;

/**
 * Created by alexandercabezas on 16/4/18.
 */

public class PacientAPImpl implements PacientAPI{

    private static PacientAPI mPacient;

    private PacientAPImpl() {
    }

    public static PacientAPI getInstance() {

        if (mPacient == null) {
            mPacient = new PacientAPImpl();
        }

        return mPacient;

    }


    @Override
    public void signUpPacient(SignUpRequest request, SignUpPacientCallback callback) {
        PacientDataRepository.getInstance().signUpPacient(request, callback);
    }

    @Override
    public void loginPacient(LoginRequest request, LoginPacientCallback callback) {
        PacientDataRepository.getInstance().loginPacient(request, callback);
    }

    @Override
    public void recoverPassword(RecoverPasswordRequest request, RecoverPasswordCallback callback) {
        PacientDataRepository.getInstance().recoverPassword(request, callback);
    }

    @Override
    public void rateEvisit(RateData request, RateEvisitCallback callback) {
        PacientDataRepository.getInstance().rateEvisit(request, callback);
    }

    @Override
    public void scheduleAppointment(ScheduleAppointmentRequest request, ScheduleAppointmentCallback callback) {
        PacientDataRepository.getInstance().scheduleAppointment(request, callback);
    }

    @Override
    public void getScheduledAppointments(GetScheduledAppointmentsCallback callback) {
        PacientDataRepository.getInstance().getScheduledAppointments(callback);
    }
}
