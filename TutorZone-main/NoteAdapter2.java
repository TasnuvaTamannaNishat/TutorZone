package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import org.jetbrains.annotations.NotNull;

public class NoteAdapter2 extends FirestoreRecyclerAdapter<Note2, NoteAdapter2.NoteViewHolder>{

    Context context;
    String docId;

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public NoteAdapter2(@NonNull FirestoreRecyclerOptions<Note2> options,Context context) {
        super(options);
        this.context=context;
    }

    @Override
    protected void onBindViewHolder(@NonNull NoteAdapter2.NoteViewHolder holder, int position, @NonNull Note2 model) {
        holder.enote_title_text_view.setText(model.title2);
        holder.esubject.setText(model.subject2);
        holder.elocation.setText(model.contact2);
        holder.efee.setText(model.fee2);
        holder.econtact.setText(model.contact2);
        holder.eothers.setText(model.others2);
        //holder.enote_timestamp_text_view.setText(Utility.timestampToString(model.timestamp2));




    }

    @NonNull
    @Override
    public NoteAdapter2.NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_note_item2,parent,false);

        return new NoteAdapter2.NoteViewHolder(view);
    }




    class NoteViewHolder extends RecyclerView.ViewHolder{
        TextView enote_title_text_view,esubject,elocation,efee,econtact,eothers,enote_timestamp_text_view;
        RelativeLayout relativeLayout;
        LinearLayout expandableLayout;
        public NoteViewHolder(@NotNull View itemView)
        {
            super(itemView);
            enote_title_text_view=itemView.findViewById(R.id.note_title_text_view2);

            esubject= itemView.findViewById(R.id.subject2);
            elocation= itemView.findViewById(R.id.location2);
            efee= itemView.findViewById(R.id.fee2);
            econtact= itemView.findViewById(R.id.contact2);
            eothers= itemView.findViewById(R.id.others2);
            //enote_timestamp_text_view= itemView.findViewById(R.id.note_timestamp_text_view);



        }
    }
}
