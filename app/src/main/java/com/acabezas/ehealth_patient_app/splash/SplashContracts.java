package com.acabezas.ehealth_patient_app.splash;

/**
 * Created by alexandercabezas on 9/4/18.
 */

public class SplashContracts {

    interface View {
        void onDestroy();
    }

    interface Presenter {
        void onDestroy();
        void showSplash();
        void goToLoginScreen();
        void goToOnboardingScreen();
    }

    interface Interactor {
        void unRegister();
        void handleSplash();
    }

    interface InteractorOutput {
        void endSplash();
    }


    interface Router {
        void unRegister();
        void presentLoginScreen();
        void presentOnboardingScreen();
    }

}
