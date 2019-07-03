package com.example.g10_excercise.test;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.g10_excercise.R;

public class IndexViewHolder extends RecyclerView.ViewHolder {

    public final TextView modelname;

    public IndexViewHolder(@NonNull View itemView) {
        super(itemView);
        modelname =itemView.findViewById(R.id.modelname);
    }
}
