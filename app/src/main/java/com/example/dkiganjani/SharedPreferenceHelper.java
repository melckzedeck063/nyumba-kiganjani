package com.example.dkiganjani;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceHelper {

    private SharedPreferences sharedPreferences;
    private Context  context;
    private String firstname="firstname", lastname="lastname", username="username",phone="phone", role="role";

    public SharedPreferenceHelper (Context context){
        this.sharedPreferences = context.getSharedPreferences("login_session", Context.MODE_PRIVATE);
        this.context =  context;
    }

    public String getFirstname() {
        return sharedPreferences.getString(firstname, "");
    }

    public String getLastname() {
        return sharedPreferences.getString(lastname, "");
    }

    public String getUsername() {
        return sharedPreferences.getString(username,  "");
    }

    public String getPhone() {
        return sharedPreferences.getString(phone, "");
    }

    public String getRole(){
        return sharedPreferences.getString(role, "");
    }

    public void setFirstname(String firstname) {
        SharedPreferences.Editor edit  = sharedPreferences.edit();
        edit.putString(this.firstname, firstname);
        edit.commit();
    }

    public void setLastname(String lastname) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(this.lastname, lastname);
        edit.commit();
    }

    public void setUsername(String username) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(this.username, username);
        edit.commit();
    }

    public void setPhone(String phone) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(this.phone,phone);
        edit.commit();
    }

    public void setRole(String role) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(this.role,  role);
        edit.commit();
    }
}
