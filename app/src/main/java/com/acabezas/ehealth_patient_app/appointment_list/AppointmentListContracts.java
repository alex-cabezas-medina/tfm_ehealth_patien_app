package com.acabezas.ehealth_patient_app.appointment_list;

import com.acabezas.ehealth_pacient_sdk.model.ScheduledAppointmentData;

import java.util.List;

/**
 * Created by alexandercabezas on 16/4/18.
 */

public class AppointmentListContracts {

    interface View {
        void onDestroy();
        void showError();
        void showSuccess();
        void updateAdapter(List<ScheduledAppointmentData> data);
    }

    interface Presenter {
        void onDestroy();
        void getAppointmentList();
    }

    interface Interactor {
        void unRegister();
        void getAppointmentList();
    }

    interface InteractorOutput {
        void scheduledAppointmentsSuccess(List<ScheduledAppointmentData> data);
        void scheduledAppointmentsFailure();
    }


    interface Router {
        void unRegister();
    }
}
