package com.example.myfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.myfragment.fragment.AboutUsFragment;
import com.example.myfragment.fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        currentFragment = new HomeFragment(); // Initial fragment

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.menu_home) {
                    setCurrentFragment(new HomeFragment());
                    return true;
                } else if (itemId == R.id.menu_aboutus) {
                    setCurrentFragment(new AboutUsFragment());
                    return true;
                }
                return false;
            }
        });

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.homeFragment, currentFragment)
                .commit();

    }
    private void setCurrentFragment(Fragment fragment) {
        currentFragment = fragment;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.homeFragment, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }
}