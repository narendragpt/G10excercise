package com.example.g10_excercise.activitygridlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.g10_excercise.R;
public class GridActivity extends AppCompatActivity {
    public final static String[] Imageurl = {
            "https://images.pexels.com/photos/67636/rose-blue-flower-rose-blooms-67636.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/34950/pexels-photo.jpg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://i.pinimg.com/originals/5a/e5/8f/5ae58f5036997cfd4636917403c3c951.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTv73N30PMip5sGzboasjF0F4WdTqjvupfP_Uiv8KTLNFC3XG1E",
           "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSkpsJ1BBquBgmlDfhk6ZAzHLC-1JBZv5wGguUhL59arbW5Qp1LWg",
            "https://media.istockphoto.com/photos/hands-forming-a-heart-shape-with-sunset-silhouette-picture-id636379014?k=6&m=636379014&s=612x612&w=0&h=tnYrf_O_nvT15N4mmjorIRvZ7lK4w1q1c7RSfrVmqKA=",
            "https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzhnYvffH6b9n4JUIUQBbXJOqrhIYWe0fyOGCyynzAaz2uxdoIbA",
            "https://www.gettyimages.com/gi-resources/images/500px/983794168.jpg","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTv73N30PMip5sGzboasjF0F4WdTqjvupfP_Uiv8KTLNFC3XG1E",
            "https://images.pexels.com/photos/67636/rose-blue-flower-rose-blooms-67636.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/34950/pexels-photo.jpg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://media.istockphoto.com/photos/hands-forming-a-heart-shape-with-sunset-silhouette-picture-id636379014?k=6&m=636379014&s=612x612&w=0&h=tnYrf_O_nvT15N4mmjorIRvZ7lK4w1q1c7RSfrVmqKA=",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_list);
        GridView simplegrid = findViewById(R.id.gridview);
        simplegrid.setAdapter(new GridList(getApplicationContext(),Imageurl));
        simplegrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity
                Intent intent = new Intent(GridActivity.this, GridSecondActivity.class);
                intent.putExtra("image", Imageurl[position]); // put image data in Intent
                startActivity(intent); // start Intent
            }
        });
    }
}
