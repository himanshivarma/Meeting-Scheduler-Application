package com.example.homepage;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.homepage.databinding.ActivityMeetingscBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class meetinginfo extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMeetingscBinding binding;
    Button bb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_meetinginfo);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView calendarImageView = findViewById(R.id.imageView2);
        calendarImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get current date
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                // Create DatePickerDialog and show it
                DatePickerDialog datePickerDialog = new DatePickerDialog(meetinginfo.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                // Handle the selected date
                                // This callback method will be called when a date is selected in the dialog
                                // You can perform any action you want with the selected date
                                EditText e1=findViewById(R.id.et);
                                @SuppressLint("DefaultLocale") String selectedDate = String.format("%02d/%02d/%04d", dayOfMonth, monthOfYear + 1, year);
                                //need to call the function to search the details of the meetings..
                                e1.setText(selectedDate);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });
        Button b4=findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ed=findViewById(R.id.et);
                String date=new String(ed.getText().toString());
                Bundle bundle=new Bundle();
                bundle.putString("date",date);
            Intent i=  new Intent(meetinginfo.this,userlist.class);
            i.putExtras(bundle);
            startActivity(i);
            }
        });
    }
}