package com.ifly;

import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class a4_list_adapter extends ListAdapter<TargetTable, a4_viewholder> {
    String TAG = "vik";

    protected a4_list_adapter(@NonNull DiffUtil.ItemCallback<TargetTable> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public a4_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return a4_viewholder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull a4_viewholder holder, int position) {

        TargetTable current = getItem(position);
        if (position != getItemCount()-1) {
            holder.bind(current.getTargetName(), current.getId());
        }else {
            holder.bind(current.getTargetName(), current.getId(),true);
        }
    }

    static class TargetDiff extends DiffUtil.ItemCallback<TargetTable> {

        @Override
        public boolean areItemsTheSame(@NonNull TargetTable oldItem, @NonNull TargetTable newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull TargetTable oldItem, @NonNull TargetTable newItem) {
            return oldItem.getTargetName().equals(newItem.getTargetName());
        }
    }
}
