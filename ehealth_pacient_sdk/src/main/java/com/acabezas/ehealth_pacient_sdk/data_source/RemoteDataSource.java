package com.acabezas.ehealth_pacient_sdk.data_source;

import com.acabezas.ehealth_pacient_sdk.callbacks.GetScheduledAppointmentsCallback;
import com.acabezas.ehealth_pacient_sdk.callbacks.GetUserProfileDataCallback;
import com.acabezas.ehealth_pacient_sdk.callbacks.LoginPacientCallback;
import com.acabezas.ehealth_pacient_sdk.callbacks.RateEvisitCallback;
import com.acabezas.ehealth_pacient_sdk.callbacks.RecoverPasswordCallback;
import com.acabezas.ehealth_pacient_sdk.callbacks.ScheduleAppointmentCallback;
import com.acabezas.ehealth_pacient_sdk.callbacks.SignUpPacientCallback;
import com.acabezas.ehealth_pacient_sdk.callbacks.UpdateUserProfileDataCallback;
import com.acabezas.ehealth_pacient_sdk.model.LoginRequest;
import com.acabezas.ehealth_pacient_sdk.model.RateData;
import com.acabezas.ehealth_pacient_sdk.model.RecoverPasswordRequest;
import com.acabezas.ehealth_pacient_sdk.model.ScheduleAppointmentRequest;
import com.acabezas.ehealth_pacient_sdk.model.SignUpRequest;
import com.acabezas.ehealth_pacient_sdk.model.UpdateProfileRequest;

/**
 * Created by alexandercabezas on 1/5/18.
 */

public class RemoteDataSource implements PacientDataSource{

    @Override
    public void signUpPacient(SignUpRequest request, SignUpPacientCallback callback) {

        callback.success();
    }

    @Override
    public void loginPacient(LoginRequest request, LoginPacientCallback callback) {

    }

    @Override
    public void recoverPassword(RecoverPasswordRequest request, RecoverPasswordCallback callback) {

    }

    @Override
    public void rateEvisit(RateData request, RateEvisitCallback callback) {

    }

    @Override
    public void scheduleAppointment(ScheduleAppointmentRequest request, ScheduleAppointmentCallback callback) {

    }

    @Override
    public void getScheduledAppointments(GetScheduledAppointmentsCallback callback) {

    }

    @Override
    public void getUserProfileData(GetUserProfileDataCallback callback) {

    }

    @Override
    public void updateUserProfileData(UpdateProfileRequest request, UpdateUserProfileDataCallback callback) {

    }
}
