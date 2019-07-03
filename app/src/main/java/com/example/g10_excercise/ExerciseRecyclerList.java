package com.example.g10_excercise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExerciseRecyclerList extends RecyclerView.Adapter<ExerciseViewHolder> {
    private final List<ExerciseModel> list;
    final View.OnClickListener onClickListener;
    public ExerciseRecyclerList(List<ExerciseModel> list, View.OnClickListener onClickListener){
        this.list = list;
        this.onClickListener = onClickListener;
    }
    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_exercise, parent, false);
        ExerciseViewHolder viewHolder = new ExerciseViewHolder(listItem);
        listItem.setOnClickListener(onClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHolder holder, int position) {
        ExerciseModel item = list.get(position);
        holder.itemView.setTag(item);
        holder.exerciseName.setText(item.getExerciseName());
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
}
