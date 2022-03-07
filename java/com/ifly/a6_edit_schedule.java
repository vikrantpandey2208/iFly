package com.ifly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class a6_edit_schedule extends AppCompatActivity {
    Universal universal = new Universal();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a6_edit_schedule);

        universal.SetStatusBar(a6_edit_schedule.this);
        SetBottomNavigation();
        BackButton();
        SetAdapterGrid();
    }
    private void SetAdapterGrid() {
        GridView gridView = findViewById(R.id.a6_grid);
        String str = "Edit Your Schedule here";

        List<a2_home_item_container> list= new ArrayList<>();
        for (int i = 0; i < 17; i++) {
            list.add(new a2_home_item_container("05:00-06:00 AM",str+i,false));
        }

        list.add(new a2_home_item_container("Save Schedule","Now",false));

        gridView.setAdapter(new a6_edit_adapter(list));
    }
    private void SetBottomNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.a6_navigation);
        bottomNavigationView.getMenu().findItem(R.id.menu_done).setChecked(false);


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