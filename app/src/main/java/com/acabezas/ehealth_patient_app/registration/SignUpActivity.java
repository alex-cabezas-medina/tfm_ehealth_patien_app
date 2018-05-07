package com.acabezas.ehealth_patient_app.registration;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.acabezas.ehealth_pacient_sdk.model.SignUpRequest;
import com.acabezas.ehealth_patient_app.R;
import com.acabezas.ehealth_patient_app.Tools.AlertDialogCallback;
import com.acabezas.ehealth_patient_app.Tools.Tools;
import com.acabezas.ehealth_patient_app.login.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity implements SignUpContracts.View{

    private SignUpContracts.Presenter presenter;

    @BindView(R.id.name_input)
    EditText name;
    @BindView(R.id.lastname1_input)
    EditText lastname1;
    @BindView(R.id.lastname2_input)
    EditText lastname2;
    @BindView(R.id.email_input)
    EditText email;
    @BindView(R.id.password_input)
    EditText password;
    @BindView(R.id.medicines_input)
    EditText medicines;
    @BindView(R.id.allergies_input)
    EditText allergies;
    @BindView(R.id.surgeries_input)
    EditText surgeries;
    @BindView(R.id.signup)
    Button signUp;

    public static void startSignUpActivity(Activity context) {
        Intent intent = new Intent(context, SignUpActivity.class);
        context.startActivity(intent);
    }

    private void init() {
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.doSignUp(name.getText().toString(),
                        lastname1.getText().toString(),
                        lastname2.getText().toString(),
                        email.getText().toString(),
                        password.getText().toString(),
                        medicines.getText().toString(),
                        allergies.getText().toString(),
                        surgeries.getText().toString());
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        init();
        presenter = new SignUpPresenter(this);

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
                message = getResources().getString(R.string.error_bad_username);
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
        String message = getResources().getString(R.string.message_signup_success);

        Tools.createAlertDialog(this,title, message, new AlertDialogCallback() {
            @Override
            public void accept() {
                presenter.goToHomeScreen();
            }
        }).show();
    }
}
