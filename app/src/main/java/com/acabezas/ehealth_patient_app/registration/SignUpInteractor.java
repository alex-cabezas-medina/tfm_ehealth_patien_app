package com.acabezas.ehealth_patient_app.registration;

import com.acabezas.ehealth_pacient_sdk.PacientAPImpl;
import com.acabezas.ehealth_pacient_sdk.callbacks.SignUpPacientCallback;
import com.acabezas.ehealth_pacient_sdk.model.SignUpRequest;

/**
 * Created by alexandercabezas on 14/4/18.
 */

public class SignUpInteractor implements SignUpContracts.Interactor{

    private SignUpContracts.InteractorOutput output;

    public SignUpInteractor(SignUpContracts.InteractorOutput output) {
        this.output = output;
    }

    @Override
    public void unRegister() {
        output = null;
    }

    @Override
    public void doSignUp(SignUpRequest request) {
        PacientAPImpl.getInstance().signUpPacient(request, new SignUpPacientCallback() {
            @Override
            public void success() {
                output.sigUpSuccess();
            }

            @Override
            public void failure() {
                output.signUpFailed();
            }
        });
    }
}
