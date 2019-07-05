package com.example.g10_excercise.imagepassing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.g10_excercise.R;
import com.example.g10_excercise.activitygridlist.GridActivity;

public class ImageActivity  extends AppCompatActivity {
    ImageView images, Images, narendra ,narendra1;
    Button button1;
private  final  String string = "https://www.gettyimages.com/gi-resources/images/500px/983794168.jpg";
final  String string2 ="https://images.pexels.com/photos/67636/rose-blue-flower-rose-blooms-67636.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500";
String str3,str4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
        images = (ImageView) findViewById(R.id.imageView2);
        Images = (ImageView) findViewById(R.id.imageView4);
        narendra = (ImageView) findViewById(R.id.imageView7);
        narendra1 = (ImageView) findViewById(R.id.imageView6);
        button1 = (Button) findViewById(R.id.button5);
        for (String str : GridActivity.Imageurl) {
        Glide.with(this)
                .load(str)
                .into(Images);}
        Glide.with(this)
                .load(string2)
                .into(images);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ImagePassed.class);
                intent.putExtra("resid", string2);
                intent.putExtra("resid1",string);
                //intent.putExtra("resid1", R.drawable.ic_launcher_background);
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
                    str3 = data.getStringExtra("message");
                    str4 = data.getStringExtra("message1");

                    Glide.with(this)
                            .load(str3)
                            .into(narendra);
                    Glide.with(this)
                            .load(str4)
                            .into(narendra1);
                    //int resid = data.getExtras().getInt("message");
                    //narendra.setImageResource(resid);

                }
            }

    }