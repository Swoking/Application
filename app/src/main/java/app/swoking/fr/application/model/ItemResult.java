package app.swoking.fr.application.model;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import app.swoking.fr.application.R;
import app.swoking.fr.application.SlideShowView;
import app.swoking.fr.application.User;
import app.swoking.fr.application.fragment.Fragment_PersonalProfil;
import app.swoking.fr.application.fragment.Fragment_research;

public class ItemResult {

    private int       id;
    private String    text;
    private String[]  urls;

    private Context context;
    private ImageView imgView;

    public ItemResult(Context context, int id, String text, String[] urls) {
        this.context = context;
        this.id     = id;
        this.text   = text;
        this.urls    = urls;
    }

    public void show(GridLayout gridLayout, int width, int height) {
        SlideShowView slideShowView = new SlideShowView(getContext());
        gridLayout.addView(slideShowView, width, height);
        slideShowView.start(getUrls());

        slideShowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Fragment_PersonalProfil();
                Bundle args1 = new Bundle();
                args1.putSerializable("user", new User().getUserFromId(getId(), getContext()));
                fragment.setArguments(args1);

                FragmentManager fragmentManager = ((Activity)context).getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_ceontent, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getUrls() {
        return urls;
    }

    public void setUrls(String[] urls) {
        this.urls = urls;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ImageView getImgView() {
        return imgView;
    }

    public void setImgView(ImageView imgView) {
        this.imgView = imgView;
    }
}
