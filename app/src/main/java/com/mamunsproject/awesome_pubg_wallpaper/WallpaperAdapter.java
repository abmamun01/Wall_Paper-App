package com.mamunsproject.awesome_pubg_wallpaper;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.WallpaperHolder> {

    private ArrayList<String> list;
    private Context context;

    public WallpaperAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public WallpaperHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(context).inflate(R.layout.custom_image_layout,parent,false);
        return new WallpaperHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull WallpaperHolder holder, int position) {

        Glide.with(context).load(list.get(position)).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context,Full_Image_Activity.class );

                intent.putExtra("image",list.get(position));
                context.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class WallpaperHolder extends RecyclerView.ViewHolder {

        RoundedImageView imageView;
        public WallpaperHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.item_IMage);
        }
    }
}
