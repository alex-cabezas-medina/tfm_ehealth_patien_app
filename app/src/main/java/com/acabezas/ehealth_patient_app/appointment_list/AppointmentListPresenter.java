package com.acabezas.ehealth_patient_app.appointment_list;

import android.app.Activity;

import com.acabezas.ehealth_pacient_sdk.model.ScheduledAppointmentData;

import java.util.List;

/**
 * Created by alexandercabezas on 16/4/18.
 */

public class AppointmentListPresenter implements AppointmentListContracts.Presenter, AppointmentListContracts.InteractorOutput{
    private AppointmentListContracts.Interactor interactor;
    private AppointmentListContracts.Router router;
    private AppointmentListContracts.View view;

    AppointmentListPresenter(AppointmentListContracts.View view) {
        interactor = new AppointmentListInteractor(this);
        router = new AppointmentListRouter((Activity) view);
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
    public void getAppointmentList() {
        interactor.getAppointmentList();
    }


    @Override
    public void scheduledAppointmentsSuccess(List<ScheduledAppointmentData> data) {
        view.updateAdapter(data);
    }

    @Override
    public void scheduledAppointmentsFailure() {
        view.showError();
    }
}
