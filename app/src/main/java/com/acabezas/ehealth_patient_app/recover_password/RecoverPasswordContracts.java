package com.acabezas.ehealth_patient_app.recover_password;

import com.acabezas.ehealth_pacient_sdk.model.RecoverPasswordRequest;

/**
 * Created by alexandercabezas on 11/4/18.
 */

public class RecoverPasswordContracts {

    interface View {
        void onDestroy();
        void showError(int error);
        void showSuccess();
    }

    interface Presenter {
        void onDestroy();
        void recoverPassword(String email);
        void goToLoginScreen();
    }

    interface Interactor {
        void unRegister();
        void recoverPassword(RecoverPasswordRequest request);
    }

    interface InteractorOutput {
        void recoverPasswordSuccess();
        void recoverPasswordFailed();
    }


    interface Router {
        void unRegister();
        void presentLoginScreen();
    }
}
