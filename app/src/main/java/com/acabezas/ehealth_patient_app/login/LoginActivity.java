package com.acabezas.ehealth_patient_app.login;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.acabezas.ehealth_patient_app.R;
import com.acabezas.ehealth_patient_app.Tools.AlertDialogCallback;
import com.acabezas.ehealth_patient_app.Tools.Tools;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginContracts.View{

    private LoginContracts.Presenter presenter;

    @BindView(R.id.forgot_password_label)
    TextView forgotPassword;
    @BindView(R.id.login)
    Button loginButton;
    @BindView(R.id.sign_up_label)
    TextView signUp;
    @BindView(R.id.username_input)
    EditText userName;
    @BindView(R.id.password_input)
    EditText password;

    public static void startLoginctivity(Activity context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    private void init() {

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goToRecoverPasswordScreen();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.doLogin(userName.getEditableText().toString(),
                        password.getEditableText().toString());
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goToRegisterScreen();
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter = new LoginPresenter(this);

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

        switch (error) {
            case 1:
                message = getResources().getString(R.string.error_bad_credentials);
                break;
            case 2:
                message = getResources().getString(R.string.error_bad_username);
                break;
            case 3 :
                message = getResources().getString(R.string.error_user_not_exist);
                break;
        }

        Tools.createAlertDialog(this,title, message, new AlertDialogCallback() {
            @Override
            public void accept() {

            }
        }).show();

    }
}
