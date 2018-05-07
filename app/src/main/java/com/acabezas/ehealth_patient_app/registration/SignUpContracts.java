package com.acabezas.ehealth_patient_app.registration;

import com.acabezas.ehealth_pacient_sdk.model.SignUpRequest;

/**
 * Created by alexandercabezas on 14/4/18.
 */

public class SignUpContracts {

    interface View {
        void onDestroy();
        void showError(int error);
        void showSuccess();
    }

    interface Presenter {
        void onDestroy();
        void goToHomeScreen();
        void goToLoginScreen();
        void doSignUp(String name,
                      String lastname1,
                      String lastname2,
                      String email,
                      String password,
                      String medicines,
                      String allergies,
                      String surgeries);
    }

    interface Interactor {
        void unRegister();
        void doSignUp(SignUpRequest request);
    }

    interface InteractorOutput {
        void sigUpSuccess();
        void signUpFailed();
    }


    interface Router {
        void unRegister();
        void presentHomeScreen();
        void presentLoginScreen();
    }
}
