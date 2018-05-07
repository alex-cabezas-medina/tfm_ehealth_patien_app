package com.acabezas.ehealth_patient_app.my_account;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.acabezas.ehealth_patient_app.R;
import com.acabezas.ehealth_patient_app.Tools.AlertDialogCallback;
import com.acabezas.ehealth_patient_app.Tools.Tools;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAccountActivity extends AppCompatActivity implements MyAccountContracts.View, DatePickerDialog.OnDateSetListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.name_input)
    EditText name;
    @BindView(R.id.lastname1_input)
    EditText lastname1;
    @BindView(R.id.lastname2_input)
    EditText lastname2;
    @BindView(R.id.email_input)
    EditText email;
    @BindView(R.id.medicines_input)
    EditText medicines;
    @BindView(R.id.allergies_input)
    EditText allergies;
    @BindView(R.id.surgeries_input)
    EditText surgeries;
    @BindView(R.id.date_of_birth_input)
    EditText dateOfBirth;
    @BindView(R.id.weight_input)
    EditText weight;
    @BindView(R.id.height_input)
    EditText height;
    @BindView(R.id.diseases_input)
    EditText diseases;
    @BindView(R.id.comments_input)
    EditText comments;
    @BindView(R.id.update)
    Button update;

    private MyAccountContracts.Presenter presenter;
    private DatePickerDialog datePickerDialog;

    public static void startMyAccountActivity(Activity context) {
        Intent intent = new Intent(context, MyAccountActivity.class);
        context.startActivity(intent);
    }

    private void init() {
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.doUpdate(name.getText().toString(),
                        lastname1.getText().toString(),
                        lastname2.getText().toString(),
                        email.getText().toString(),
                        medicines.getText().toString(),
                        allergies.getText().toString(),
                        surgeries.getText().toString(),
                        dateOfBirth.getEditableText().toString(),
                        weight.getEditableText().toString(),
                        height.getEditableText().toString(),
                        diseases.getEditableText().toString(),
                        comments.getEditableText().toString());
            }
        });

        Calendar currentDate = Calendar.getInstance();
        int day = currentDate.get(Calendar.DAY_OF_MONTH);
        int year = currentDate.get(Calendar.YEAR);
        int month = currentDate.get(Calendar.MONTH);

        datePickerDialog = new DatePickerDialog(
                this, MyAccountActivity.this,
                year, month, day);

        dateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

        dateOfBirth.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        ButterKnife.bind(this);
        presenter = new MyAccountPresenter(this);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_left_arrow);
        init();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
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
                message = getResources().getString(R.string.error_bad_birthdate);
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
        String message = getResources().getString(R.string.message_update_profile_success);

        Tools.createAlertDialog(this,title, message, new AlertDialogCallback() {
            @Override
            public void accept() {

            }
        }).show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        dateOfBirth.setText(dayOfMonth + "/" + month+ "/" + year);
    }
}
