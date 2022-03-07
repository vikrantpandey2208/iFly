package com.ifly;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class a3_target extends AppCompatActivity {
    Universal universal = new Universal();
    private TargetViewModel targetViewModel;
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a3_target);

        universal.SetStatusBar(a3_target.this);
        SetBottomNavigation();
        BackButton();
        SetAdapter();

        // FAB
        FloatingActionButton fab = findViewById(R.id.a3_fab);
        fab.setOnClickListener( view -> {
            OpenDialog();
        });
    }


    private void OpenDialog() {
        a3_target_popup popup = new a3_target_popup(a3_target.this);
        popup.show();
        popup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popup.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }


    private void SetAdapter() {
        RecyclerView recyclerView = findViewById(R.id.a3_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        a3_list_adapter adapter = new a3_list_adapter(new a3_list_adapter.TargetDiff());
        recyclerView.setAdapter(adapter);

        targetViewModel = new ViewModelProvider(this).get(TargetViewModel.class);

        targetViewModel.getRemainingDayAsc().observe(this, targetTables -> {
                    adapter.submitList(targetTables);
                }
        );
    }

    private void BackButton() {
        ImageButton back = findViewById(R.id.a3_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                universal.FinishActivity(a3_target.this);
            }
        });
    }

    private void SetBottomNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.a3_navigation);
        bottomNavigationView.getMenu().findItem(R.id.menu_target).setChecked(true);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_today: {
                        a3_target.this.finish();
                        break;
                    }
                    case R.id.menu_done: {
                        universal.OpenGivenActivity(a3_target.this, a4_done.class, true);
                        break;
                    }
                    case R.id.menu_target: {
                        break;
                    }
                    case R.id.menu_about: {
                        universal.OpenGivenActivity(a3_target.this, a5_about.class, true);
                        break;
                    }
                }
                return false;
            }
        });
    }
}