package com.acabezas.ehealth_patient_app.my_account;

import com.acabezas.ehealth_pacient_sdk.model.UpdateProfileRequest;

/**
 * Created by alexandercabezas on 3/5/18.
 */

public class MyAccountContracts {

    interface View {
        void onDestroy();
        void showError(int error);
        void showSuccess();
    }

    interface Presenter {
        void onDestroy();
        void goToHomeScreen();
        void doUpdate(String name,
                      String lastname1,
                      String lastname2,
                      String email,
                      String medicines,
                      String allergies,
                      String surgeries,
                      String dateOfBirth,
                      String weight,
                      String height,
                      String diseases,
                      String comments);
        void getData();
    }

    interface Interactor {
        void unRegister();
        void doUpdate(UpdateProfileRequest request);
        void getData();
    }

    interface InteractorOutput {
        void updateSuccess();
        void updateFailed();
        void getDataSuccess();
        void getDataFailed();
    }


    interface Router {
        void unRegister();
        void presentHomeScreen();
    }
}
