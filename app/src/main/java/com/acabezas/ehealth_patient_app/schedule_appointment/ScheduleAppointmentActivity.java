package com.acabezas.ehealth_patient_app.schedule_appointment;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.acabezas.ehealth_patient_app.R;
import com.acabezas.ehealth_patient_app.Tools.AlertDialogCallback;
import com.acabezas.ehealth_patient_app.Tools.Tools;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScheduleAppointmentActivity extends AppCompatActivity implements ScheduleAppointmentContracts.View{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.date_input)
    EditText date;
    @BindView(R.id.time_input)
    EditText time;
    @BindView(R.id.speciality_input)
    EditText specialty;
    @BindView(R.id.doctor_input)
    EditText doctor;
    @BindView(R.id.schedule)
    Button schedule;

    private ScheduleAppointmentContracts.Presenter presenter;

    public static void startScheduleAppointmentActivity(Activity context) {
        Intent intent = new Intent(context, ScheduleAppointmentActivity.class);
        context.startActivity(intent);
    }

    private void init() {

        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.scheduleAppointment(date.getEditableText().toString(),
                        time.getEditableText().toString(),
                        doctor.getEditableText().toString(),
                        specialty.getEditableText().toString());
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_appointment);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        //todo change icon for back arrow
        toolbar.setNavigationIcon(R.drawable.ic_menu_send);
        presenter = new ScheduleAppointmentPresenter(this);
        init();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();

        presenter = new ScheduleAppointmentPresenter(this);
    }

    @Override
    public void showError() {

    }

    @Override
    public void showSuccess() {
        Tools.createAlertDialog(this,"title", "message", new AlertDialogCallback() {
            @Override
            public void accept() {

            }
        }).show();
    }
}
