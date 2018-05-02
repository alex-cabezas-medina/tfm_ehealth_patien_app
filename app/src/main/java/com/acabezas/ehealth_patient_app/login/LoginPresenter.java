package com.acabezas.ehealth_patient_app.login;

import android.app.Activity;

import com.acabezas.ehealth_pacient_sdk.model.LoginRequest;
import com.acabezas.ehealth_patient_app.video_conference.VideoConferenceContracts;

/**
 * Created by alexandercabezas on 11/4/18.
 */

public class LoginPresenter implements LoginContracts.Presenter, LoginContracts.InteractorOutput{

    private LoginContracts.Interactor interactor;
    private LoginContracts.Router router;
    private LoginContracts.View view;

    LoginPresenter(LoginContracts.View view) {
        interactor = new LoginInteractor(this);
        router = new LoginRouter((Activity) view);
        this.view = view;
    }
    @Override
    public void onDestroy() {
        view = null;
        interactor.unRegister();
        interactor = null;
        router.unRegister();
        router = null;
    }

    @Override
    public void goToHomeScreen() {

    }

    @Override
    public void goToRegisterScreen() {
        router.presentRegisterScreen();
    }

    @Override
    public void goToRecoverPasswordScreen() {
        router.presentRecoverPasswordScreen();
    }

    @Override
    public void doLogin(String username, String password) {
        LoginRequest request = new LoginRequest();
        request.username = username;
        request.password = password;
        interactor.doLogin(request);
    }

    @Override
    public void loginSuccess() {
        router.presentHomeScreen();
    }

    @Override
    public void loginFailed() {
        view.showError();
    }
}
