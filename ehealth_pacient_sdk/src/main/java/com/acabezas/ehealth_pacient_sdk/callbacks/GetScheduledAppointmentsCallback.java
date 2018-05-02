package com.acabezas.ehealth_pacient_sdk.callbacks;

import com.acabezas.ehealth_pacient_sdk.model.ScheduledAppointmentData;

import java.util.List;

/**
 * Created by alexandercabezas on 2/5/18.
 */

public interface GetScheduledAppointmentsCallback {

    void success(List<ScheduledAppointmentData> data);

    void failure();
}
