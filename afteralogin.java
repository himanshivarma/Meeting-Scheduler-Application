package com.example.homepage;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import androidx.navigation.ui.AppBarConfiguration;

public class afteralogin extends AppCompatActivity {


    Button b6,b7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afteralogin);
        b6=findViewById(R.id.button6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(afteralogin.this, meetingsc.class);
                startActivity(i);
            }
        });
        b7=findViewById(R.id.button7);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(afteralogin.this, meetinginfo.class);
                startActivity(i1);
            }
        });
    }


}