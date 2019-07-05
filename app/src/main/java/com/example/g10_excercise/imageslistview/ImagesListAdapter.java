package com.example.g10_excercise.imageslistview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.g10_excercise.R;

import java.util.List;

public class ImagesListAdapter extends RecyclerView.Adapter<ImagesViewHolder> {
    private List<ImagesModel> imagesList;
    public ImagesListAdapter(List<ImagesModel> imagesList) {this.imagesList=imagesList;
    }
    @NonNull
    @Override
    public ImagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.layout_logo_images, parent, false);
        ImagesViewHolder viewHolder = new ImagesViewHolder(listItem);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ImagesViewHolder holder, int position) {
        ImagesModel item = imagesList.get(position);
        holder.itemView.setTag(item);
                Glide.with(holder.listimage)
                .load(item.getImagesUrl())
                .into(holder.listimage);
    }
    @Override
    public int getItemCount() {
        return imagesList.size();
    }
}
