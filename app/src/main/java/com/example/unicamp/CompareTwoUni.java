package com.example.unicamp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class CompareTwoUni extends AppCompatActivity {

    ImageView back;
    TextView linkendinLeft,linkendinRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_compare_two_uni);

        back=findViewById(R.id.comparebackbutton);

        linkendinLeft=findViewById(R.id.linkendinLeft);
        linkendinRight=findViewById(R.id.linkendinRight);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompareTwoUni.this, MainActivity.class);
                startActivity(intent);
            }
        });

        linkendinLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/school/bilkent-university/people/"));
                startActivity(browserIntent);
            }
        });

        linkendinRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/school/ozyeginuniversitesi/people/"));
                startActivity(browserIntent);

            }
        });

    }
}
