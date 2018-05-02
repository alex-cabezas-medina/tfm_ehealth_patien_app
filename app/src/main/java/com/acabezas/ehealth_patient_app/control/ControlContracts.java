package com.acabezas.ehealth_patient_app.control;

/**
 * Created by alexandercabezas on 9/4/18.
 */

public class ControlContracts {

    interface View {
        void onDestroy();
    }

    interface Presenter {
        void onDestroy();
        void goToSplashScreen();
    }

    interface Interactor {
        void unRegister();
    }

    interface InteractorOutput {
    }


    interface Router {
        void unRegister();
        void presentSplashScreen();
    }

}
