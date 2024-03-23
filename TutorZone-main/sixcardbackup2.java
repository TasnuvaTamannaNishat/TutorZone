package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import com.google.firebase.auth.FirebaseAuth;

public class sixcardbackup2 extends AppCompatActivity {
    GridLayout mainGrid;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixcardbackup2);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        //Set Event
        setSingleEvent(mainGrid);
        //setToggleEvent(mainGrid);
    }

    private void setSingleEvent(GridLayout mainGrid) {

//Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (finalI == 0) {
                        Intent intent = new Intent(sixcardbackup2.this, Profile2.class);
                        intent.putExtra("info", "This is activity from card item index  " + finalI);
                        startActivity(intent);
                    } else if (finalI == 1) {
                        Intent intent = new Intent(sixcardbackup2.this, addPost.class);
                        intent.putExtra("info", "This is activity from card item index  " + finalI);
                        startActivity(intent);
                    } else if (finalI == 2) {
                        Intent intent = new Intent(sixcardbackup2.this, StudentPayment.class);
                        intent.putExtra("info", "This is activity from card item index  " + finalI);
                        startActivity(intent);
                    } else if (finalI == 4) {
                        FirebaseAuth.getInstance().signOut();
                        Intent intent = new Intent(sixcardbackup2.this, MainActivity.class);
                        intent.putExtra("info", "This is activity from card item index  " + finalI);
                        startActivity(intent);
                        finish();
                    }

                }
            });
        }
    }
}