package com.example.g10_excercise.activitygridlist;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.g10_excercise.R;

public class GridSecondActivity extends AppCompatActivity {
    ImageView selectedImage;
    private  String imagesurl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_logo_images);
        selectedImage = (ImageView) findViewById(R.id.icon);
        imagesurl = getIntent().getStringExtra("image");
        Glide.with(this).load(imagesurl)
                .into(selectedImage);
    }
}
