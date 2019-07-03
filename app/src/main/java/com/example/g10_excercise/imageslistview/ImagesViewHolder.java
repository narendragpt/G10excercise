package com.example.g10_excercise.imageslistview;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.g10_excercise.R;

public class ImagesViewHolder extends RecyclerView.ViewHolder {
    public  final ImageView listimage;

    public ImagesViewHolder(@NonNull View itemView) {
        super(itemView);
        listimage= itemView.findViewById(R.id.icon);
    }
}
