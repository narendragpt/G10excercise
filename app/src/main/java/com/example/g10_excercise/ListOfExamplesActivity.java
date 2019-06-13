package com.example.g10_excercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.g10_excercise.fragmentexample.FragmentExampleActivity;
import com.example.g10_excercise.xmlfragments.XmlFragmentActivity;

import java.util.ArrayList;
import java.util.List;

public class ListOfExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_examples);
        RecyclerView list = findViewById(R.id.recyclerView);
        List<ExerciseModel> exerciseList = new ArrayList<>();
        exerciseList.add(new ExerciseModel(1, "XML Fragment Examples"));
        exerciseList.add(new ExerciseModel(2, "Fragment Examples"));
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(new ExerciseRecyclerList(exerciseList, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExerciseModel exerciseModel = ((ExerciseModel) view.getTag());
                Toast.makeText(view.getContext(), exerciseModel.getExerciseName(), Toast.LENGTH_LONG).show();
                switch (exerciseModel.getId()){
                    case 1:{
                        Intent intent = new Intent(view.getContext(), XmlFragmentActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 2:{
                        Intent intent = new Intent(view.getContext(), FragmentExampleActivity.class);
                        startActivity(intent);
                        break;
                    }
                }
            }
        }));

    }
}
