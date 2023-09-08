package com.example.homepage;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.homepage.databinding.ActivityMeetingscBinding;

import java.text.BreakIterator;
import java.util.Calendar;

public class meetingsc extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMeetingscBinding binding;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetingsc);
        final String[] sl = {" "};
        Addingmeetingsc dbhandler;
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ImageView calendarImageView = findViewById(R.id.imageView3);
        ImageView clock=findViewById(R.id.imageView);
        calendarImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get current date
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                // Create DatePickerDialog and show it
                DatePickerDialog datePickerDialog = new DatePickerDialog(meetingsc.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                // Handle the selected date
                                // This callback method will be called when a date is selected in the dialog
                                // You can perform any action you want with the selected date
                                EditText e1 = findViewById(R.id.ed);
                                String selectedDate = String.format("%02d/%02d/%04d", dayOfMonth, monthOfYear + 1, year);
                                e1.setText(selectedDate);
                                sl[0] =selectedDate;
                            }
                        }, year, month, dayOfMonth);

                datePickerDialog.show();
            }

        });
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }

            private void showTimePickerDialog() {
                // Get the current time
                Calendar currentTime = Calendar.getInstance();
                int hour = currentTime.get(Calendar.HOUR_OF_DAY);
                int minute = currentTime.get(Calendar.MINUTE);

                // Create a TimePickerDialog and set the current time as the default
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        meetingsc.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                // Handle the selected time (e.g., display it in a TextView)
                                EditText ee=findViewById(R.id.editTextTime);
                                String selectedTime = hourOfDay + ":" + minute;
                                ee.setText(selectedTime);
                                // TODO: Do something with the selected time
                            }
                        },
                        hour,
                        minute,
                        false
                );

                // Show the TimePickerDialog
                timePickerDialog.show();
            }

        });
    Button add=findViewById(R.id.button);
    add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText meetingid=findViewById(R.id.editTextText5);
            String id=meetingid.getText().toString();
            int mid=Integer.parseInt(id);
            EditText editTexttime=findViewById(R.id.editTextTime);
            String ett=editTexttime.getText().toString();
            EditText editTexttext3=findViewById(R.id.editTextText3);
            String ett3=editTexttext3.getText().toString();
            EditText ed=findViewById(R.id.ed);
            
            //need to write the function to insert the meeting schedule;
            Addingmeetingsc sc=new Addingmeetingsc(meetingsc.this);
            boolean bool= sc.add(mid,sl,ett,ett3);
            if(id==" " || sl[0]==" " || ett==" " || ett3==" ")
            {
                Toast.makeText(meetingsc.this,"Please fill the all the fields",Toast.LENGTH_SHORT).show();
            }
            else if(bool)
            {
                Toast.makeText(meetingsc.this,"Meeting schelude inserted succefully",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(meetingsc.this, afteralogin.class);
                startActivity(i);
            }
            else
            {
                meetingid.setText("");
                editTexttime.setText("");
                editTexttext3.setText("");
                ed.setText("");
                Toast.makeText(meetingsc.this,"Meeting insertion failed Re-check the details again",Toast.LENGTH_SHORT).show();

            }
        }
    });

    }



}