package com.example.dkiganjani;

import static com.android.volley.Request.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    EditText email_address, passcode;
    Button loginBtn;
    String loginUrl = "http://192.168.43.33/Dkiganjani/";
    private RequestQueue  requestQueue;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email_address = findViewById(R.id.email);
        passcode = findViewById(R.id.password);

        loginBtn = findViewById(R.id.login_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginUser();
            }
        });

    }

    private void LoginUser(){

        final String email =  email_address.getText().toString();
        final String password =  passcode.getText().toString();

        if(email.isEmpty()){
            email_address.setError("Emmail address is required");
            email_address.requestFocus();
            return;
        }

        if(password.isEmpty()){
            passcode.setError("Password is required");
            passcode.requestFocus();
            return;
        }

        StringRequest  stringRequest =  new StringRequest(Request.Method.POST,loginUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String results = jsonObject.getString("success");

                            if(results.equals("1")){
                                email_address.setText("");
                                passcode.setText("");

                                if(progressDialog != null  &&  progressDialog.isShowing()){
                                    progressDialog.dismiss();
                                }

                                progressDialog =  ProgressDialog.show(LoginActivity.this, "", "Loggin in....", true);

                                new Handler().postDelayed((Runnable) () ->{
                                    if(progressDialog  != null &&  progressDialog.isShowing()){
                                        progressDialog.dismiss();
                                    }

                                    try {
                                        Toast.makeText(LoginActivity.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                                        navigateHome();
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                },3000);
                            }

                            if(results.equals("0")){
                                email_address.setText("");
                                passcode.setText("");

                                Toast.makeText(LoginActivity.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley Error", error.toString());
                    }
                }
        ){

            @Nullable
            @Override
            protected Map<String, String> getParams() {
                 Map<String, String> params =  new HashMap<String, String>();
                 params.put("username", email);
                 params.put("password", password);

                 return params;
            }
        };
         requestQueue = Volley.newRequestQueue(LoginActivity.this);
         requestQueue.add(stringRequest);
    }

    private void navigateHome(){
        Intent intent =  new Intent(LoginActivity.this,HomeActivity.class );

        startActivity(intent);
    }
}