package com.example.homepage;

import static com.example.homepage.R.id.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class userlist extends AppCompatActivity {
    RecyclerView recyclerView;
    Button b;

    ArrayList<String> id,date,time,agenda;
    Addingmeetingsc DB;
    CourseRVAdapter adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);
        DB=new Addingmeetingsc(this);
        id=new ArrayList<>();
        date=new ArrayList<>();
        time=new ArrayList<>();
        agenda=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview);
        adapter=new CourseRVAdapter(this,id,date,time,agenda);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        display();
    }




    private void display() {
        meetinginfo meet=new meetinginfo();
       Bundle bundle=getIntent().getExtras();
       String date1= bundle.getString("date");
        Cursor cursor=DB.getData(date1);
        if(cursor.getCount()==0)
        {
            Toast.makeText(userlist.this,"No Entry Exists",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while(cursor.moveToNext())
            {
                id.add(cursor.getString(0));
                date.add(cursor.getString(1));
                time.add(cursor.getString(2));
                agenda.add(cursor.getString(3));
            }
        }
    }
}