package com.acabezas.ehealth_patient_app.login;

import com.acabezas.ehealth_pacient_sdk.PacientAPImpl;
import com.acabezas.ehealth_pacient_sdk.callbacks.LoginPacientCallback;
import com.acabezas.ehealth_pacient_sdk.model.LoginRequest;

/**
 * Created by alexandercabezas on 11/4/18.
 */

public class LoginInteractor implements LoginContracts.Interactor{

    private LoginContracts.InteractorOutput output;

    public LoginInteractor(LoginContracts.InteractorOutput output) {
        this.output = output;
    }

    @Override
    public void unRegister() {
        output = null;
    }

    @Override
    public void doLogin(LoginRequest request) {

        PacientAPImpl.getInstance().loginPacient(request, new LoginPacientCallback() {
            @Override
            public void success() {
                output.loginSuccess();
            }

            @Override
            public void failure() {
                output.loginFailed();
            }
        });

    }
}
