package com.acabezas.ehealth_patient_app.splash;

/**
 * Created by alexandercabezas on 9/4/18.
 */

public class SplashInteractor implements SplashContracts.Interactor {

    private SplashContracts.InteractorOutput output;

    public SplashInteractor(SplashContracts.InteractorOutput output) {
        this.output = output;
    }
    @Override
    public void unRegister() {
        output = null;
    }

    @Override
    public void handleSplash() {
        Thread thread = new Thread("New Thread") {
            public void run(){
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    output.endSplash();
                }
            }
        };


        thread.start();
    }
}
