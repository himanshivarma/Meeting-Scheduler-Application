package com.example.homepage;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class deletingmeeting extends AppCompatActivity {

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletingmeeting);

    b1=findViewById(R.id.button9);
    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText e=findViewById(R.id.editTextText6);
            String id=e.getText().toString();
            Addingmeetingsc sc=new Addingmeetingsc(deletingmeeting.this);
            int x=sc.del(id);
            if(x==0)
            {
                Toast.makeText(deletingmeeting.this,"Meeting deleted",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(deletingmeeting.this,meetinginfo.class);
                startActivity(i);

            }
            else{
                Toast.makeText(deletingmeeting.this,"Deletion failed, verify again!!",Toast.LENGTH_SHORT).show();
            }
        }
    });

    }


}