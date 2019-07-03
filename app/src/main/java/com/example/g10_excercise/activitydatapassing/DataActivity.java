package com.example.g10_excercise.activitydatapassing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.g10_excercise.R;
public class DataActivity extends AppCompatActivity {
    EditText name;
    Button button;
    TextView text;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_data_layout);
        name=(EditText)findViewById(R.id.edittext);
        button=(Button)findViewById(R.id.passbutton);
        text = (TextView)findViewById(R.id.textView3);
        button.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View view){
                String str=name.getText().toString();
                if(str.isEmpty()) {
                    name.setError("This field can not be empty");
                }
            else {
                    Intent intent = new Intent(getApplicationContext(), DataPassedActivity.class);
                    intent.putExtra("message", str);
                    startActivityForResult(intent, 0);
                }
        }
    });
}
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && resultCode == RESULT_OK){
            String str1  = data.getStringExtra("message");
            text.setText(str1);
        }
    }
}
