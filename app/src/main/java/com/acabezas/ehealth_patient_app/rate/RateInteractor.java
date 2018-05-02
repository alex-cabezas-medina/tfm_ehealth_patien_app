package com.acabezas.ehealth_patient_app.rate;

import com.acabezas.ehealth_pacient_sdk.PacientAPImpl;
import com.acabezas.ehealth_pacient_sdk.callbacks.RateEvisitCallback;
import com.acabezas.ehealth_pacient_sdk.model.RateData;

/**
 * Created by alexandercabezas on 14/4/18.
 */

public class RateInteractor implements RateContracts.Interactor{

    private RateContracts.InteractorOutput output;

    public RateInteractor(RateContracts.InteractorOutput output) {
        this.output = output;
    }

    @Override
    public void unRegister() {
        output = null;
    }

    @Override
    public void doRate(RateData request) {
        PacientAPImpl.getInstance().rateEvisit(request, new RateEvisitCallback() {
            @Override
            public void success() {
                output.rateSuccess();
            }

            @Override
            public void failure() {
                output.rateFailed();
            }
        });
    }


}
