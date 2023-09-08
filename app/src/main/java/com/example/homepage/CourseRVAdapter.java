package com.example.homepage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseRVAdapter extends RecyclerView.Adapter<CourseRVAdapter.MyViewHolder>{
   private Context context;

   private ArrayList  meeting_id,date,time,agenda;

    public CourseRVAdapter(Context context, ArrayList meeting_id, ArrayList date, ArrayList time, ArrayList agenda) {
        this.context = context;
        this.meeting_id = meeting_id;
        this.date = date;
        this.time = time;
        this.agenda = agenda;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       holder.meeting_id.setText(String.valueOf(meeting_id.get(position)));
        holder.date.setText(String.valueOf(date.get(position)));
        holder.time.setText(String.valueOf(time.get(position)));
        holder.agenda.setText(String.valueOf(agenda.get(position)));
    }

    @Override
    public int getItemCount() {
        return meeting_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
         TextView meeting_id,date,time,agenda;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            meeting_id=itemView.findViewById(R.id.textid);
            date=itemView.findViewById(R.id.textDate);
            time=itemView.findViewById(R.id.textTime);
            agenda=itemView.findViewById(R.id.textMeetingagenda);
        }
    }
}
