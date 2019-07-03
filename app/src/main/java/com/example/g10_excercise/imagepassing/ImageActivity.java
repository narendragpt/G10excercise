package com.example.g10_excercise.imagepassing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.g10_excercise.R;

public class ImageActivity  extends AppCompatActivity {
    ImageView images, Images, narendra;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
        images = (ImageView) findViewById(R.id.imageView2);
        Images = (ImageView) findViewById(R.id.imageView4);
        narendra = (ImageView) findViewById(R.id.imageView6);
        button1 = (Button) findViewById(R.id.button5);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ImagePassed.class);
                intent.putExtra("resid", R.drawable.ic_test);
                intent.putExtra("resid1", R.drawable.ic_launcher_background);
                startActivityForResult(intent, 1);
            }
        });
    }
        @Override
        protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode, resultCode,data);
            if (requestCode == 1 && resultCode == RESULT_OK) ;
                //Bundle data = getIntent().getExtras();
                if (data!= null) {
                    int resid = data.getExtras().getInt("message");
                    narendra.setImageResource(resid);

                }
            }

    }