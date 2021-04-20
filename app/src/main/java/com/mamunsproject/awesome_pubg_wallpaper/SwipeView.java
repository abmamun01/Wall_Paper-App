package com.mamunsproject.awesome_pubg_wallpaper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SwipeView extends AppCompatActivity {

    ViewPager viewPager;
    ViewPagerAdapter adapter;
    Integer[] colors=null;
    List<ViewPagerModel> models;
    ArgbEvaluator argbEvaluator=new ArgbEvaluator();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_view);

        models=new ArrayList<>();
        models.add(new ViewPagerModel(R.drawable.pubg6,"Action","Pubg Is a Professional Type OF Game That's Encouratge Player To "));
        models.add(new ViewPagerModel(R.drawable.pubg1,"Fight","Pubg Is a Professional Type OF Game That's Encouratge Player To "));
        models.add(new ViewPagerModel(R.drawable.pubg9,"War","Pubg Is a Professional Type OF Game That's Encouratge Player To "));
        models.add(new ViewPagerModel(R.drawable.pubg12,"Attitude","Pubg Is a Professional Type OF Game That's Encouratge Player To "));

        adapter =new ViewPagerAdapter(models,SwipeView.this);

        viewPager=findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        Integer[] colors_temp=
                {
                        getResources().getColor(R.color.color1),
                        getResources().getColor(R.color.color2),
                        getResources().getColor(R.color.color3),
                        getResources().getColor(R.color.color4)};


        colors=colors_temp;



        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position<(adapter.getCount()-1)&& position<(colors.length-1)){

                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset,colors[position],colors[position+1]));
                }else {
                    viewPager.setBackgroundColor(colors[colors.length-1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}