package com.example.unicamp.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.unicamp.R;

public class fragment_for_detail extends Fragment {

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fragment_for_detail, container, false);
        ImageView back=view.findViewById(R.id.backarrow);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment destination=new fragment_intern();
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_layout,destination)
                        .commit();


            }
        });


        return view;
    }






}
