package com.acabezas.ehealth_patient_app.schedule_appointment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;

import com.acabezas.ehealth_patient_app.R;
import com.acabezas.ehealth_patient_app.Tools.AlertDialogCallback;
import com.acabezas.ehealth_patient_app.Tools.Tools;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScheduleAppointmentActivity extends AppCompatActivity implements ScheduleAppointmentContracts.View, DatePickerDialog.OnDateSetListener{

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
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePicker;
    private AlertDialog doctorListDialog;
    private AlertDialog specialtyListDialog;

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

        Calendar currentDate = Calendar.getInstance();
        int day = currentDate.get(Calendar.DAY_OF_MONTH);
        int year = currentDate.get(Calendar.YEAR);
        int month = currentDate.get(Calendar.MONTH);
        int hour = currentDate.get(Calendar.HOUR_OF_DAY);
        int minute = currentDate.get(Calendar.MINUTE);

        datePickerDialog = new DatePickerDialog(
                this, ScheduleAppointmentActivity.this,
                year, month, day);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

        date.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    getWindow().setSoftInputMode(
                            WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
                    );

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(findViewById(android.R.id.content).getWindowToken(), 0);
                    datePickerDialog.show();
                }
            }
        });

        timePicker = new TimePickerDialog(ScheduleAppointmentActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                time.setText( selectedHour + ":" + selectedMinute);
            }
        }, hour, minute, true);//Yes 24 hour time
        //timePicker.setTitle("Select Time");


        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        timePicker.show();
            }
        });

        time.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    getWindow().setSoftInputMode(
                            WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
                    );

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(findViewById(android.R.id.content).getWindowToken(), 0);
                    timePicker.show();
                }
            }
        });

        AlertDialog.Builder builderDoctor = new AlertDialog.Builder(ScheduleAppointmentActivity.this);
        builderDoctor.setTitle("Choose a doctor");
        // add a list
        String[] doctors = {"dr1", "dr2", "dr3", "dr4", "dr5"};


        builderDoctor.setItems(doctors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                }
            }
        });
        doctorListDialog = builderDoctor.create();
        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doctorListDialog.show();
            }
        });

        doctor.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    getWindow().setSoftInputMode(
                            WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
                    );
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(findViewById(android.R.id.content).getWindowToken(), 0);
                    doctorListDialog.show();
                }
            }
        });

        //specialty

        AlertDialog.Builder builderSpecialty = new AlertDialog.Builder(ScheduleAppointmentActivity.this);
        builderSpecialty.setTitle("Choose a specialty");
        // add a list
        String[] specialties = {"1", "2", "3", "4", "5"};


        builderSpecialty.setItems(specialties, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                }
            }
        });
        specialtyListDialog = builderSpecialty.create();
        specialty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                specialtyListDialog.show();
            }
        });

        specialty.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    getWindow().setSoftInputMode(
                            WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
                    );
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(findViewById(android.R.id.content).getWindowToken(), 0);
                    specialtyListDialog.show();
                }
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_appointment);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_left_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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
    public void showError(int error) {
        String title = getResources().getString(R.string.error_title);
        String message = "";

        switch (error){
            case 1:
                message = getResources().getString(R.string.error_bad_connection);
                break;
            case 2:
                message = getResources().getString(R.string.error_bad_date);
                break;
            case 3:
                message = getResources().getString(R.string.error_fields_not_filled);
                break;
        }

        Tools.createAlertDialog(this,title, message, new AlertDialogCallback() {
            @Override
            public void accept() {

            }
        }).show();
    }

    @Override
    public void showSuccess() {
        String title = getResources().getString(R.string.message_title);
        String message = getResources().getString(R.string.message_schedule_success);

        Tools.createAlertDialog(this,title, message, new AlertDialogCallback() {
            @Override
            public void accept() {

            }
        }).show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        date.setText(dayOfMonth + "/" + month +"/" + year);
    }
}
