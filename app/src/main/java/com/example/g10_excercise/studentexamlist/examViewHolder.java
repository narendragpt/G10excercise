package com.example.g10_excercise.studentexamlist;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.g10_excercise.R;

public class examViewHolder extends RecyclerView.ViewHolder {
    public final TextView examName;
    ProgressBar progressBar;
    public  final  TextView examMessage;
    public final TextView examDate;
   public examViewHolder (@NonNull View itemView) {
        super(itemView);
       progressBar = itemView.findViewById(R.id.progressBar);
        examName = (TextView)itemView.findViewById(R.id.examName);
        examDate = (TextView)itemView.findViewById(R.id.examDate);
        examMessage = (TextView)itemView.findViewById(R.id.examMessage);

    }
}
