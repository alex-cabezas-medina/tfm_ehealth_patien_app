package com.acabezas.ehealth_patient_app.registration;

import android.app.Activity;

import com.acabezas.ehealth_pacient_sdk.model.SignUpRequest;

/**
 * Created by alexandercabezas on 14/4/18.
 */

public class SignUpPresenter implements SignUpContracts.Presenter, SignUpContracts.InteractorOutput{

    private SignUpContracts.Interactor interactor;
    private SignUpContracts.Router router;
    private SignUpContracts.View view;

    SignUpPresenter(SignUpContracts.View view) {
        interactor = new SignUpInteractor(this);
        router = new SignUpRouter((Activity) view);
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
    public void goToHomeScreen() {
        router.presentHomeScreen();
    }

    @Override
    public void goToLoginScreen() {
        router.presentLoginScreen();
    }

    @Override
    public void doSignUp(String name,
                         String lastname1,
                         String lastname2,
                         String email,
                         String password,
                         String medicines,
                         String allergies,
                         String surgeries) {
        SignUpRequest request = new SignUpRequest();
        request.name = name;
        request.lastname1 = lastname1;
        request.lastname2 = lastname2;
        request.email = email;
        request.passowrd = password;
        request.medicines = medicines;
        request.allergies = allergies;
        request.surgeries = surgeries;
        interactor.doSignUp(request);
    }

    @Override
    public void sigUpSuccess() {
        view.showSuccess();
    }

    @Override
    public void signUpFailed() {
        view.showError();
    }
}
