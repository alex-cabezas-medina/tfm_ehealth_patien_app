package com.acabezas.ehealth_patient_app.video_conference;

import android.app.Activity;

import com.acabezas.ehealth_patient_app.rate.RateActivity;

/**
 * Created by alexandercabezas on 14/4/18.
 */

public class VideoConferencePresenter implements VideoConferenceContracts.Presenter, VideoConferenceContracts.InteractorOutput{
    private VideoConferenceContracts.Interactor interactor;
    private VideoConferenceContracts.Router router;

    VideoConferencePresenter(VideoConferenceContracts.View view) {
        interactor = new VideoConferenceInteractor(this);
        router = new VideoConferenceRouter((Activity) view);
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

    }

    @Override
    public void goToRateScreen() {
        router.presentRateScreen();
    }

    @Override
    public void startVideoConference() {

    }
}
