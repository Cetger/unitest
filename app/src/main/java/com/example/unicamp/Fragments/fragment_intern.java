package com.example.unicamp.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unicamp.Adapters.internAdapter;
import com.example.unicamp.Model.intern;
import com.example.unicamp.R;

import java.util.ArrayList;


public class fragment_intern extends Fragment {


    ListView internlist;
    final ArrayList<intern> interns=new ArrayList<intern>();
    Bundle bundle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fragment_intern, container, false);
         bundle = new Bundle();
        internlist=view.findViewById(R.id.listviewintern);

        interns.add(new intern("Tarih Öğretmeni","Kadro Dershanesi","30.01.2020","Ankara"));
        interns.add(new intern("Yönetici Asistanı","Dedebali Turizm","28.01.2020","İstanbul"));
        interns.add(new intern("Bilgisayar Mühendisi","Cetger Bilişim","23.01.2020","İstanbul"));
        interns.add(new intern("Muhasebeci","Faruk Hukuk Bürosu","20.01.2020","Kayseri"));
        interns.add(new intern("İnşaat Mühendisi","Yusuf İnşaat","19.01.2020","Yozgat"));
        interns.add(new intern("İletişim Uzmanı","Anka Medya","17.01.2020","İstanbul"));

        internAdapter internAdapter=new internAdapter(getActivity(),interns);
        if(internlist!=null){
            internlist.setAdapter(internAdapter);
        }

        internlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openNewFragment(position);
            }
        });


        return view;
    }


    void openNewFragment(int position){

        bundle.putString("mypositionkey","123");
        Fragment destination=new fragment_for_detail();
        destination.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_layout,destination)
                .commit();



    }
}
