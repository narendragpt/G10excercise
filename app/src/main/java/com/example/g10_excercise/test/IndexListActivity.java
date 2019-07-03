package com.example.g10_excercise.test;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.g10_excercise.R;

import java.util.ArrayList;
import java.util.List;

public class IndexListActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        int n=100;
        setContentView(R.layout.index_recycle_view);
        RecyclerView list = findViewById(R.id.recyclerView);
        List<IndexModel> modellist = new ArrayList<>();
        for(int i=1;i<=n;i++){
            modellist.add(new IndexModel(1, String.format("Index %d", i), i % 2));
            //modellist.add("Item " + i);
        }
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(new IndexRecyclerList(modellist));
        //IndexModel.getIndex();
    }
}
