package com.ifly;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class a3_target_popup extends Dialog {
    private EditText targetName, totalWork, doneWork, dayRemaining;
    Activity activity;

    public a3_target_popup(@NonNull Context context) {
        super(context);
        activity = (a3_target)context;
    }

    public a3_target_popup(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected a3_target_popup(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.a3_target_popup);

        targetName = findViewById(R.id.a3_target_name_p);
        totalWork = findViewById(R.id.a3_target_input_total_p);
        doneWork = findViewById(R.id.a3_target_input_done_p);
        dayRemaining = findViewById(R.id.a3_target_day__input_p);

        final AppCompatButton button_save = findViewById(R.id.a3_p_save);

        button_save.setOnClickListener(view -> {

            if (InputEmpty()) {
                Toast.makeText(
                        activity.getApplicationContext(),
                        R.string.empty_not_saved,
                        Toast.LENGTH_LONG).show();

            } else {
                TargetViewModel targetViewModel =new TargetViewModel(activity.getApplication());
                String targetStr = targetName.getText().toString();

                int totalWorkNum = Integer.parseInt( totalWork.getText().toString() );
                int doneWorkNum = Integer.parseInt( doneWork.getText().toString() );
                int dayRem = Integer.parseInt( dayRemaining.getText().toString() );

                Calendar c = Calendar.getInstance();

                c.setTime(new Date());
                c.add(Calendar.DATE, dayRem);
                Date d = c.getTime();

                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                String expDate = formatter.format(d);

                TargetTable target = new TargetTable(
                        targetStr,
                        dayRem,
                        totalWorkNum,
                       doneWorkNum,
                        expDate,
                        false
                );
                targetViewModel.insert(target);
            }
            dismiss();
        });
    }

    private boolean InputEmpty() {
        return TextUtils.isEmpty(targetName.getText()) && TextUtils.isEmpty(totalWork.getText()) &&
                TextUtils.isEmpty(doneWork.getText()) && TextUtils.isEmpty(dayRemaining.getText());
    }

}
