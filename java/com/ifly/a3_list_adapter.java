package com.ifly;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;


public class a3_list_adapter extends ListAdapter<TargetTable, a3_target_viewholder> {
    String TAG = "vik";

    public a3_list_adapter(@NonNull DiffUtil.ItemCallback<TargetTable> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public a3_target_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return a3_target_viewholder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull a3_target_viewholder holder, int position) {
        TargetTable current = getItem(position);
        Log.d(TAG, "bind: "+current.getTotalWork() +" "+ current.getDoneWork() +" "+current.getDayRemaining());
        holder.bind(new a3_data_target(
                current.getId(),
                current.getTargetName(), current.getTotalWork(), current.getDoneWork(),
                current.getDayRemaining(), current.getExpectedDate()
        ));
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
