package com.example.g10_excercise.restapiexample;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.g10_excercise.R;

import java.util.List;

public class RestListAdapter extends RecyclerView.Adapter<RestViewHolder> {
    private List<RestDataModel> imagesList;
    public RestListAdapter( List<RestDataModel> imagesList) {this.imagesList=imagesList;
    }
    @NonNull
    @Override
    public RestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.example_item, parent, false);
        RestViewHolder viewHolder = new RestViewHolder(listItem);
       return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RestViewHolder holder, int position) {
        RestDataModel item = imagesList.get(position);
        String imgaesUrl=item.getUriimage();
        String username =item.getFirstname();
        String useremail =item.getEmail();
        holder.itemView.setTag(item);
        holder.userName.setText(username);
       holder.userEmail.setText(useremail);
        Glide.with(holder.apiImages).load(imgaesUrl).into(holder.apiImages);
    }
    @Override
    public int getItemCount() {
        return imagesList.size();
    }
}
