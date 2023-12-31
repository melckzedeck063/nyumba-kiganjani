package com.example.dkiganjani;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private FrameLayout frameLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

       frameLayout = findViewById(R.id.frame_container);
        toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar); // Set the Toolbar as the ActionBar


        navigationView =  findViewById(R.id.nav_menu);
        drawerLayout =  findViewById(R.id.drawer_container);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(HomeActivity.this, drawerLayout, toolbar, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.user_menu:
//                            drawerLayout.closeDrawer(GravityCompat.START);
                                startActivity(new Intent(HomeActivity.this, NewPropActivity.class));
                            break;
                        case R.id.settings_menu:
//                                drawerLayout.closeDrawer(GravityCompat.START);
                                Toast.makeText(HomeActivity.this, "SETTINGS MENU CALLED", Toast.LENGTH_SHORT).show();
                            break;
                            // Add more cases for other menu items
                        default:
                            throw new IllegalStateException("Unexpected value: " + item.getItemId());
                    }
                drawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                }
        });

        replaceFragment(new HomeFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.navigation_home:
                    replaceFragment(new HomeFragment());
                    return true;
                case R.id.navigation_cart:
                    replaceFragment(new CartFragment());
                    return true;
                case R.id.navigation_notifications:
                    replaceFragment(new NotificationsFragment());
                    return true;
                case R.id.navigation_profile:
                    replaceFragment(new ProfileFragment());
                    return true;
            }
            return false;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.home_container, fragment);
        fragmentTransaction.commit();
    }



}