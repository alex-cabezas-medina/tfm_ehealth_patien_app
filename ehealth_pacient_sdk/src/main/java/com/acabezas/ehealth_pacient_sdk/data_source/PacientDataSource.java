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
 * Created by alexandercabezas on 16/4/18.
 */

public interface PacientDataSource {

    void signUpPacient(SignUpRequest request, SignUpPacientCallback callback);

    void loginPacient(LoginRequest request, LoginPacientCallback callback);

    void recoverPassword(RecoverPasswordRequest request, RecoverPasswordCallback callback);

    void rateEvisit(RateData request, RateEvisitCallback callback);

    void scheduleAppointment(ScheduleAppointmentRequest request, ScheduleAppointmentCallback callback);

    void getScheduledAppointments(GetScheduledAppointmentsCallback callback);

    void getUserProfileData(GetUserProfileDataCallback callback);

    void updateUserProfileData(UpdateProfileRequest request, UpdateUserProfileDataCallback callback);
}
