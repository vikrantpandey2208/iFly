package com.ifly;

import android.app.Application;
import android.content.Intent;
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

public class a4_viewholder extends RecyclerView.ViewHolder {

    private final TextView targetName, doneTv, detailsTv;
    private final EditText newDoneWork, workDetails;
    private final AppCompatButton update;
    int id = -1;
    String targetNameS = null;
    String TAG = "vik";

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
                    TargetRepository targetRepository = new TargetRepository((Application) update.getContext().getApplicationContext());
                    DoneRepository doneRepository = new DoneRepository((Application) update.getContext().getApplicationContext());

                    String newDone = newDoneWork.getText().toString();

                    Calendar calendar = Calendar.getInstance();
                    int tHour = calendar.get(Calendar.HOUR_OF_DAY);

                    if (tHour <= 21) {
                        Toast.makeText(
                                update.getContext(),
                                R.string.only_after_9,
                                Toast.LENGTH_LONG).show();
                    } else if (newDone.isEmpty() || workDetails.getText().toString().isEmpty()) {
                        Toast.makeText(
                                update.getContext(),
                                R.string.empty_not_saved,
                                Toast.LENGTH_LONG).show();
                    } else {
                        targetRepository.updateAddToDoneWork(Integer.parseInt(newDone), id);
                        doneRepository.insert(new DoneTable(
                                targetNameS, workDetails.getText().toString().trim(), "09-Mar-2022"
                        ));
                        newDoneWork.clearFocus();
                        workDetails.clearFocus();
                    }


                    update.setVisibility(View.GONE);
                }
            });
        }
    };

    public a4_viewholder(@NonNull View view) {
        super(view);

        targetName = (TextView) view.findViewById(R.id.a4_done_target_name);
        newDoneWork = view.findViewById(R.id.a4_done_input);
        workDetails = view.findViewById(R.id.a4_done_detail_input);
        update = view.findViewById(R.id.a4_update);
        doneTv = view.findViewById(R.id.a4_done_tv);
        detailsTv = view.findViewById(R.id.a4_done_detail_tv);
    }

    public void bind(String targetNameStr, int id) {
        targetName.setText(targetNameStr);
        this.id = id;
        this.targetNameS = targetNameStr;

        SetEditListener();

    }

    public void bind(String targetNameStr, int id, boolean last) {
        targetName.setText("Check Work History");
        update.setVisibility(View.VISIBLE);
        update.setText("Work Details");
        newDoneWork.setVisibility(View.GONE);
        workDetails.setVisibility(View.GONE);
        doneTv.setVisibility(View.GONE);
        detailsTv.setVisibility(View.GONE);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(update.getContext(), a7_work_details.class);
                update.getContext().startActivity(intent);
            }
        });
    }

    static a4_viewholder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.a4_done_item, parent, false);
        return new a4_viewholder(view);
    }

    private void SetEditListener() {
        newDoneWork.addTextChangedListener(textWatcher);
        workDetails.addTextChangedListener(textWatcher);
    }
}
