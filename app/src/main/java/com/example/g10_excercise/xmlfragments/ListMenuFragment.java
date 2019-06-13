package com.example.g10_excercise.xmlfragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.g10_excercise.R;

/**
 * Created by tutlane on 06-08-2017.
 */
public class ListMenuFragment extends ListFragment {
    String[] users = new String[] { "Suresh","Rohini","Trishika","Praveen","Sateesh","Madhav" };
    String[] location = new String[]{"Hyderabad","Guntur","Hyderabad","Bangalore","Vizag","Nagpur"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_list_menu, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, users);
        setListAdapter(adapter);
        return view;
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        DetailsFragment txt = (DetailsFragment)getFragmentManager().findFragmentById(R.id.fragment2);
        txt.change("Name: "+ users[position],"Location : "+ location[position]);
        getListView().setSelector(android.R.color.holo_blue_dark);
    }
}