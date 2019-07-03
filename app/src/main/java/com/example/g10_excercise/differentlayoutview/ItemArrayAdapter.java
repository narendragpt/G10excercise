package com.example.g10_excercise.differentlayoutview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.g10_excercise.R;

import java.util.ArrayList;

public class ItemArrayAdapter extends RecyclerView.Adapter <RecyclerView.ViewHolder>{
    private static final int TYPE_ONE = 1;
    private static final int TYPE_TWO = 2;
    private static final int TYPE_THREE = 3;

    public  ArrayList<LayoutModel> itemList;
    // Constructor of the class
    public ItemArrayAdapter(ArrayList<LayoutModel> itemList) {
        this.itemList = itemList;
    }
    // get the size of the list
    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }
    // determine which layout to use for the row
    @Override
    public int getItemViewType(int position) {
        LayoutModel item = itemList.get(position);
        if (item.getType() == LayoutModel.ItemType.ONE_ITEM) {
            return TYPE_ONE;
        } else if (item.getType() == LayoutModel.ItemType.TWO_ITEM) {
            return TYPE_TWO;
        } else if(item.getType()==LayoutModel.ItemType.THREE_ITEM){
            return TYPE_THREE;
        }
        else {
            return -1;
        }
    }
    // specify the row layout file and click for each row
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ONE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_type1, parent, false);
            return new ViewHolderOne(view);
        } else if (viewType == TYPE_TWO) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_type2, parent, false);
            return new ViewHolderTwo(view);
        } else if(viewType == TYPE_THREE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exam_card, parent, false);
            return new ViewHolderThree(view);
        }
        else{
            throw new RuntimeException("The type has to be ONE or TWO");
        }
    }

    // load data in each row element
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int listPosition) {
        switch (holder.getItemViewType()) {
            case TYPE_ONE:
                initLayoutOne((ViewHolderOne)holder, listPosition);
                break;
            case TYPE_TWO:
                initLayoutTwo((ViewHolderTwo) holder, listPosition);
                break;
            case TYPE_THREE:
                initLayoutThree((ViewHolderThree) holder,listPosition);
            default:
                break;
        }
    }
    private void initLayoutOne(ViewHolderOne holder, int pos) {
        holder.item.setText(itemList.get(pos).getName());
    }
    private void initLayoutTwo(ViewHolderTwo holder, int pos) {
        holder.tvLeft.setText(itemList.get(pos).getName());
        holder.tvRight.setText(itemList.get(pos).getName());
        //holder.tvimages.setImageResource(itemList.get(pos).getIcon());
    }
private  void initLayoutThree(ViewHolderThree holder ,int pos) {
    holder.item1.setText(itemList.get(pos).getName());
    holder.item3.setText(itemList.get(pos).getName());
    holder.item5.setText(itemList.get(pos).getName());
    holder.item2.setImageResource(itemList.get(pos).getIcon());
    //holder.item4.setImageResource(itemList.get(pos).getIcon());
}
    // Static inner class to initialize the views of rows
    static class ViewHolderOne extends RecyclerView.ViewHolder {
        public TextView item;
        public ViewHolderOne(View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.textView);
        }
    }
    static class ViewHolderThree extends RecyclerView.ViewHolder{
        public TextView item1,item3,item5;
        public ImageView item2,item4;
        public ViewHolderThree(View itemView){
            super(itemView);
            item1 = itemView.findViewById(R.id.examName);
            item2 = itemView.findViewById(R.id.examPic);
            item3 = itemView.findViewById(R.id.examDate);
            item4 = itemView.findViewById(R.id.examPic2);
            item5 = itemView.findViewById(R.id.examMessage);
        }
    }
    static class ViewHolderTwo extends RecyclerView.ViewHolder {
        public TextView tvLeft, tvRight;
        public ImageView tvimages;
        public ViewHolderTwo(View itemView) {
            super(itemView);
            tvLeft = itemView.findViewById(R.id.row_item_left);
            tvRight = itemView.findViewById(R.id.row_item_right);
            tvimages = itemView.findViewById(R.id.imageView);
        }
    }
}

