package com.ifly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class a6_edit_schedule extends AppCompatActivity {
    Universal universal = new Universal();
    private ScheduleViewModel scheduleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a6_edit_schedule);

        universal.SetStatusBar(a6_edit_schedule.this);
        SetBottomNavigation();
        SetTodayDate();
        BackButton();
        SetAdapter();
    }

    private void SetAdapter() {
        RecyclerView recyclerView = findViewById(R.id.a6_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        a6_ListAdapter adapter = new a6_ListAdapter(new a6_ListAdapter.TargetDiff());
        recyclerView.setAdapter(adapter);

        scheduleViewModel = new ViewModelProvider(this).get(ScheduleViewModel.class);

        scheduleViewModel.getAllScheduleEntry().observe(this, scheduleTables -> {
                    adapter.submitList(scheduleTables);
                }
        );
    }

    private void SetTodayDate() {
        TextView tv = findViewById(R.id.a6_heading);

        tv.setText(Universal.TODAY+" (Scheduling)");

    }

    private void SetBottomNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.a6_navigation);
        bottomNavigationView.getMenu().setGroupCheckable(0, false, true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_today: {
                        a6_edit_schedule.this.finish();
                        break;
                    }
                    case R.id.menu_done: {
                        universal.OpenGivenActivity(a6_edit_schedule.this, a4_done.class,true);
                        break;
                    }
                    case R.id.menu_target: {
                        universal.OpenGivenActivity(a6_edit_schedule.this, a3_target.class,true);
                        break;
                    }
                    case R.id.menu_about: {
                        universal.OpenGivenActivity(a6_edit_schedule.this, a5_about.class, true);
                        break;
                    }
                }
                return false;
            }
        });
    }
    private void BackButton() {
        ImageButton back = findViewById(R.id.a6_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                universal.FinishActivity(a6_edit_schedule.this);
            }
        });
    }
}