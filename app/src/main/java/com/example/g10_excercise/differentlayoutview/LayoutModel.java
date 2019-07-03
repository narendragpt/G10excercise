package com.example.g10_excercise.differentlayoutview;

import com.example.g10_excercise.R;

public class LayoutModel {

    public int getIcon() {
        return R.drawable.ic_test;
    }

    public  enum ItemType{
        ONE_ITEM,TWO_ITEM,THREE_ITEM;
    }
    private String name;
    private ItemType type;

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public LayoutModel(String name, ItemType type) {
        this.name = name;
        this.type = type;
    }
}
