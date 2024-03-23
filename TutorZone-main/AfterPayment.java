package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.Query;

public class AfterPayment extends AppCompatActivity {
  AfterPayment binding;
    RecyclerView recyclerView2;
    ImageButton menuBtn;
    ImageButton payBtn;
    NoteAdapter2 noteAdapter;
    String docId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_payment);

        recyclerView2 = findViewById(R.id.recyler_view2);


        Note2 note = new Note2();


        menuBtn.setOnClickListener((v) -> showMenu());
        setupRecyclerView();
    }
    void showMenu(){
        PopupMenu popupMenu  = new PopupMenu(AfterPayment.this,menuBtn);
        popupMenu.getMenu().add("Logout");
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if(menuItem.getTitle()=="Logout"){
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(AfterPayment.this,teacherlogin.class));
                    finish();
                    return true;
                }
                return false;
            }
        });

    }

    void setupRecyclerView(){
        Query query  = Utility.getCollectionReferenceForNotes();

        FirestoreRecyclerOptions<Note2> options = new FirestoreRecyclerOptions.Builder<Note2>()
                .setQuery(query,Note2.class).build();
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        noteAdapter=new NoteAdapter2(options,this);
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