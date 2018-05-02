package com.acabezas.ehealth_patient_app.rate;

import android.app.Activity;

import com.acabezas.ehealth_pacient_sdk.model.RateData;

/**
 * Created by alexandercabezas on 14/4/18.
 */

public class RatePresenter implements RateContracts.Presenter, RateContracts.InteractorOutput{

    private RateContracts.Interactor interactor;
    private RateContracts.Router router;
    private RateContracts.View view;

    RatePresenter(RateContracts.View view) {
        interactor = new RateInteractor(this);
        router = new RateRouter((Activity) view);
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
    public void doRate(String comments, int numberOfStars) {

        RateData request = new RateData();
        request.comments = comments;
        request.numberOfstars = numberOfStars;
        interactor.doRate(request);
    }


    @Override
    public void rateSuccess() {
        goToHomeScreen();
    }

    @Override
    public void rateFailed() {
        view.showError();
    }
}
