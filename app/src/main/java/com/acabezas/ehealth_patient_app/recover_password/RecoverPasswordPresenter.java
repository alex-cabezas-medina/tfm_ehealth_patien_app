package com.acabezas.ehealth_patient_app.recover_password;

import android.app.Activity;

import com.acabezas.ehealth_pacient_sdk.model.RecoverPasswordRequest;

/**
 * Created by alexandercabezas on 14/4/18.
 */

public class RecoverPasswordPresenter implements RecoverPasswordContracts.Presenter, RecoverPasswordContracts.InteractorOutput{
    private RecoverPasswordContracts.Interactor interactor;
    private RecoverPasswordContracts.Router router;
    private RecoverPasswordContracts.View view;

    RecoverPasswordPresenter(RecoverPasswordContracts.View view) {
        interactor = new RecoverPasswordInteractor(this);
        router = new RecoverPasswordRouter((Activity) view);
        this.view = view;
    }
    @Override
    public void onDestroy() {
        interactor.unRegister();
        interactor = null;
        router.unRegister();
        router = null;
    }

    @Override
    public void recoverPassword(String email) {
        RecoverPasswordRequest request = new RecoverPasswordRequest();
        request.email = email;
        interactor.recoverPassword(request);
    }

    @Override
    public void goToLoginScreen() {
        router.presentLoginScreen();
    }

    @Override
    public void recoverPasswordSuccess() {
        view.showSuccess();
    }

    @Override
    public void recoverPasswordFailed() {
        view.showError();
    }
}
