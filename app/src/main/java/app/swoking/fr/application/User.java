package app.swoking.fr.application;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import app.swoking.fr.application.Activity.MainActivity;
import app.swoking.fr.application.Request.LoginRequest;
import app.swoking.fr.application.Request.UserRequest;

public class User implements Serializable {

    private int id;
    private String name;
    private String username;
    private int age;
    private String bio;
    private String[] urls;
    private boolean nourl;
    private boolean actual = false; // User actuelment connecter sur l'application
    private boolean connected = false; // User connecter ou non

    private User user;

    public User() {

    }

    public User(int id, String name, String username, int age, String bio, String[] urls, boolean connected, boolean actual) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.age = age;
        this.bio = bio;
        this.urls = urls;
        this.nourl = false;
        this.connected = connected;
        this.actual = actual;
    }

    public User(int id, String name, String username, int age, String bio, boolean nourl, boolean connected, boolean actual) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.age = age;
        this.bio = bio;
        this.nourl = nourl;
        this.urls = new String[] {"http://192.168.1.63:8080/LoginRegister/getImage.php?id=0"};
        this.connected = connected;
        this.actual = actual;
    }







    private String getResponse(final int id) {
        return
    }

    public User getUserFromId(int id, Context context) {

        user = ErrorUser();

        final Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    Log.d("<<<<<<<<<<<", jsonResponse.toString());
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {
                        if (jsonResponse.getJSONArray("url").getString(0).contains("http://")) {

                            JSONArray urlsJSON = jsonResponse.getJSONArray("url");
                            String[] arr = new String[urlsJSON.length()];
                            for (int i = 0; i < urlsJSON.length(); i++) {
                                arr[i] = urlsJSON.optString(i);
                            }
                            user = new User(jsonResponse.getInt("id"), jsonResponse.getString("name"), jsonResponse.getString("username"), jsonResponse.getInt("age"), jsonResponse.getString("bio"), arr, true, true);
                        } else {
                            user = new User(jsonResponse.getInt("id"), jsonResponse.getString("name"), jsonResponse.getString("username"), jsonResponse.getInt("age"), jsonResponse.getString("bio"), true, true, true);
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.d("<<<<<<<<", "mLock.notify();");
            }
        };

        UserRequest userRequest = new UserRequest(id, responseListener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(userRequest);

        try {
            responseListener.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.d("<<<<<<<<<<<", user.getName());
        return user;
    }

    public User(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.username = user.getUsername();
        this.age = user.getAge();
        this.bio = user.getBio();
        this.urls = user.getUrls();
        this.connected = user.isConnected();
        this.actual = user.isActual();
    }

    public User ErrorUser(){
        User user;
        this.id = 0;
        this.name = "#ERROR";
        this.username = "#ERROR";
        this.age = 0;
        this.bio = "#ERROR";
        this.urls = new String[] {"http://192.168.1.63:8080/LoginRegister/getImage.php?id=0"};
        this.nourl = true;
        this.connected = false;
        this.actual = false;
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public boolean isConnected() {
        return this.connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public String[] getUrls() {
        return urls;
    }

    public void setUrls(String[] urls) {
        this.urls = urls;
    }

    public boolean isActual() {
        return actual;
    }

    public void setActual(boolean actual) {
        this.actual = actual;
    }

    public boolean isNourl() {
        return nourl;
    }

    public void setNourl(boolean nourl) {
        this.nourl = nourl;
    }
}