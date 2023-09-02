package com.example.dkiganjani;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PropertyAdapter propertyAdapter;
    ArrayList<Property>  propertyArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        recyclerView = findViewById(R.id.recycle_view1);


//        createProperty();

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

    private void createProperty(){
        propertyArrayList = new ArrayList<>();
        propertyArrayList.add(new Property("120K/Month", "Self contained room", "Nzuguni Dodoma", "3/6  Months", "", R.mipmap.house1));
        propertyArrayList.add(new Property("120K/Month", "Self contained room", "Nzuguni Dodoma", "3/6  Months", "", R.mipmap.house2));
        propertyArrayList.add(new Property("120K/Month", "Self contained room", "Nzuguni Dodoma", "3/6  Months", "", R.mipmap.house3));
        propertyArrayList.add(new Property("120K/Month", "Self contained room", "Nzuguni Dodoma", "3/6  Months", "", R.mipmap.house1));
        propertyArrayList.add(new Property("120K/Month", "Self contained room", "Nzuguni Dodoma", "3/6  Months", "", R.mipmap.house3));

        propertyAdapter = new PropertyAdapter(propertyArrayList, getBaseContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL,false));
        recyclerView.setNestedScrollingEnabled(false);
    }
}