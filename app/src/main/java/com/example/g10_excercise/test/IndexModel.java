package com.example.g10_excercise.test;

public class IndexModel {
    private final int index;
    private final String modelname;
    private final int type;

    public IndexModel(int index, String modelname, int type) {
        this.modelname=modelname;
        this.index = index;
        this.type = type;
    }
    public    int getIndex() {
        return index;
    }

    public String getModelname() {
        return modelname;
    }

    public int getType() { return type; }
}
