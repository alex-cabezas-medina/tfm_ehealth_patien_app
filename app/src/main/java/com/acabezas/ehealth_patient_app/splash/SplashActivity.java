package com.acabezas.ehealth_patient_app.splash;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.acabezas.ehealth_patient_app.R;

public class SplashActivity extends AppCompatActivity implements SplashContracts.View{

    private SplashContracts.Presenter presenter;

    public static void startSplashActivity(Activity context) {
        Intent intent = new Intent(context, SplashActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        presenter = new SplashPresenter(this);
        presenter.goToLoginScreen();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
