package com.example.g10_excercise.studentexamlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.g10_excercise.R;

import java.util.List;

public class ImageGalleryAdapter2 extends RecyclerView.Adapter<examViewHolder> {
    private   List<examData> list;
    View.OnClickListener onClickListener;
    public ImageGalleryAdapter2(List<examData> list, View.OnClickListener onClickListener) {
        this.list = list;
        this.onClickListener = onClickListener;
    }
    @Override
    public examViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.exam_card, parent, false);
        examViewHolder viewHolder = new examViewHolder(listItem);
        listItem.setOnClickListener(onClickListener);
        return viewHolder;

    }
    @Override
    public void onBindViewHolder(final examViewHolder viewHolder, final int position) {

        viewHolder.examName.setText(list.get(position).name);
        viewHolder.examDate.setText(list.get(position).date);
        viewHolder.examMessage.setText(list.get(position).message);
        examData item = list.get(position);
        viewHolder.itemView.setTag(item);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    // Insert a new item to the RecyclerView on a predefined position


}

