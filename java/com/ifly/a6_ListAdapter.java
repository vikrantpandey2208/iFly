package com.ifly;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class a6_ListAdapter extends ListAdapter<ScheduleTable, a6_ViewHolder> {
    String TAG = "vik";

    protected a6_ListAdapter(@NonNull DiffUtil.ItemCallback<ScheduleTable> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public a6_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return a6_ViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull a6_ViewHolder holder, int position) {
        ScheduleTable current = getItem(position);

        holder.bind(current.getSlot(), current.getTask());
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
