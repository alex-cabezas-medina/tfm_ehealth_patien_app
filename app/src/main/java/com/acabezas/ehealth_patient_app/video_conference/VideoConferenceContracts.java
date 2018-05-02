package com.acabezas.ehealth_patient_app.video_conference;

/**
 * Created by alexandercabezas on 14/4/18.
 */

public class VideoConferenceContracts {

    interface View {
        void onDestroy();
        void showError();
    }

    interface Presenter {
        void onDestroy();
        void goToHomeScreen();
        void goToRateScreen();
        void startVideoConference();
    }

    interface Interactor {
        void unRegister();
        void startVideoConference();
    }

    interface InteractorOutput {

    }


    interface Router {
        void unRegister();
        void presentHomeScreen();
        void presentRateScreen();
    }
}
