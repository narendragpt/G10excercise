package com.example.g10_excercise.userprofile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.g10_excercise.R;

import static android.net.Uri.parse;

public class UserProfileActivity extends AppCompatActivity {
    Button editbtn;
    TextView email, name,contact;
    ImageView imageView;
    private String ImageURL="https://www.freepngimg.com/thumb/cartoon/2-2-cartoon-png-picture.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.images_from_url);
        editbtn = (Button)findViewById(R.id.edit);
        email=(TextView)findViewById(R.id.email);
        imageView=findViewById(R.id.profile);
        name=(TextView)findViewById(R.id.name);
        contact=(TextView)findViewById(R.id.contact);
        new DownloadImageFromInternet(imageView).execute(ImageURL);
        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),EditUserProfile.class);
                String Email=email.getText().toString();
                String Name=name.getText().toString();
                String Contact=contact.getText().toString();
                UserProfileModel upm = new UserProfileModel(Email,Name,Contact, ImageURL);
                i.putExtra("User",upm);
                startActivityForResult(i, 0);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && resultCode == RESULT_OK && null != data){
            UserProfileModel upm1 = (UserProfileModel)data.getSerializableExtra("User");
            email.setText(upm1.getEmail());
            name.setText(upm1.getName());
            contact.setText(upm1.getContact());
            imageView.setImageURI(parse(upm1.getImageURL()));



        }
    }
}