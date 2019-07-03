package com.example.g10_excercise.activitygridlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.g10_excercise.R;
public class GridList extends BaseAdapter {
    private  Context context;
    final String[] Imagesurl;
    LayoutInflater inflater;
    public GridList(Context applicationContext, String[] Imagesurl) {
        this.context = applicationContext;
        this.Imagesurl = Imagesurl;
        inflater = LayoutInflater.from(applicationContext);
    }

    @Override
    public int getCount() {
        int count = Imagesurl.length;
        return count;
    }
    @Override
    public Object getItem(int position) {
        return Imagesurl[position];
    }
    public long getItemId(int i) {
        return i ;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (null==view ) {
            view = inflater.inflate(R.layout.layout_logo_images, null);
        }    // inflate the layout
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        Glide.with(context)
                .load(getItem(i))
                .into(icon);

    return view;}
}