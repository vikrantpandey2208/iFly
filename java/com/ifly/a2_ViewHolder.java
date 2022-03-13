package com.ifly;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class a2_ViewHolder extends RecyclerView.ViewHolder {
    private final TextView slotTv, taskTv;
    String TAG = "vik";


    public a2_ViewHolder(@NonNull  View view) {
        super(view);

        slotTv = view.findViewById(R.id.a2_home_slot);
        taskTv = view.findViewById(R.id.a2_work);
    }

    public void bind(String slotStr, String taskStr) {
        slotTv.setText(slotStr);
        taskTv.setText(taskStr);
        taskTv.setVisibility(View.VISIBLE);
        slotTv.setTextColor(slotTv.getContext().getResources().getColor(R.color.lic_black));

        slotTv.setOnClickListener(null);
    }

    public void bind(String slotStr, String taskStr, boolean now) {
        slotTv.setText(slotStr);
        taskTv.setText(taskStr);
        taskTv.setVisibility(View.VISIBLE);
        slotTv.setTextColor(slotTv.getContext().getResources().getColor(R.color.mela_green));
        taskTv.setTextColor(slotTv.getContext().getResources().getColor(R.color.mela_green));
        slotTv.setOnClickListener(null);
    }
    public void bind(String slotStr, String taskStr, boolean last , int pos) {
        slotTv.setText("Edit Schedule");
        taskTv.setVisibility(View.GONE);
        slotTv.setTextColor(slotTv.getContext().getResources().getColor(R.color.navy_blue));

        slotTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(slotTv.getContext(), a6_edit_schedule.class);
                slotTv.getContext().startActivity(intent);
            }
        });
    }
    static a2_ViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.a2_home_item, parent, false);
        return new a2_ViewHolder(view);
    }
}
