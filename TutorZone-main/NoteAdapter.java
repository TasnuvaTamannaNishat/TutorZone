package com.example.myapplication;

import static android.content.Intent.getIntent;
import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.firebase.ui.firestore.paging.FirestorePagingAdapter;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NoteAdapter extends FirestoreRecyclerAdapter<Note, NoteAdapter.NoteViewHolder> {

    Context context;
    String docId;
    addPost addpost;
    List<Note>modellist;


    /**
     * Construct a new FirestorePagingAdapter from the given {@link FirestorePagingOptions}.
     *
     * @param options
     */


    public NoteAdapter(FirestoreRecyclerOptions<Note> options,Context context) {

        super(options);
        this.context=context;
        this.modellist=modellist;
    }


    @NonNull

    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_note_item,parent,false);

        return new NoteViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull NoteViewHolder holder, int position, @NonNull Note note) {
        holder.enote_title_text_view.setText(note.title);
        holder.esubject.setText(note.subject);
        holder.elocation.setText(note.location);
        holder.efee.setText(note.fee);
        holder.econtact.setText(note.getContact());
        holder.eothers.setText(note.others);
        holder.enote_timestamp_text_view.setText(Utility.timestampToString(note.timestamp));

        holder.itemView.setOnClickListener((v)->{

           // Intent intent = new Intent(context,Payment.class);
            Intent intent1 = new Intent(context,Payment.class);

             docId = this.getSnapshots().getSnapshot(position).getId();

            intent1.putExtra("docId",docId);
            intent1.putExtra("title",note.title);
            intent1.putExtra("subject",note.subject);
            intent1.putExtra("location",note.location);
            intent1.putExtra("fee",note.fee);
            intent1.putExtra("contact",note.contact);
            intent1.putExtra("others",note.others);

            intent1.putExtra("timestamp",note.timestamp);
            context.startActivity(intent1);
            //Intent intent = new Intent(context,Payment.class);

            //context.startActivity(intent);
        });



    }





    class NoteViewHolder extends RecyclerView.ViewHolder{
        TextView enote_title_text_view,esubject,elocation,efee,econtact,eothers,enote_timestamp_text_view;
        RelativeLayout relativeLayout;
        LinearLayout expandableLayout;
        public NoteViewHolder(@NotNull View itemView)
        {
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


}
