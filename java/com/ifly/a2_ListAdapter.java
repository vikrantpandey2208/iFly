package com.ifly;

import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import java.util.Calendar;

public class a2_ListAdapter extends ListAdapter<ScheduleTable, a2_ViewHolder> {
    String TAG = "vik";
    private int count = -1;
    Calendar calendar = Calendar.getInstance();
    int hour = calendar.get(Calendar.HOUR_OF_DAY);


    protected a2_ListAdapter(@NonNull DiffUtil.ItemCallback<ScheduleTable> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public a2_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return a2_ViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull a2_ViewHolder holder, int position) {
        ScheduleTable current = getItem(position);


        if (position == hour - 5) {

            holder.bind(current.getSlot(), current.getTask(), true);
        }
        else if (position != getItemCount() - 1 && !current.getSlot().equals("last")) {

            holder.bind(current.getSlot(), current.getTask());

        } else {
            // for last element
            holder.bind(current.getSlot(), current.getTask(), true, position);
        }
    }

    static class TargetDiff extends DiffUtil.ItemCallback<ScheduleTable> {

        @Override
        public boolean areItemsTheSame(@NonNull ScheduleTable oldItem, @NonNull ScheduleTable newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ScheduleTable oldItem, @NonNull ScheduleTable newItem) {
            return oldItem.getSlot().equals(newItem.getSlot());
        }
    }
}
