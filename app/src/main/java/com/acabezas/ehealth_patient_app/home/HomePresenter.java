package com.acabezas.ehealth_patient_app.home;

import android.app.Activity;

/**
 * Created by alexandercabezas on 16/4/18.
 */

public class HomePresenter implements HomeContracts.Presenter, HomeContracts.InteractorOutput{
    private HomeContracts.Interactor interactor;
    private HomeContracts.Router router;

    HomePresenter(HomeContracts.View view) {
        interactor = new HomeInteractor(this);
        router = new HomeRouter((Activity) view);
    }
    @Override
    public void onDestroy() {
        interactor.unRegister();
        interactor = null;
        router.unRegister();
        router = null;
    }

    @Override
    public void goToScheduleAppointment() {
        router.goToScheduleAppointment();
    }

    @Override
    public void goToVideoConference() {
        router.goToVideoConference();
    }

    @Override
    public void goToScheduledAppointments() {
        router.goToScheduledAppointments();
    }
}
