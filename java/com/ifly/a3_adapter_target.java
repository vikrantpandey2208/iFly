package com.ifly;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class a3_adapter_target extends RecyclerView.Adapter<a3_adapter_target.ViewHolder> {
    private List<a3_data_target> data;

    public a3_adapter_target(List<a3_data_target> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public a3_adapter_target.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.a3_item_target, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull a3_adapter_target.ViewHolder viewHolder, int position) {
        viewHolder.getTargetName().setText(data.get(position).getTargetName());
        viewHolder.getTotalWork().setText(data.get(position).getTotalWork());
        viewHolder.getDoneWork().setText(data.get(position).getDoneWork());
        viewHolder.getDayRemaining().setText(data.get(position).getDayRemaining());
        viewHolder.getExpDate().setText(data.get(position).getExpectedDate());

        if (position == 2) {
            viewHolder.getTargetName().setTextColor(Color.RED);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView targetName, doneWork, dayRemaining, expDate;
        private final EditText totalWork;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            targetName = (TextView) view.findViewById(R.id.a3_target_name);
            doneWork = (TextView) view.findViewById(R.id.a3_target_done_view);
            dayRemaining = (TextView) view.findViewById(R.id.a3_target_day_view);
            expDate = (TextView) view.findViewById(R.id.a3_target_date_view);
            totalWork = (EditText) view.findViewById(R.id.a3_target_input_total);
        }


        public TextView getTargetName() {
            return targetName;
        }

        public TextView getDoneWork() {
            return doneWork;
        }

        public TextView getDayRemaining() {
            return dayRemaining;
        }

        public TextView getExpDate() {
            return expDate;
        }

        public EditText getTotalWork() {
            return totalWork;
        }
    }
}
