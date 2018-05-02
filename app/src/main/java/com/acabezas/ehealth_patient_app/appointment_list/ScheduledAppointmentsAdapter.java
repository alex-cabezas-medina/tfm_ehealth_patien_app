package com.acabezas.ehealth_patient_app.appointment_list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.acabezas.ehealth_pacient_sdk.model.ScheduledAppointmentData;
import com.acabezas.ehealth_patient_app.R;

import java.util.List;

/**
 * Created by alexandercabezas on 29/4/18.
 */

public class ScheduledAppointmentsAdapter extends RecyclerView.Adapter<ScheduledAppointmentsAdapter.ViewHolder>{


    private List<ScheduledAppointmentData> dataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView doctor;
        public TextView date;
        public TextView specialty;

        public ViewHolder(View view) {
            super(view);
            doctor = (TextView) view.findViewById(R.id.doctor);
            date = (TextView) view.findViewById(R.id.date);
            specialty = (TextView) view.findViewById(R.id.specialty);
        }
    }

    public ScheduledAppointmentsAdapter(List<ScheduledAppointmentData> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public ScheduledAppointmentsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.scheduled_appintment_adapter_layout, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ScheduledAppointmentsAdapter.ViewHolder holder, int position) {
        holder.doctor.setText(dataSet.get(position).doctor);
        holder.date.setText(dataSet.get(position).date);
        holder.specialty.setText(dataSet.get(position).specialty);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
