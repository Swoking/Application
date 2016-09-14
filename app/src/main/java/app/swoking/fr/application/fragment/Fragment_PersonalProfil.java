package app.swoking.fr.application.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import app.swoking.fr.application.R;
import app.swoking.fr.application.SlideShowView;
import app.swoking.fr.application.User;

public class Fragment_PersonalProfil  extends Fragment {

    private User user;
    private TextView txtBio;
    private SlideShowView slideShow;

    public Fragment_PersonalProfil() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_personal_profil, container, false);
        user = (User)getArguments().getSerializable("user");

        getActivity().setTitle(user.getUsername() + " Profil");

        slideShow = (SlideShowView) rootView.findViewById(R.id.slideShow);
        slideShow.start(user.getUrls());

        txtBio = (TextView) rootView.findViewById(R.id.txtBio);
        txtBio.setText(user.getBio());

        return rootView;
    }
}
