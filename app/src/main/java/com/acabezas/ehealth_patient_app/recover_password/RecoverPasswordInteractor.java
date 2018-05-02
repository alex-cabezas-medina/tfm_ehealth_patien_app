package com.acabezas.ehealth_patient_app.recover_password;

import com.acabezas.ehealth_pacient_sdk.PacientAPImpl;
import com.acabezas.ehealth_pacient_sdk.callbacks.RecoverPasswordCallback;
import com.acabezas.ehealth_pacient_sdk.model.RecoverPasswordRequest;

/**
 * Created by alexandercabezas on 14/4/18.
 */

public class RecoverPasswordInteractor implements RecoverPasswordContracts.Interactor{
    private RecoverPasswordContracts.InteractorOutput output;

    public RecoverPasswordInteractor(RecoverPasswordContracts.InteractorOutput output) {
        this.output = output;
    }

    @Override
    public void unRegister() {
        output = null;
    }

    @Override
    public void recoverPassword(RecoverPasswordRequest request) {

        PacientAPImpl.getInstance().recoverPassword(request, new RecoverPasswordCallback() {
            @Override
            public void success() {
                output.recoverPasswordSuccess();
            }

            @Override
            public void failure() {
                output.recoverPasswordFailed();
            }
        });

    }
}
