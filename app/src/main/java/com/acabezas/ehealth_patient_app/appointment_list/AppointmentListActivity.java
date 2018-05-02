package com.acabezas.ehealth_patient_app.appointment_list;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.acabezas.ehealth_pacient_sdk.model.ScheduledAppointmentData;
import com.acabezas.ehealth_patient_app.R;
import com.acabezas.ehealth_patient_app.Tools.AlertDialogCallback;
import com.acabezas.ehealth_patient_app.Tools.Tools;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AppointmentListActivity extends AppCompatActivity implements AppointmentListContracts.View{

    @BindView(R.id.appointment_list)
    RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private AppointmentListContracts.Presenter presenter;
    private List<ScheduledAppointmentData> data;

    public static void startAppointmentListActivity(Activity context) {
        Intent intent = new Intent(context, AppointmentListActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_list);
        ButterKnife.bind(this);


        data = new ArrayList<>();
        adapter = new ScheduledAppointmentsAdapter(data);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        //adapter = new ScheduledAppointmentsAdapter(List< ScheduledAppointmentData>);
        recyclerView.setAdapter(adapter);

        presenter = new AppointmentListPresenter(this);

        presenter.getAppointmentList();
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
        Tools.createAlertDialog(this,"title", "message", new AlertDialogCallback() {
            @Override
            public void accept() {

            }
        }).show();
    }

    @Override
    public void updateAdapter(List<ScheduledAppointmentData> data) {
        this.data.addAll(data);
        adapter.notifyDataSetChanged();
    }
}
