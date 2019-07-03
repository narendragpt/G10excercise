package com.example.g10_excercise.imagepassing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.g10_excercise.R;

public class ImagePassed extends AppCompatActivity {
    ImageView passimages;
    ImageView PassImages;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images_passed);
        btn2 = (Button) findViewById(R.id.button6);
        passimages=(ImageView)findViewById(R.id.imageView3);
        PassImages = (ImageView)findViewById(R.id.imageView5);
        Bundle intent = getIntent().getExtras();
        if(intent!=null) {
            int resid= intent.getInt("resid");
            int resid1= intent.getInt("resid1");
            passimages.setImageResource(resid);
            PassImages.setImageResource(resid1);
        }
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ImageActivity.class);
                intent.putExtra("message",R.drawable.ic_launcher_background);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
