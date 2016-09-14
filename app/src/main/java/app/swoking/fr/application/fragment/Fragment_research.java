package app.swoking.fr.application.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import app.swoking.fr.application.R;
import app.swoking.fr.application.SlideShowView;
import app.swoking.fr.application.model.ItemResult;

public class Fragment_research extends Fragment {

    GridLayout gl;
    ImageView imgUser;
    HashMap<Integer, ImageView> result;
    int item;

    public Fragment_research() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_research, container, false);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

        gl = (GridLayout)rootView.findViewById(R.id.GridResult);
        gl.setColumnCount(3);

        ItemResult[] r;

        r = new ItemResult[9];

        r[0] = new ItemResult(container.getContext(), 2, "test", new String[]{"http://192.168.1.63:8080/LoginRegister/getImage.php?id=2", "http://192.168.1.63:8080/LoginRegister/getImage.php?id=1"});
        r[1] = new ItemResult(container.getContext(), 2, "test", new String[]{"http://192.168.1.63:8080/LoginRegister/getImage.php?id=2", "http://192.168.1.63:8080/LoginRegister/getImage.php?id=1"});
        r[2] = new ItemResult(container.getContext(), 2, "test", new String[]{"http://192.168.1.63:8080/LoginRegister/getImage.php?id=2", "http://192.168.1.63:8080/LoginRegister/getImage.php?id=1"});
        r[3] = new ItemResult(container.getContext(), 2, "test", new String[]{"http://192.168.1.63:8080/LoginRegister/getImage.php?id=2", "http://192.168.1.63:8080/LoginRegister/getImage.php?id=1"});
        r[4] = new ItemResult(container.getContext(), 2, "test", new String[]{"http://192.168.1.63:8080/LoginRegister/getImage.php?id=2", "http://192.168.1.63:8080/LoginRegister/getImage.php?id=1"});
        r[5] = new ItemResult(container.getContext(), 2, "test", new String[]{"http://192.168.1.63:8080/LoginRegister/getImage.php?id=2", "http://192.168.1.63:8080/LoginRegister/getImage.php?id=1"});
        r[6] = new ItemResult(container.getContext(), 2, "test", new String[]{"http://192.168.1.63:8080/LoginRegister/getImage.php?id=2", "http://192.168.1.63:8080/LoginRegister/getImage.php?id=1"});
        r[7] = new ItemResult(container.getContext(), 2, "test", new String[]{"http://192.168.1.63:8080/LoginRegister/getImage.php?id=2", "http://192.168.1.63:8080/LoginRegister/getImage.php?id=1"});
        r[8] = new ItemResult(container.getContext(), 2, "test", new String[]{"http://192.168.1.63:8080/LoginRegister/getImage.php?id=2", "http://192.168.1.63:8080/LoginRegister/getImage.php?id=1"});

        r[0].show(gl, displaymetrics.widthPixels / 3, (displaymetrics.widthPixels / 3)*9/16);
        r[1].show(gl, displaymetrics.widthPixels / 3, (displaymetrics.widthPixels / 3)*9/16);
        r[2].show(gl, displaymetrics.widthPixels / 3, (displaymetrics.widthPixels / 3)*9/16);
        r[3].show(gl, displaymetrics.widthPixels / 3, (displaymetrics.widthPixels / 3)*9/16);
        r[4].show(gl, displaymetrics.widthPixels / 3, (displaymetrics.widthPixels / 3)*9/16);
        r[5].show(gl, displaymetrics.widthPixels / 3, (displaymetrics.widthPixels / 3)*9/16);
        r[6].show(gl, displaymetrics.widthPixels / 3, (displaymetrics.widthPixels / 3)*9/16);
        r[7].show(gl, displaymetrics.widthPixels / 3, (displaymetrics.widthPixels / 3)*9/16);
        r[8].show(gl, displaymetrics.widthPixels / 3, (displaymetrics.widthPixels / 3)*9/16);


        return rootView;
    }

}
