package com.mamunsproject.awesome_pubg_wallpaper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    private List<ViewPagerModel> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public ViewPagerAdapter(List<ViewPagerModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

       layoutInflater=LayoutInflater.from(context);
       View view=layoutInflater.inflate(R.layout.sample_view_pager,container,false);

       ImageView imageView;
       TextView title,desc;

       imageView=view.findViewById(R.id.image);
       title=view.findViewById(R.id.title);
       desc=view.findViewById(R.id.desc);

       imageView.setImageResource(models.get(position).getImage());
       title.setText(models.get(position).getTitle());
       desc.setText(models.get(position).getDesc());

       view.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Toast.makeText(context,"Clicked"+position,Toast.LENGTH_SHORT ).show();
               if (position==0){
                  context.startActivity(new Intent(context,MainActivity.class));
               }



           }
       });

       container.addView(view,0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
