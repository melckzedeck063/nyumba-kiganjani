package com.example.dkiganjani;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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

public class RegisterActivity extends AppCompatActivity {

    EditText firstname,lastname, email_address,telephone,passcode;
    Button registerBtn;
    String RegisterURL = "http://192.168.43.33/Dkiganjani/register.php";

    private RequestQueue requestQueue;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstname = findViewById(R.id.fname);
        lastname =  findViewById(R.id.lname);
        email_address =  findViewById(R.id.email);
        telephone =  findViewById(R.id.phone);
        passcode =  findViewById(R.id.password);

        registerBtn =  findViewById(R.id.register_btn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterUser();
            }
        });
    }

    private void RegisterUser() {

        final String fname =  firstname.getText().toString();
        final String lname =  lastname.getText().toString();
        final String email = email_address.getText().toString();
        final String phone =  telephone.getText().toString();
        final String password  =  passcode.getText().toString();
        final String user_type = "user";

        if(fname.isEmpty()){
            firstname.setError("Firstname is required");
            firstname.requestFocus();
            return;
        }

        if(lname.isEmpty()){
            lastname.setError("Lastname is required");
            lastname.requestFocus();
            return;
        }
        if(email.isEmpty()){
            email_address.setError("Email address is required");
            email_address.requestFocus();
            return;
        }
        if(phone.isEmpty()){
            telephone.setError("phone number is required");
            telephone.requestFocus();
            return;
        }
        if(password.isEmpty()){
            passcode.setError("Password  is required");
            passcode.requestFocus();
            return;
        }
        StringRequest stringRequest = new StringRequest(Request.Method.POST, RegisterURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String results = jsonObject.getString("success");

                            if (results.equals("1")) {
                                firstname.setText("");
                                lastname.setText("");
                                email_address.setText("");
                                passcode.setText("");
                                telephone.setText("");

                                if (progressDialog != null && progressDialog.isShowing()) {
                                    progressDialog.dismiss();
                                }
                                progressDialog = ProgressDialog.show(RegisterActivity.this, "", "Creating account...", true);

                                new Handler().postDelayed((Runnable) () -> {

                                    if (progressDialog != null && progressDialog.isShowing()) {
                                        progressDialog.dismiss();
                                    }
                                    try {
                                        Toast.makeText(RegisterActivity.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    navigateLogin();

                                }, 3000);
                            }
                            else {
                                Toast.makeText(RegisterActivity.this, jsonObject.getString("message"),Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RegisterActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {

            @Nullable
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("firstname", fname);
                params.put("lastname", lname);
                params.put("username", email);
                params.put("phone", phone);
                params.put("role", user_type);
                params.put("password", password);
                return params;
            }
        };
        requestQueue = Volley.newRequestQueue(RegisterActivity.this);
        requestQueue.add(stringRequest);
    }



    private void navigateLogin(){
        Intent intent =  new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }

}