package com.example.yalantis;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> {

    private String[] mImagesUrl;
    private Context mContext;
    private ImageView mImage; //[Comment] It should be viewholder local variable

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder (View view) {
            super(view);

            mImage = (ImageView) view.findViewById(R.id.myImage);
        }
    }

    public RVAdapter (Context context, String[] imagesUrl) {
        this.mContext = context;
        this.mImagesUrl = imagesUrl;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View itemView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.images, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder, int position) {
        Picasso.with(mContext).load(mImagesUrl[position]).into(mImage);
    }

    @Override
    public int getItemCount(){
        return mImagesUrl.length;
    }
}
