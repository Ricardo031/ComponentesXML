package com.example.componentesxmlenfragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private FrameLayout fr_home;
    private BottomNavigationView bt_nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicioFragment inicioFragment = new inicioFragment();
        imgFragment imgFragment = new imgFragment();
        spinnerFragment spinnerFragment = new spinnerFragment();
        loadFragment(inicioFragment);
        fr_home = findViewById(R.id.fr_home);
        bt_nav = findViewById(R.id.bt_nav);
        bt_nav.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId()==R.id.nav_navig) {
                    loadFragment(inicioFragment);
                    return true;
                }
                else if (menuItem.getItemId() == R.id.nav_img) {
                    loadFragment(imgFragment);
                }else if (menuItem.getItemId() == R.id.nav_spinner) {
                    loadFragment(spinnerFragment);
                }
                return false;
            }
        });

    }
    public void loadFragment(Fragment fr) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fr_home, fr);
        transaction.commit();
    }

}