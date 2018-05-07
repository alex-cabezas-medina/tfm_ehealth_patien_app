package com.acabezas.ehealth_patient_app.login;

import com.acabezas.ehealth_pacient_sdk.model.LoginRequest;

/**
 * Created by alexandercabezas on 11/4/18.
 */

public class LoginContracts {

    interface View {
        void onDestroy();
        void showError(int error);
    }

    interface Presenter {
        void onDestroy();
        void goToHomeScreen();
        void goToRegisterScreen();
        void goToRecoverPasswordScreen();
        void doLogin(String username, String password);
    }

    interface Interactor {
        void unRegister();
        void doLogin(LoginRequest request);
    }

    interface InteractorOutput {
        void loginSuccess();
        void loginFailed();
    }


    interface Router {
        void unRegister();
        void presentHomeScreen();
        void presentRegisterScreen();
        void presentRecoverPasswordScreen();
    }
}
