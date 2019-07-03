package com.example.g10_excercise;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ExerciseViewHolder extends RecyclerView.ViewHolder {

    public final TextView exerciseName;
    public ExerciseViewHolder(@NonNull View itemView) {
        super(itemView);
        exerciseName = itemView.findViewById(R.id.exerciseName);
    }
}
