package com.acabezas.ehealth_patient_app.recover_password;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.acabezas.ehealth_patient_app.R;
import com.acabezas.ehealth_patient_app.Tools.AlertDialogCallback;
import com.acabezas.ehealth_patient_app.Tools.Tools;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecoverPasswordActivity extends AppCompatActivity implements RecoverPasswordContracts.View{

    private RecoverPasswordContracts.Presenter presenter;

    @BindView(R.id.email_input)
    EditText email;
    @BindView(R.id.recover_password)
    Button recoverPassword;
    @BindView(R.id.cancel)
    Button cancel;

    public static void startRecoverPasswordActivity(Activity context) {
        Intent intent = new Intent(context, RecoverPasswordActivity.class);
        context.startActivity(intent);
    }

    private void init() {

        recoverPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.recoverPassword(email.getEditableText().toString());
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goToLoginScreen();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_password);
        ButterKnife.bind(this);
        presenter = new RecoverPasswordPresenter(this);
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
                message = getResources().getString(R.string.error_bad_username);
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
        String message = getResources().getString(R.string.message_recover_password_email_sent);

        Tools.createAlertDialog(this,title, message, new AlertDialogCallback() {
            @Override
            public void accept() {
                presenter.goToLoginScreen();
            }
        }).show();
    }
}
