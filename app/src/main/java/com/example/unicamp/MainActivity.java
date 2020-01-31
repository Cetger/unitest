package com.example.unicamp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

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


    Button staj,etki,ognoz,not;
    BubbleNavigationConstraintView bubbleNavigation;
    TextView hosgeldin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String usernameString = getIntent().getStringExtra("username");

        staj=findViewById(R.id.stajbutton);
        etki=findViewById(R.id.etkinlikbuton);
        ognoz=findViewById(R.id.button5);
        not=findViewById(R.id.button4);

        hosgeldin=findViewById(R.id.textView4);

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


        ognoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(3);
            }
        });

        not.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(1);
            }
        });

        bubbleNavigation=findViewById(R.id.top_navigation_constraint);

        bubbleNavigation.setNavigationChangeListener(new BubbleNavigationChangeListener() {
            @Override
            public void onNavigationChanged(View view, int position) {
                //navigation changed, do something
                openFragment(position);
            }
        });

    }

    void openFragment(int position){

        staj.setVisibility(View.INVISIBLE);
        not.setVisibility(View.INVISIBLE);
        etki.setVisibility(View.INVISIBLE);
        ognoz.setVisibility(View.INVISIBLE);
        hosgeldin.setVisibility(View.INVISIBLE);

        Fragment selected=null;
        switch (position){

            case 0:
                Log.e("Tag","0 Düştü");
                selected=new fragment_intern();
                break;
            case 1:
                Log.e("Tag","1 Düştü");
                selected=new fragment_notlar();
                break;
            case 2:
                Log.e("Tag","2 Düştü");
                selected=new fragment_etkinlikler();
                break;
            case 3:
                Log.e("Tag","3 Düştü");
                selected=new fragment_ogrenci();
                break;
            default:
                Log.e("Tag","Default");
                break;
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,selected).commit();
    }

    @Override
    public void onBackPressed() {
       // super.onBackPressed();
    }
}
