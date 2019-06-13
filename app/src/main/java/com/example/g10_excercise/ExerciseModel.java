package com.example.g10_excercise;

public class ExerciseModel {
    private final int id ;
    private final String exerciseName;

    public ExerciseModel(int id, String exerciseName) {
        this.id = id;
        this.exerciseName = exerciseName;
    }

    public int getId() {
        return id;
    }

    public String getExerciseName() {
        return exerciseName;
    }
}
