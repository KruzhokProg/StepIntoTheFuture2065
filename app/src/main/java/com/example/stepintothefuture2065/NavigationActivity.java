package com.example.stepintothefuture2065;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.stepintothefuture2065.Fragments.AccountFragment;
import com.example.stepintothefuture2065.Fragments.ChatListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        BottomNavigationView btnNav = findViewById(R.id.bottomNavigationView);
        btnNav.setOnNavigationItemSelectedListener(navListener);
        btnNav.findViewById(R.id.person).performClick();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new AccountFragment()).commit();

    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.person:
                            selectedFragment = new AccountFragment();
                            break;
                        case R.id.chat:
                            selectedFragment = new ChatListFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, selectedFragment).commit();

                    return true;
                }
            };
}