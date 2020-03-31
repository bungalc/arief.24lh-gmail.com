package com.example.streams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private List<slide> lstSlides ;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView MoviesRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sliderpager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        MoviesRv = findViewById(R.id.Rv_movies);

        //prepare a list of slide
        lstSlides = new ArrayList<>();
        lstSlides.add(new slide (R.drawable.slide1, "Interstellar / join in time and space adventure."));
        lstSlides.add(new slide (R.drawable.slide2, "Once Upon a Time in Holywood"));
        lstSlides.add(new slide (R.drawable.slide3, "Avengers"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstSlides);
        sliderpager.setAdapter(adapter);

        //set timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MainActivity.SliderTimer(), 4000, 6000);

        indicator.setupWithViewPager(sliderpager,true);

        //recycler
        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Forrest Gump",R.drawable.fg));
        lstMovies.add(new Movie("Jurassic World",R.drawable.jw));
        lstMovies.add(new Movie("Captain Marvel",R.drawable.cm));
        lstMovies.add(new Movie("Big Hero 6",R.drawable.bh));
        lstMovies.add(new Movie("Infintiy War",R.drawable.iw));
        lstMovies.add(new Movie("AD astra",R.drawable.as));

        MovieAdapter movieAdapter = new MovieAdapter(this,lstMovies);
        MoviesRv.setAdapter(movieAdapter);
        MoviesRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));




    }
    class SliderTimer extends TimerTask {
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderpager.getCurrentItem()<lstSlides.size()-1) {
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                    }
                    else
                        sliderpager.setCurrentItem(0);
                }
            });

        }
    }


}
