package com.acabezas.ehealth_patient_app.my_account;

import android.app.Activity;

import com.acabezas.ehealth_pacient_sdk.model.UpdateProfileRequest;

/**
 * Created by alexandercabezas on 3/5/18.
 */

public class MyAccountPresenter implements MyAccountContracts.Presenter, MyAccountContracts.InteractorOutput {
    private MyAccountContracts.Interactor interactor;
    private MyAccountContracts.Router router;
    private MyAccountContracts.View view;

    MyAccountPresenter(MyAccountContracts.View view) {
        interactor = new MyAccountInteractor(this);
        router = new MyAccountRouter((Activity) view);
        this.view = view;
    }

    @Override
    public void onDestroy() {
        view = null;
        interactor.unRegister();
        interactor = null;
        router.unRegister();
        router = null;
    }

    @Override
    public void goToHomeScreen() {

    }

    @Override
    public void doUpdate(String name,
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
                         String comments) {

        if(!name.isEmpty() &&
                !lastname1.isEmpty() &&
                !lastname2.isEmpty() &&
                !email.isEmpty() &&
                !medicines.isEmpty() &&
                !allergies.isEmpty() &&
                !surgeries.isEmpty() &&
                !dateOfBirth.isEmpty() &&
                !weight.isEmpty() &&
                !height.isEmpty() &&
                !diseases.isEmpty() &&
                !comments.isEmpty()) {

            //TODO: checj date higher than today
            if(!dateOfBirth.isEmpty()) {
                UpdateProfileRequest request = new UpdateProfileRequest();
                request.name = name;
                request.lastname1 = lastname1;
                request.lastname2 = lastname2;
                request.email = email;
                request.medicines = medicines;
                request.allergies = allergies;
                request.surgeries = surgeries;
                request.dateOfBirth = dateOfBirth;
                request.weight = weight;
                request.height = height;
                request.diseases = diseases;
                request.comments = comments;

                interactor.doUpdate(request);
            } else {view.showError(2);}

        } else {
            view.showError(3);
        }


    }

    @Override
    public void getData() {
        interactor.getData();
    }

    @Override
    public void updateSuccess() {
        view.showSuccess();
    }

    @Override
    public void updateFailed() {
        view.showError(1);
    }

    @Override
    public void getDataSuccess() {
        view.showSuccess();
    }

    @Override
    public void getDataFailed() {
        view.showError(1);
    }
}
