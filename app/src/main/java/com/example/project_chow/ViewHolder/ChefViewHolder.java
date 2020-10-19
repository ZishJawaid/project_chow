package com.example.project_chow.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_chow.Interface.ItemClickListener;
import com.example.project_chow.R;

public class ChefViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView chef_name;
    public ImageView chef_image;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public ChefViewHolder(@NonNull View itemView) {
        super(itemView);

        chef_name = (TextView)itemView.findViewById(R.id.chef_name);
        chef_image = (ImageView)itemView.findViewById(R.id.chef_image);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(), false);
    }
}
