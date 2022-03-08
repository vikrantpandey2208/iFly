package com.ifly;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class a7_ListAdapter extends ListAdapter<DoneTable, a7_ViewHolder> {
    String TAG = "vik";

    protected a7_ListAdapter(@NonNull DiffUtil.ItemCallback<DoneTable> diffCallback) {
        super(diffCallback);
    }


    @NonNull
    @Override
    public a7_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return a7_ViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull a7_ViewHolder holder, int position) {
        DoneTable current = getItem(position);

        holder.bind(current.getDate(), current.getTargetName(), current.getDoneDetail());
    }

    static class TargetDiff extends DiffUtil.ItemCallback<DoneTable> {

        @Override
        public boolean areItemsTheSame(@NonNull DoneTable oldItem, @NonNull DoneTable newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull DoneTable oldItem, @NonNull DoneTable newItem) {
            return oldItem.getDoneDetail().equals(newItem.getDoneDetail());
        }
    }
}
