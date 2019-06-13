package com.example.g10_excercise.fragmentexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import com.example.g10_excercise.R;

public class FragmentOne extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, viewGroup, false);
        TextView output= (TextView)view.findViewById(R.id.msg1);
        output.setText("Fragment One");
        return view;
    }
}