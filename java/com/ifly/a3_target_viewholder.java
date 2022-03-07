package com.ifly;

import android.app.Application;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

public class a3_target_viewholder extends RecyclerView.ViewHolder {
    String TAG = "vik";

    private final TextView targetName, doneWork, dayRemaining, expDate;
    private final EditText totalWork;
    private final ProgressBar progressBar;
    private final AppCompatButton update;

    public a3_target_viewholder(View view) {
        super(view);
        // Define click listener for the ViewHolder's View

        targetName = (TextView) view.findViewById(R.id.a3_target_name);
        doneWork = (TextView) view.findViewById(R.id.a3_target_done_view);
        dayRemaining = (TextView) view.findViewById(R.id.a3_target_day_view);
        expDate = (TextView) view.findViewById(R.id.a3_target_date_view);
        totalWork = (EditText) view.findViewById(R.id.a3_target_input_total);
        progressBar = view.findViewById(R.id.a3_target_progress);
        update = view.findViewById(R.id.a3_update);
    }

    public void bind(a3_data_target data) {
        int total, done;
        total = data.getTotalWork();
        done = data.getDoneWork();


        getTargetName().setText(data.getTargetName());
        getTotalWork().setText(String.valueOf(total));
        getDoneWork().setText(String.valueOf(done));
        getDayRemaining().setText(String.valueOf(data.getDayRemaining()));
        getExpDate().setText(data.getExpectedDate());
        getProgressBar().setProgress((done*100)/total);

        SetEditListener(data);

    }
    private void SetEditListener(a3_data_target data) {
        totalWork.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                update.setVisibility(View.VISIBLE);
                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       TargetRepository targetRepository = new TargetRepository((Application) update.getContext().getApplicationContext());

                        targetRepository.updateTotalWork(Integer.parseInt(s.toString()),data.getTargetId());
                        update.setVisibility(View.GONE);
                        totalWork.clearFocus();
                    }
                });
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }
        });
    }

    static a3_target_viewholder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.a3_item_target, parent, false);
        return new a3_target_viewholder(view);
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

    public ProgressBar getProgressBar() {
        return progressBar;
    }
}
