package com.ifly;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class a3_popup extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    private EditText targetName, totalWork, doneWork, dayRemaining;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a3_target_popup);

        targetName = findViewById(R.id.a3_target_name_p);
        totalWork = findViewById(R.id.a3_target_input_total_p);
        doneWork = findViewById(R.id.a3_target_input_done_p);
        dayRemaining = findViewById(R.id.a3_target_day__input_p);

        final AppCompatButton button_save = findViewById(R.id.a3_p_save);

        button_save.setOnClickListener(view -> {

            Intent replyIntent = new Intent();
            if (InputEmpty()) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String targetStr = targetName.getText().toString();
                replyIntent.putExtra("target_name", targetStr);

                int input = Integer.parseInt( totalWork.getText().toString() );
                replyIntent.putExtra("total_work", input);

                input = Integer.parseInt( doneWork.getText().toString() );
                replyIntent.putExtra("done_work", input);

                input = Integer.parseInt( dayRemaining.getText().toString() );
                replyIntent.putExtra("day_remaining", input);

                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }

    private boolean InputEmpty() {
        return TextUtils.isEmpty(targetName.getText()) && TextUtils.isEmpty(totalWork.getText()) &&
                TextUtils.isEmpty(doneWork.getText()) && TextUtils.isEmpty(dayRemaining.getText());
    }
}