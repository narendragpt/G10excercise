package com.example.g10_excercise.activitydatapassing;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.g10_excercise.R;

public class DataPassedActivity extends AppCompatActivity {
    TextView text1;
    Button button1;
    String str;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passed_data_layout);
        text1=(TextView)findViewById(R.id.textView2);
        button1=(Button)findViewById(R.id.button);
        Intent intent = getIntent();
        str  = intent.getStringExtra("message");
        text1.setText(str);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DataActivity.class);
                intent.putExtra("message",str);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

}
