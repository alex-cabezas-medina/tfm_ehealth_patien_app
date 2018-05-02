package com.acabezas.ehealth_patient_app.schedule_appointment;

import com.acabezas.ehealth_pacient_sdk.model.ScheduleAppointmentRequest;

/**
 * Created by alexandercabezas on 16/4/18.
 */

public class ScheduleAppointmentContracts {

    interface View {
        void onDestroy();
        void showError();
        void showSuccess();
    }

    interface Presenter {
        void onDestroy();
        void scheduleAppointment(String date, String time, String doctor, String specialty);
    }

    interface Interactor {
        void unRegister();
        void scheduleAppointment(ScheduleAppointmentRequest request);
    }

    interface InteractorOutput {
        void scheduleSuccess();
        void scheduleFailed();
    }


    interface Router {
        void unRegister();
    }
}
