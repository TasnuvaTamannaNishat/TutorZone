package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView enote_title_text_view,esubject,elocation,efee,econtact,eothers,enote_timestamp_text_view;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        enote_title_text_view=itemView.findViewById(R.id.note_title_text_view);

        esubject= itemView.findViewById(R.id.subject);
        elocation= itemView.findViewById(R.id.location);
        efee= itemView.findViewById(R.id.fee);
        econtact= itemView.findViewById(R.id.contact);
        eothers= itemView.findViewById(R.id.others);
        enote_timestamp_text_view= itemView.findViewById(R.id.note_timestamp_text_view);
    }
}
