package com.example.g10_excercise.differentlayoutview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.g10_excercise.R;
import java.util.ArrayList;
public class LayoutActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_recycle_view);
        // Initializing list view with the custom adapter
        RecyclerView list =  findViewById(R.id.recyclerView);
        ArrayList<LayoutModel> itemList = new ArrayList<>();
        // Populating list items
        for(int i=1; i<=21; i++) {
            if (i%3 == 1) {
                itemList.add(new LayoutModel("Item " + i, LayoutModel.ItemType.ONE_ITEM));
            } else if(i%3== 2) {
                itemList.add(new LayoutModel("Item " + i, LayoutModel.ItemType.TWO_ITEM));
            } else {
                itemList.add(new LayoutModel("Item " + i, LayoutModel.ItemType.THREE_ITEM));
            }
        }
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(new ItemArrayAdapter( itemList));
    }
}
