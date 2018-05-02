package com.acabezas.ehealth_patient_app.video_conference;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.acabezas.ehealth_patient_app.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoConferenceActivity extends AppCompatActivity implements VideoConferenceContracts.View{

    @BindView(R.id.turnoff_micro)
    ImageButton microOff;
    @BindView(R.id.turnoff_camera)
    ImageButton cameraOff;
    @BindView(R.id.cancel_video_call)
    ImageButton cancel;


    private VideoConferenceContracts.Presenter presenter;


    private void init() {

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goToRateScreen();
            }
        });
    }

    public static void startVideoConferenceActivity(Activity context) {
        Intent intent = new Intent(context, VideoConferenceActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_conference);
        ButterKnife.bind(this);

        presenter = new VideoConferencePresenter(this);

        init();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showError() {

    }
}
