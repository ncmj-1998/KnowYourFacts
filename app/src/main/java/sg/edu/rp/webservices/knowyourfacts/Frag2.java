package sg.edu.rp.webservices.knowyourfacts;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag2 extends Fragment {
    ImageView iv;

    Button btncolor;
    View rootview;
    ArrayList<String> alColor;
    public Frag2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_frag2, container, false);
        alColor = new ArrayList<String>();

        alColor.add("#ffdead");
        alColor.add("#0000ff");
        alColor.add("#adff2f");


        iv =  rootview.findViewById(R.id.imageView);
        iv.setImageResource(R.mipmap.ic_launcher);

        String imageUrl = "https://78.media.tumblr.com/9d401bb26bb82278dbcc3f4dda840360/tumblr_pccg9cDVVp1roqv59o1_500.png";
        Picasso.with(getActivity()).load(imageUrl).into(iv);

        btncolor = rootview.findViewById(R.id.button);
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
