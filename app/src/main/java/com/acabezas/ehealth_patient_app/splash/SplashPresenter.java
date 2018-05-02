package com.acabezas.ehealth_patient_app.splash;

import android.app.Activity;

/**
 * Created by alexandercabezas on 9/4/18.
 */

public class SplashPresenter implements SplashContracts.Presenter{

    private SplashContracts.Interactor interactor;
    private SplashContracts.Router router;

    SplashPresenter(SplashContracts.View view) {
        interactor = new SplashInteractor();
        router = new SplashRouter((Activity) view);
    }

    @Override
    public void onDestroy() {
        interactor.unRegister();
        interactor = null;
        router.unRegister();
        router = null;
    }

    @Override
    public void goToLoginScreen() {
        router.presentLoginScreen();
    }

    @Override
    public void goToOnboardingScreen() {
        router.presentOnboardingScreen();
    }
}
