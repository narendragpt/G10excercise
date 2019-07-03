package com.example.g10_excercise.imageslistview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.g10_excercise.R;
import com.example.g10_excercise.activitygridlist.GridActivity;

import java.util.ArrayList;
import java.util.List;

public class ImagesListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_recycle_view);
        RecyclerView list = findViewById(R.id.recyclerView);
        List<ImagesModel> imagesList = new ArrayList<>();
        for (String str : GridActivity.Imageurl) {
            imagesList.add(new ImagesModel(str));
        }
        list.setLayoutManager(new StaggeredGridLayoutManager(3, RecyclerView.VERTICAL));
        list.setAdapter(new ImagesListAdapter(imagesList));

    }

}
