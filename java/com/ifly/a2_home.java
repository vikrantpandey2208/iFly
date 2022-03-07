package com.ifly;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class a2_home extends AppCompatActivity {
    Universal universal = new Universal();
    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a2_home);

        universal.SetStatusBar(a2_home.this);
        SetBottomNavigation();
        SetTodayDate();
        SetAdapterGrid();


    }

    private void SetAdapterGrid() {
        GridView gridView = findViewById(R.id.a2_grid);
        String str = "Morning activities and walk Morning activities and walkMorning activities and walkMorning activities and walkMorning activities and walkMorning activities and";

        List<a2_home_item_container> list= new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            list.add(new a2_home_item_container("05:00-06:00 AM",str+i,false));
        }

        list.add(new a2_home_item_container("Edit Schedule","Now",false));

        gridView.setAdapter(new a2_home_adapter(list));
    }

    private void SetTodayDate() {
        TextView tv = findViewById(R.id.a2_heading);

        Date today = Calendar.getInstance().getTime();//getting date
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.ENGLISH);

        String date = formatter.format(today);

        date += " (";
        date += dayFormat.format(today);
        date += ")";

        tv.setText(date);

    }

    private void SetBottomNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.a2_navigation);
        bottomNavigationView.getMenu().findItem(R.id.menu_today).setChecked(true);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_today: {
                        break;
                    }
                    case R.id.menu_done: {
                        universal.OpenGivenActivity(a2_home.this, a4_done.class);
                        break;
                    }
                    case R.id.menu_target: {
                        universal.OpenGivenActivity(a2_home.this, a3_target.class);
                        break;
                    }
                    case R.id.menu_about: {
                        universal.OpenGivenActivity(a2_home.this, a5_about.class);
                        break;
                    }
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finishAffinity();
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }

}