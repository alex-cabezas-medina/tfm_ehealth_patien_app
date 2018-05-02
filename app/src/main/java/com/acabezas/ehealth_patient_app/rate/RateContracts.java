package com.acabezas.ehealth_patient_app.rate;

import com.acabezas.ehealth_pacient_sdk.model.RateData;

/**
 * Created by alexandercabezas on 14/4/18.
 */

public class RateContracts {

    interface View {
        void onDestroy();
        void showError();
        void showSuccess();
    }

    interface Presenter {
        void onDestroy();
        void goToHomeScreen();
        void doRate(String comments, int numberOfStars);
    }

    interface Interactor {
        void unRegister();
        void doRate(RateData request);
    }

    interface InteractorOutput {
        void rateSuccess();
        void rateFailed();
    }


    interface Router {
        void unRegister();
        void presentHomeScreen();
    }
}
