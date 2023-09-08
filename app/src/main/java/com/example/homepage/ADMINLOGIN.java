package com.example.homepage;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.homepage.databinding.ActivityAdminloginBinding;

import java.util.Objects;

public class ADMINLOGIN extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityAdminloginBinding binding;
    Button b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        b3=findViewById(R.id.button8);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText un=(EditText) findViewById(R.id.editTextText);
                String uname=new String(un.getText().toString());
                EditText ps=(EditText)findViewById(R.id.editTextTextPassword);
                String pass= new String(ps.getText().toString());
                String s1="admin";
                String s2="admin123";

                if (uname.equals(s1) && pass.equals(s2)) {

                    Toast.makeText(ADMINLOGIN.this,"Login successfull",Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(ADMINLOGIN.this, afteralogin.class);
                    startActivity(i);
                }
                else
                {
                    un.setText("");
                    ps.setText("");
                    Toast.makeText(ADMINLOGIN.this,"wrong details",Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}