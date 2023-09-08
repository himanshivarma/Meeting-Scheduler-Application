package com.example.homepage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.homepage.databinding.ActivityUserloginBinding;

public class userlogin extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityUserloginBinding binding;
    Button b5,b9;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);
        b5=findViewById(R.id.button8);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText un=(EditText) findViewById(R.id.editTextText);
                String uname=new String(un.getText().toString());
                EditText ps=(EditText)findViewById(R.id.editTextTextPassword);
                String pass= new String(ps.getText().toString());
                String s1="user1";
                String s2="password1";
                String s3="user2";
                String s4="password2";
                String s5="user3";
                String s6="password3";
                String s7="user4";
                String s8="password4";
                String s9="user5";
                String s10="password5";
                if ((uname.equals(s1) && pass.equals(s2))||(uname.equals(s3) && pass.equals(s4))||(uname.equals(s5) && pass.equals(s6))||(uname.equals(s7) && pass.equals(s8))||(uname.equals(s9) && pass.equals(s10))) {

                    Toast.makeText(userlogin.this,"Login succesfull",Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(userlogin.this,meetinginfo.class);
                    startActivity(i);
                }
                else
                {
                    un.setText("");
                    ps.setText("");
                    Toast.makeText(userlogin.this,"wrong details",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_userlogin);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}