package com.example.g10_excercise.fragmentexample;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.g10_excercise.R;

public class FragmentExampleActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_example);
        OnClickListener listener = new OnClickListener() {
            public void onClick(View view) {
                Fragment fragment = null;
                if(view == findViewById(R.id.button1)){
                    fragment = new FragmentOne();
                } else {
                    fragment = new FragmentTwo();
                }
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.output, fragment);
                transaction.commit();
            }
        };
        Button btn1 = (Button)findViewById(R.id.button1);
        btn1.setOnClickListener(listener);
        Button btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(listener);
    }
}

