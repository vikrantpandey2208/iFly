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

public class a4_done extends AppCompatActivity {
    Universal universal = new Universal();
    private TargetViewModel targetViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a4_done);

        universal.SetStatusBar(a4_done.this);
        SetBottomNavigation();
        BackButton();
        SetAdapter();
    }

    private void SetAdapter() {
        RecyclerView recyclerView = findViewById(R.id.a4_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        a4_list_adapter adapter = new a4_list_adapter(new a4_list_adapter.TargetDiff());
        recyclerView.setAdapter(adapter);

        targetViewModel = new ViewModelProvider(this).get(TargetViewModel.class);

        targetViewModel.getNotDoneTargets().observe(this, targetTables -> {
            targetTables.add(new TargetTable(
                    "Check Work History",
                                0,0,0,"-1",false
                    ));
                    adapter.submitList(targetTables);
                }
        );
    }

    private void BackButton() {
        ImageButton back = findViewById(R.id.a4_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                universal.FinishActivity(a4_done.this);
            }
        });
    }
    private void SetBottomNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.a4_navigation);
        bottomNavigationView.getMenu().findItem(R.id.menu_done).setChecked(true);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_today: {
                        a4_done.this.finish();
                        break;
                    }
                    case R.id.menu_done: {
                        break;
                    }
                    case R.id.menu_target: {
                        universal.OpenGivenActivity(a4_done.this, a3_target.class,true);
                        break;
                    }
                    case R.id.menu_about: {
                        universal.OpenGivenActivity(a4_done.this, a5_about.class, true);
                        break;
                    }
                }
                return false;
            }
        });
    }
}