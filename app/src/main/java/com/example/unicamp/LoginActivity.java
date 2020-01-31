package com.example.unicamp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    TextView loginButton;
    TextView registerButton;

    EditText editTextMail;
    EditText editTextPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        loginButton=findViewById(R.id.girisYap);
        registerButton=findViewById(R.id.hesapOlustur);
        editTextMail=findViewById(R.id.username);
        editTextPass=findViewById(R.id.password);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginFunction();
            }
        });


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerFunction();
            }
        });


    }

    void loginFunction(){
       String username= editTextMail.getText().toString();
       String pass=editTextPass.getText().toString();

       if(username.equals("admin")&&pass.equals("123")){
           Toast.makeText(this, "Hoşgeldiniz", Toast.LENGTH_SHORT).show();
           Intent intent = new Intent(getBaseContext(), MainActivity.class);
           intent.putExtra("username", username);
           startActivity(intent);

       }
       else Toast.makeText(this, "Başarısız", Toast.LENGTH_SHORT).show();
    }

    void registerFunction(){

        Intent intent = new Intent(getBaseContext(), RegisterActivity.class);
        startActivity(intent);
    }
}
