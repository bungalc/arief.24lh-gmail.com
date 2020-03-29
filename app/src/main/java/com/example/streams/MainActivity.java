package com.example.streams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<slide> lstSlides ;
    private ViewPager sliderpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sliderpager = findViewById(R.id.slider_pager);

        //prepare a list of slide
        lstSlides = new ArrayList<>();
        lstSlides.add(new slide (R.drawable.slide1, "Interstellar"));
        lstSlides.add(new slide (R.drawable.slide2, "Once Upon a Time in Holywood"));
        lstSlides.add(new slide (R.drawable.slide3, "Avengers"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstSlides);
        sliderpager.setAdapter(adapter);
    }
}
