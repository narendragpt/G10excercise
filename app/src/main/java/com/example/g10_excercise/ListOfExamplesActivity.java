package com.example.g10_excercise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.g10_excercise.activitydatapassing.DataActivity;
import com.example.g10_excercise.activitygridlist.GridActivity;
import com.example.g10_excercise.differentlayoutview.LayoutActivity;
import com.example.g10_excercise.emailexample.MainActivity;
import com.example.g10_excercise.endlessactivityexample.AnimationExample;
import com.example.g10_excercise.fragmentexample.FragmentExampleActivity;
import com.example.g10_excercise.imageslistview.ImagesListActivity;
import com.example.g10_excercise.studentexamlist.examActivity;
import com.example.g10_excercise.test.IndexListActivity;
import com.example.g10_excercise.userprofile.UserProfileActivity;

import java.util.ArrayList;
import java.util.List;

public class ListOfExamplesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_examples);
        RecyclerView list = findViewById(R.id.recyclerView);
        List<ExerciseModel> exerciseList = new ArrayList<>();
        for(int n=1, i=1 ; i<=n; i++) {
            exerciseList.add(new ExerciseModel(1, "Images Recycler View"));
            exerciseList.add(new ExerciseModel(2, "Fragment Examples"));
            exerciseList.add(new ExerciseModel(3, "Examlist Example"));
            exerciseList.add(new ExerciseModel(4, "Endless Recycler View"));
            exerciseList.add(new ExerciseModel(5, "Index Example"));
            exerciseList.add(new ExerciseModel(6, "Different Layout Activity"));
            exerciseList.add(new ExerciseModel(7, "Activity Data Passing "));
            exerciseList.add(new ExerciseModel(8, "User Profile"));
            exerciseList.add(new ExerciseModel(9, "Activity Grid Example "));
            exerciseList.add(new ExerciseModel(10, "Email passing example "));
        }
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(new ExerciseRecyclerList(exerciseList,  new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExerciseModel exerciseModel = ((ExerciseModel) view.getTag());
                Toast.makeText(view.getContext(), exerciseModel.getExerciseName(), Toast.LENGTH_LONG).show();
                switch (exerciseModel.getId()){
                    case 1:{
                            Intent intent = new Intent(view.getContext(), ImagesListActivity.class);
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
                    case 4:{
                        Intent intent = new Intent(view.getContext(), AnimationExample.class);
                        startActivity(intent);
                        break; }
                    case 5:{
                        Intent intent = new Intent(view.getContext(), IndexListActivity.class);
                        startActivity(intent);
                        break; }
                    case 10:{
                        Intent intent = new Intent(view.getContext(), MainActivity.class);
                        startActivity(intent);
                        break; }
                    case 6:{
                        Intent intent = new Intent(view.getContext(), LayoutActivity.class);
                        startActivity(intent);
                        break; }
                    case 7:{
                        Intent intent = new Intent(view.getContext(), DataActivity.class);
                        startActivity(intent);
                        break; }
                    case 8:{
                        Intent intent = new Intent(view.getContext(), UserProfileActivity.class);
                        startActivity(intent);
                        break; }
                    case 9:{
                        Intent intent = new Intent(view.getContext(), GridActivity.class);
                        startActivity(intent);
                        break; }
                }

            }
        }));

    }
}
