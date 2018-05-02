package com.acabezas.ehealth_patient_app.home;

/**
 * Created by alexandercabezas on 16/4/18.
 */

public class HomeInteractor implements HomeContracts.Interactor{
    private HomeContracts.InteractorOutput output;

    public HomeInteractor(HomeContracts.InteractorOutput output) {
        this.output = output;
    }

    @Override
    public void unRegister() {
        output = null;
    }
}
