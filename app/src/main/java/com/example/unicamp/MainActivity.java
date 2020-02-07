package com.example.unicamp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unicamp.Fragments.fragment_etkinlikler;
import com.example.unicamp.Fragments.fragment_intern;
import com.example.unicamp.Fragments.fragment_notlar;
import com.example.unicamp.Fragments.fragment_ogrenci;
import com.gauravk.bubblenavigation.BubbleNavigationConstraintView;
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener;

public class MainActivity extends AppCompatActivity {


    Button staj, etki, ognoz, not, konferans;
    BubbleNavigationConstraintView bubbleNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        staj = findViewById(R.id.stajbutton);
        etki = findViewById(R.id.etkbutton);
        ognoz = findViewById(R.id.ogrgozubutton);
        not = findViewById(R.id.notbutton);
        konferans = findViewById(R.id.konferansButton);


        staj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(0);
            }
        });

        etki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(2);

            }
        });


        konferans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(2);
            }
        });

        ognoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openOg();
            }
        });

        not.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(4);
            }
        });

        bubbleNavigation = findViewById(R.id.top_navigation_constraint);

        bubbleNavigation.setNavigationChangeListener(new BubbleNavigationChangeListener() {
            @Override
            public void onNavigationChanged(View view, int position) {
                //navigation changed, do something
                openFragment(position);
            }
        });

    }

    void openFragment(int position) {

        staj.setVisibility(View.INVISIBLE);
        not.setVisibility(View.INVISIBLE);
        etki.setVisibility(View.INVISIBLE);
        ognoz.setVisibility(View.INVISIBLE);
        konferans.setVisibility(View.INVISIBLE);
        Fragment selected = null;

        if(position!=3){
            switch (position) {

                case 0:
                    Log.e("Tag", "0 Düştü");
                    selected = new fragment_intern();
                    break;
                case 1:
                    Log.e("Tag", "1 Düştü");
                    selected = new fragment_etkinlikler();
                    break;
                case 2:
                    Log.e("Tag", "2 Düştü");
                    selected = new fragment_etkinlikler();
                    break;
                case 4:
                    Log.e("Tag", "3 Düştü");
                    selected = new fragment_notlar();
                    break;
                default:
                    Log.e("Tag", "Default");
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, selected).commit();
        }
        else {
            openOg();
        }

    }

    void openOg(){
        Intent intent = new Intent(MainActivity.this, CompareTwoUni.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
         super.onBackPressed();
    }
}
