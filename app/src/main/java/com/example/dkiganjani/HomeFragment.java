package com.example.dkiganjani;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private   PropertyAdapter  propertyAdapter;
    ArrayList<Property> propertyArrayList;
    private SharedPreferenceHelper sharedPreferenceHelper;
    private SharedPreferences sharedPreferences;
    TextView user_name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view  =   inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recycler_view2);

        sharedPreferenceHelper =  new SharedPreferenceHelper(getContext());

        String firstname = sharedPreferenceHelper.getFirstname() + " " + sharedPreferenceHelper.getLastname();
        String username  = sharedPreferenceHelper.getUsername();
        if(username.isEmpty()){
            Intent intent =  new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        }
        user_name = view.findViewById(R.id.user_name);
        user_name.setText(firstname);

        createProperty();

        return view;

    }

    private void createProperty(){
        propertyArrayList =  new ArrayList<>();
        propertyArrayList.add(new Property("280/Month", "3 Bedrooms house", "Kilimani Dodoma", "3/6 Months",  "", R.mipmap.house2));
        propertyArrayList.add(new Property("120K/Month", "Self contained room", "Nzuguni Dodoma", "3/6  Months", "", R.mipmap.house1));
        propertyArrayList.add(new Property("120K/Month", "Self contained room", "Nzuguni Dodoma", "3/6  Months", "", R.mipmap.house2));
        propertyArrayList.add(new Property("120K/Month", "Self contained room", "Nzuguni Dodoma", "3/6  Months", "", R.mipmap.house3));
        propertyArrayList.add(new Property("120K/Month", "Self contained room", "Nzuguni Dodoma", "3/6  Months", "", R.mipmap.house1));
        propertyArrayList.add(new Property("120K/Month", "Self contained room", "Nzuguni Dodoma", "3/6  Months", "", R.mipmap.house3));

        propertyAdapter  =  new PropertyAdapter(propertyArrayList, getContext());
        recyclerView.setAdapter(propertyAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}