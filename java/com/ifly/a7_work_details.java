package com.ifly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class a7_work_details extends AppCompatActivity {
    Universal universal = new Universal();
    private DoneViewModel doneViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a7_work_details);

        universal.SetStatusBar(a7_work_details.this);
        SetBottomNavigation();
        BackButton();
        SetAdapter();
    }
    private void SetAdapter() {
        RecyclerView recyclerView = findViewById(R.id.a7_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        a7_ListAdapter adapter = new a7_ListAdapter(new a7_ListAdapter.TargetDiff());
        recyclerView.setAdapter(adapter);

        doneViewModel = new ViewModelProvider(this).get(DoneViewModel.class);

        doneViewModel.getAllDoneDetails().observe(this, doneTables -> {

                    adapter.submitList(doneTables);
                }
        );
    }

    private void BackButton() {
        ImageButton back = findViewById(R.id.a7_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                universal.FinishActivity(a7_work_details.this);
            }
        });
    }
    private void SetBottomNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.a7_navigation);
        bottomNavigationView.getMenu().setGroupCheckable(0, false, true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_today: {
                        universal.OpenGivenActivity(a7_work_details.this, a2_home.class,true);
                        finishAffinity();
                        break;
                    }
                    case R.id.menu_done: {
                        a7_work_details.this.finish();
                        break;
                    }
                    case R.id.menu_target: {
                        universal.OpenGivenActivity(a7_work_details.this, a3_target.class,true);
                        finishAffinity();
                        break;
                    }
                    case R.id.menu_about: {
                        universal.OpenGivenActivity(a7_work_details.this, a5_about.class, true);
                        finishAffinity();
                        break;
                    }
                }
                return false;
            }
        });
    }
}