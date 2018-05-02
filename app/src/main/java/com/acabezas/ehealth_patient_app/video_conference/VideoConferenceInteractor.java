package com.acabezas.ehealth_patient_app.video_conference;

/**
 * Created by alexandercabezas on 14/4/18.
 */

public class VideoConferenceInteractor implements VideoConferenceContracts.Interactor{
    private VideoConferenceContracts.InteractorOutput output;

    public VideoConferenceInteractor(VideoConferenceContracts.InteractorOutput output) {
        this.output = output;
    }

    @Override
    public void unRegister() {
        output = null;
    }

    @Override
    public void startVideoConference() {

    }
}
