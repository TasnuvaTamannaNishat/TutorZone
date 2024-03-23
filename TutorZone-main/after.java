package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.Query;

public class after extends AppCompatActivity {
   after binding;
    FloatingActionButton addNoteBtn;
    RecyclerView recyclerView2;
    ImageButton menuBtn;
    ImageButton payBtn;
    NoteAdapter2 noteAdapter;
    String docId;
    TextView enotes_title_text,esubject,elocation,efee,econtact,eothers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //binding=after.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after);


    recyclerView2=findViewById(R.id.recycler);

        docId = getIntent().getStringExtra("docId");
        //Note2 note = new Note2();
        Note2 note1 = new Note2();




        setupRecyclerView();
    }
    void setupRecyclerView(){
        Query query  = Utility.getCollectionReferenceForPayment();
        FirestoreRecyclerOptions<Note2> options = new FirestoreRecyclerOptions.Builder<Note2>()
                .setQuery(query,Note2.class).build();
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        noteAdapter = new NoteAdapter2(options,this);
        recyclerView2.setAdapter(noteAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        noteAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        noteAdapter.stopListening();
    }

    @Override
    protected void onResume() {
        super.onResume();
        noteAdapter.notifyDataSetChanged();
    }

}