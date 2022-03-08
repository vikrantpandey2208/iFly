package com.ifly;

import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class a2_ListAdapter extends ListAdapter<ScheduleTable, a2_ViewHolder> {
    String TAG = "vik";

    protected a2_ListAdapter(@NonNull  DiffUtil.ItemCallback<ScheduleTable> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public a2_ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return a2_ViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull  a2_ViewHolder holder, int position) {
        ScheduleTable current = getItem(position);

        if (position != getItemCount()-1) {
            holder.bind(current.getSlot(), current.getTask());
        }else {
            holder.bind(current.getSlot(), current.getTask(),true);
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
