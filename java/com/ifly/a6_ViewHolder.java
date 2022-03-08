package com.ifly;

import android.app.Application;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;

public class a6_ViewHolder extends RecyclerView.ViewHolder {
    private final TextView slotTv;
    private final EditText taskEdit;
    private final AppCompatButton update;

    public a6_ViewHolder(@NonNull  View view) {
        super(view);

        slotTv = view.findViewById(R.id.a6_edit_slot_tv);
        taskEdit = view.findViewById(R.id.a6_edit_work);
        update = view.findViewById(R.id.a6_update);
    }

    public void bind(String slotStr, String taskStr) {

        slotTv.setText(slotStr);
        taskEdit.setText(taskStr);
        update.setVisibility(View.GONE);

        SetEditListener();
    }

    private void SetEditListener() {
        taskEdit.addTextChangedListener(textWatcher);
    }

    static a6_ViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.a6_edit_schedule_item, parent, false);
        return new a6_ViewHolder(view);
    }

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            update.setVisibility(View.VISIBLE);
            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ScheduleRepository scheduleRepository = new ScheduleRepository((Application) update.getContext().getApplicationContext());

                    String task = s.toString();


                    if (task.isEmpty()){
                        Toast.makeText(
                                update.getContext(),
                                R.string.empty_not_saved,
                                Toast.LENGTH_LONG).show();
                    }
                    else {
                        scheduleRepository.setNewTaskToSlot(slotTv.getText().toString(),task);

                        taskEdit.clearFocus();
                    }

                    update.setVisibility(View.GONE);
                }
            });
        }
    };
}
