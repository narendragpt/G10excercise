package com.example.g10_excercise.imagepassing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.g10_excercise.R;

public class ImagePassed extends AppCompatActivity {
    ImageView passimages;
    ImageView PassImages;
    String str2,str1;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images_passed);
        btn2 = (Button) findViewById(R.id.button6);
        passimages=(ImageView)findViewById(R.id.imageView3);
        PassImages = (ImageView)findViewById(R.id.imageView5);
        str2 = getIntent().getStringExtra("resid1");
        Glide.with(this).load(str2)
                .into(passimages);
        str1 =getIntent().getStringExtra("resid");
        Glide.with(this).load(str1)
                .into(PassImages);

        /*Bundle intent = getIntent().getExtras();
        if(intent!=null) {
            int resid= intent.getInt("resid");
            int resid1= intent.getInt("resid1");
            passimages.setImageResource(resid);
            PassImages.setImageResource(resid1);
        }*/
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ImageActivity.class);
                intent.putExtra("message",str1);
                intent.putExtra("message1",str2);
                //intent.putExtra("message",R.drawable.ic_launcher_background);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
