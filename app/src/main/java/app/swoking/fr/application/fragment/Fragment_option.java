package app.swoking.fr.application.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.swoking.fr.application.R;

public class Fragment_option extends Fragment {

    public Fragment_option() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_option, container, false);
        return rootView;
    }

}
