package com.acabezas.ehealth_patient_app.home;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.acabezas.ehealth_patient_app.R;
import com.acabezas.ehealth_patient_app.Tools.AlertDialogCallback;
import com.acabezas.ehealth_patient_app.Tools.Tools;
import com.acabezas.ehealth_patient_app.appointment_list.AppointmentListActivity;
import com.acabezas.ehealth_patient_app.login.LoginActivity;
import com.acabezas.ehealth_patient_app.my_account.MyAccountActivity;
import com.acabezas.ehealth_patient_app.schedule_appointment.ScheduleAppointmentActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements HomeContracts.View, NavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.video_conference_container)
    LinearLayout videoConferenceContainer;
    @BindView(R.id.schedule_appointment_container)
    LinearLayout scheduleAppointmentContainer;
    @BindView(R.id.scheduled_appointment_container)
    LinearLayout scheduledAppointmentContainer;

    private HomeContracts.Presenter presenter;

    private void init(){
        videoConferenceContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goToVideoConference();
            }
        });

        scheduleAppointmentContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goToScheduleAppointment();
            }
        });

        scheduledAppointmentContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goToScheduledAppointments();
            }
        });
    }

    public static void startHomectivity(Activity context) {
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        init();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);

        presenter = new HomePresenter(this);
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
                message = getResources().getString(R.string.error_video_conference);
                break;
        }

        Tools.createAlertDialog(this,title, message, new AlertDialogCallback() {
            @Override
            public void accept() {

            }
        }).show();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

        } else if(id == R.id.nav_account) {
            MyAccountActivity.startMyAccountActivity(this);
        } else if (id == R.id.nav_scheduled_appointments) {
            AppointmentListActivity.startAppointmentListActivity(this);
        } else if (id == R.id.nav_schedule_appointment) {
            ScheduleAppointmentActivity.startScheduleAppointmentActivity(this);
        } else if (id == R.id.nav_sign_out) {
            LoginActivity.startLoginctivity(this);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
