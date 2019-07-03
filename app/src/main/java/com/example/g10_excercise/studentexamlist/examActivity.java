package com.example.g10_excercise.studentexamlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.g10_excercise.R;
import com.example.g10_excercise.fragmentexample.FragmentExampleActivity;
import com.example.g10_excercise.test.IndexListActivity;

import java.util.ArrayList;
import java.util.List;

public class examActivity extends AppCompatActivity {
int n =1 ;
    boolean isLoading = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_exam_student);
        // setSupportActionBar(toolbar);
        RecyclerView list = findViewById(R.id.recyclerView);
        final List<examData> examList = new ArrayList<>();
        for(int i=0;i<n;i++){
        examList.add(new examData(1, "First Exam", "Dec 23, 2014", "Best of luck"));
            examList.add(new examData(2, "Second Exam", "May 23, 2015", "Best of luck"));
            examList.add(new examData(3, "Third Exam ", "Dec 24,2015", "Best of luck"));
            examList.add(new examData(4, "Fourth Exam", "May 30,2016", "Unsuccessfull"));}
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(new ImageGalleryAdapter2(examList, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                examData examdata = ((examData) view.getTag());
                Toast.makeText(view.getContext(), examdata.getName(), Toast.LENGTH_LONG).show();
                switch (examdata.getId()){
                    case 1:{
                        Intent intent = new Intent(view.getContext(), IndexListActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 2:{
                        Intent intent = new Intent(view.getContext(), FragmentExampleActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 3:{
                        Intent intent = new Intent(view.getContext(), examActivity.class);
                        startActivity(intent);
                        break;

                    }
                }
            }
        }));

    }
}