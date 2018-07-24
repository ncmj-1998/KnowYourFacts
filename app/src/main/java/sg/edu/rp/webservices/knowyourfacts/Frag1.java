package sg.edu.rp.webservices.knowyourfacts;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag1 extends Fragment {

    Button btncolor ;
    View rootview;
    ArrayList<String> alColor;
    public Frag1() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview =  inflater.inflate(R.layout.fragment_frag1, container, false);

        btncolor = rootview.findViewById(R.id.button);
alColor = new ArrayList<String>();

        alColor.add("#ffdead");
        alColor.add("#0000ff");
        alColor.add("#adff2f");

        btncolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int minN = 0;
                final int maxN = alColor.size();
                Random r = new Random();
                final int random = r.nextInt((maxN - minN)) + minN;
                String color = alColor.get(random);
                Log.v("color", color);
                rootview.setBackgroundColor(Color.parseColor(color));
            }
        });
        return rootview;

    }

}
