package app.swoking.fr.application.Activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import app.swoking.fr.application.Request.LoginRequest;
import app.swoking.fr.application.R;
import app.swoking.fr.application.User;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");

        final EditText etUsername   = (EditText) findViewById(R.id.login_etUsername);
        final EditText etPassword   = (EditText) findViewById(R.id.login_etPassword);
        final Button bLogin         = (Button)   findViewById(R.id.login_bLogin);
        final TextView registerLink = (TextView) findViewById(R.id.login_tvRegisterHere);

        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success){
                                if(jsonResponse.getJSONArray("url").getString(0).contains("http://") ){

                                    JSONArray urlsJSON       = jsonResponse.getJSONArray("url");
                                    String[] arr = new String[urlsJSON.length()];
                                    for(int i=0; i<urlsJSON.length(); i++) {
                                        arr[i]=urlsJSON.optString(i);
                                    }
                                    User user = new User(jsonResponse.getInt("id"), jsonResponse.getString("name"), jsonResponse.getString("username"), jsonResponse.getInt("age"), jsonResponse.getString("bio"), arr, true, true);

                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    intent.putExtra("user", user);
                                    LoginActivity.this.startActivity(intent);
                                } else {
                                    User user = new User(jsonResponse.getInt("id"), jsonResponse.getString("name"), jsonResponse.getString("username"), jsonResponse.getInt("age"), jsonResponse.getString("bio"), true, true, true);

                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    intent.putExtra("user", user);
                                    LoginActivity.this.startActivity(intent);
                                }


                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Login Failed")
                                       .setNegativeButton("Retry", null)
                                       .create()
                                       .show();
                            }
                        } catch (JSONException e) {

                            Log.e("LoginResponseERROR", "Login response are not JSON format.");
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });
    }
}
