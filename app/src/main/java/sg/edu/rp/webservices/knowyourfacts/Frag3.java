package sg.edu.rp.webservices.knowyourfacts;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.crazyhitty.chdev.ks.rssmanager.RssReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag3 extends Fragment implements RssReader.RssCallback {
    TextView tv;
    Button btncolor;
    View rootview;
    ArrayList<String> alColor;
    RssReader rssReader;

    public Frag3() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_frag3, container, false);
        alColor = new ArrayList<String>();
        tv = rootview.findViewById(R.id.textView);
        alColor.add("#ffdead");
        alColor.add("#0000ff");
        alColor.add("#adff2f");
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

        rssReader = new RssReader(this);
        rssReader.loadFeeds("https://www.gov.sg/rss/factuallyrss");
        return rootview;
    }


    @Override
    public void rssFeedsLoaded(List<com.crazyhitty.chdev.ks.rssmanager.RSS> rssList) {
        String url = rssList.get(0).getChannel().getItems().get(0).getDescription();
        String title = rssList.get(0).getChannel().getItems().get(0).getTitle();
        String pubDate = rssList.get(0).getChannel().getItems().get(0).getPubDate();
        String link = rssList.get(0).getChannel().getItems().get(0).getLink();
//        String image = rssList.get(0).getChannel().getItems().get(0)
        Log.v("RSS","loaded");
tv.setText(url);

    }

    @Override
    public void unableToReadRssFeeds(String errorMessage) {
        // Oops, library was unable to parse your feed url.
        Log.v("RSS","no");

    }
}
