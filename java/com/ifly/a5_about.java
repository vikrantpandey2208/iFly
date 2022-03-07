package com.ifly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class a5_about extends AppCompatActivity {
    Universal universal = new Universal();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a5_about);

        universal.SetStatusBar(a5_about.this);
        SetBottomNavigation();
        BackButton();
    }
    private void BackButton() {
        ImageButton back = findViewById(R.id.a5_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                universal.FinishActivity(a5_about.this);
            }
        });
    }
    private void SetBottomNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.a5_navigation);
        bottomNavigationView.getMenu().findItem(R.id.menu_about).setChecked(true);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_today: {
                        a5_about.this.finish();
                        break;
                    }
                    case R.id.menu_done: {
                        universal.OpenGivenActivity(a5_about.this, a4_done.class, true);
                        break;
                    }
                    case R.id.menu_target: {
                        universal.OpenGivenActivity(a5_about.this, a3_target.class, true);
                        break;
                    }
                    case R.id.menu_about: {
                        break;
                    }
                }
                return false;
            }
        });
    }
}