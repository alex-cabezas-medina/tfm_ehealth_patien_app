package com.acabezas.ehealth_patient_app.home;

/**
 * Created by alexandercabezas on 16/4/18.
 */

public class HomeContracts {

    interface View {
        void onDestroy();
        void showError();
    }

    interface Presenter {
        void onDestroy();
        void goToScheduleAppointment();
        void goToVideoConference();
        void goToScheduledAppointments();
    }

    interface Interactor {
        void unRegister();
    }

    interface InteractorOutput {
    }


    interface Router {
        void unRegister();
        void goToScheduleAppointment();
        void goToVideoConference();
        void goToScheduledAppointments();
    }
}
