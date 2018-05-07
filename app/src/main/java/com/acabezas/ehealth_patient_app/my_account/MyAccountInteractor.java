package com.acabezas.ehealth_patient_app.my_account;

import com.acabezas.ehealth_pacient_sdk.PacientAPImpl;
import com.acabezas.ehealth_pacient_sdk.callbacks.GetUserProfileDataCallback;
import com.acabezas.ehealth_pacient_sdk.callbacks.UpdateUserProfileDataCallback;
import com.acabezas.ehealth_pacient_sdk.model.UpdateProfileRequest;

/**
 * Created by alexandercabezas on 3/5/18.
 */

public class MyAccountInteractor implements MyAccountContracts.Interactor{
    private MyAccountContracts.InteractorOutput output;

    public MyAccountInteractor(MyAccountContracts.InteractorOutput output) {
        this.output = output;
    }

    @Override
    public void unRegister() {
        output = null;
    }

    @Override
    public void doUpdate(UpdateProfileRequest request) {
        PacientAPImpl.getInstance().updateUserProfileData(request, new UpdateUserProfileDataCallback() {
            @Override
            public void success() {
                output.updateSuccess();
            }

            @Override
            public void failure() {
                output.updateFailed();
            }
        });
    }

    @Override
    public void getData() {
        PacientAPImpl.getInstance().getUserProfileData(new GetUserProfileDataCallback() {
            @Override
            public void success(UpdateProfileRequest response) {
                output.getDataSuccess();
            }

            @Override
            public void failure() {
                output.getDataFailed();
            }
        });
    }
}
