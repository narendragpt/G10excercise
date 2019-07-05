package com.example.g10_excercise.restapiexample;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.g10_excercise.R;

public class RestViewHolder extends RecyclerView.ViewHolder {
    final ImageView apiImages;
    final TextView userName;
    final TextView userEmail;
    public RestViewHolder(@NonNull View itemView) {
        super(itemView);
        apiImages =itemView.findViewById(R.id.api);
        userName= (TextView)itemView.findViewById(R.id.username);
        userEmail = (TextView)itemView.findViewById(R.id.useremail);
    }
}
