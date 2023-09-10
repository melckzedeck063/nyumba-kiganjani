package com.example.dkiganjani;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private   PropertyAdapter  propertyAdapter;
    ArrayList<Property> propertyArrayList;
    private SharedPreferenceHelper sharedPreferenceHelper;
    private SharedPreferences sharedPreferences;
    TextView user_name;
    FrameLayout frameLayout;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view  =   inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recycler_view2);


//        frameLayout = view.findViewById(R.id.frame_layout);
//        toolbar = view.findViewById(R.id.toolbar);
//        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar); // Set the Toolbar as the ActionBar
//
//
//        navigationView =  view.findViewById(R.id.nav);
//        drawerLayout =  view.findViewById(R.id.drawer_layout);
//
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.open, R.string.close);
//
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
//
//
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                    switch (item.getItemId()) {
//                        case R.id.user_menu:
//                            try {
//                                startActivity(new Intent(getActivity(), NewPropActivity.class));
//                            } catch (Exception e) {
//                                Log.e("Navigation Error", "Failed to start NewProperty activity: " + e.getMessage());
//                            }
//                            break;
//                        case R.id.settings_menu:
//                            try {
//                                Toast.makeText(getContext(), "SETTINGS MENU CALLED", Toast.LENGTH_SHORT).show();
//                            } catch (Exception e) {
//                                Log.e("Navigation Error", "Failed to start NewProperty activity: " + e.getMessage());
//                            }
//                            break;
//                            // Add more cases for other menu items
//                        default:
//                            throw new IllegalStateException("Unexpected value: " + item.getItemId());
//                    }
//                    drawerLayout.closeDrawer(GravityCompat.START); // Close the drawer
//                    return true;
//                }
//        });


        sharedPreferenceHelper =  new SharedPreferenceHelper(getContext());

        String firstname = sharedPreferenceHelper.getFirstname() + " " + sharedPreferenceHelper.getLastname();
        String username  = sharedPreferenceHelper.getUsername();
        if(username.isEmpty()){
            Intent intent =  new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        }

        createProperty();

        return view;

    }

    private void createProperty(){
        propertyArrayList =  new ArrayList<>();
        propertyArrayList.add(new Property("280K/Month", "3 Bedrooms house", "Kilimani Dodoma", "3/6 Months",  "", R.mipmap.house2));
        propertyArrayList.add(new Property("120K/Month", "Self contained room", "Nzuguni Dodoma", "3/6  Months", "", R.mipmap.house1));
        propertyArrayList.add(new Property("120K/Month", "Self contained room", "Nzuguni Dodoma", "3/6  Months", "", R.mipmap.house2));
        propertyArrayList.add(new Property("120K/Month", "Self contained room", "Nzuguni Dodoma", "3/6  Months", "", R.mipmap.house3));
        propertyArrayList.add(new Property("120K/Month", "Self contained room", "Nzuguni Dodoma", "3/6  Months", "", R.mipmap.house1));
        propertyArrayList.add(new Property("120K/Month", "Self contained room", "Nzuguni Dodoma", "3/6  Months", "", R.mipmap.house3));

        propertyAdapter  =  new PropertyAdapter(propertyArrayList, getContext());
        recyclerView.setAdapter(propertyAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void navigateActivity(Class<? extends Activity> activityClass) {
        Log.d("Navigation", "Navigating to " + activityClass.getSimpleName());
        Intent intent = new Intent(getContext(), activityClass);
        startActivity(intent);
    }

    public void displayMessage(){
        Toast.makeText(getContext(), "Hello nav", Toast.LENGTH_LONG).show();
    }
}