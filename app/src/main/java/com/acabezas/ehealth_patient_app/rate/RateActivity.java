package com.acabezas.ehealth_patient_app.rate;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.acabezas.ehealth_patient_app.R;
import com.acabezas.ehealth_patient_app.Tools.AlertDialogCallback;
import com.acabezas.ehealth_patient_app.Tools.Tools;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RateActivity extends AppCompatActivity implements RateContracts.View{

    @BindView(R.id.star_1)
    ImageButton star1;
    @BindView(R.id.star_2)
    ImageButton star2;
    @BindView(R.id.star_3)
    ImageButton star3;
    @BindView(R.id.star_4)
    ImageButton star4;
    @BindView(R.id.star_5)
    ImageButton star5;
    @BindView(R.id.comments_input)
    EditText comments;
    @BindView(R.id.rate)
    Button rate;

    private RateContracts.Presenter presenter;

    public static void startRateActivity(Activity context) {
        Intent intent = new Intent(context, RateActivity.class);
        context.startActivity(intent);
    }

    private void init() {
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.doRate(comments.getEditableText().toString(), 5);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        ButterKnife.bind(this);

        presenter = new RatePresenter(this);

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

    @Override
    public void showSuccess() {
    }
}
