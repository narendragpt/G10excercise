package com.example.g10_excercise.test;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.g10_excercise.R;

import java.util.List;

public class IndexRecyclerList extends RecyclerView.Adapter<IndexViewHolder> {

    private static final int SIMPLE_VIEW = 1;
    private static final int VIEW = 2;

    private final List<IndexModel> list;

    public IndexRecyclerList(List<IndexModel> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public IndexViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = null;
        if(viewType == SIMPLE_VIEW){
            listItem = layoutInflater.inflate(R.layout.item_index_simple_view, parent, false);
        }else {
            listItem = layoutInflater.inflate(R.layout.index_name, parent, false);
        }
        IndexViewHolder viewHolder = new IndexViewHolder(listItem);
        Log.d("ListLog", "onCreateViewHolder " + viewHolder);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull IndexViewHolder holder, int position) {
        Log.d("ListLog", "onBindViewHolder position = " + position);
        Log.d("ListLog", "onBindViewHolder viewHolder = " + holder);
        IndexModel item = list.get(position);
        holder.itemView.setTag(item);
        holder.modelname.setText(item.getModelname());
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
