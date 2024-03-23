package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

public class Payment extends AppCompatActivity {
    Button button;
    Context context;
     EditText ecard, ecountry,epostal;
     boolean paid;
    String docId,title,subject,location,fee,contact,others,timestamp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ecard = findViewById(R.id.cardnum);
        ecountry = findViewById(R.id.country);
        button = findViewById(R.id.pay_btn);
        docId = getIntent().getStringExtra("docId");

        title = getIntent().getStringExtra("title");
        subject = getIntent().getStringExtra("subject");
        location = getIntent().getStringExtra("location");
        fee = getIntent().getStringExtra("fee");
        contact = getIntent().getStringExtra("contact");
        others = getIntent().getStringExtra("others");
        timestamp = getIntent().getStringExtra("timestamp");
        Note note = new Note();
        note.setTitle(title);
        note.setSubject(subject);
        note.setLocation(location);
        note.setFee(fee);
        note.setContact(contact);
        note.setOthers(others);

        Note2 note1 = new Note2();
        note1.setTitle2(title);
        note1.setSubject2(subject);
        note1.setLocation2(location);
        note1.setFee2(fee);

        note1.setContact2(contact);
        note1.setOthers2(others);
        saveDocid(note1);
    }
        void saveDocid(Note2 note1) {
            DocumentReference documentReference;
            documentReference = Utility.getCollectionReferenceForPayment().document(docId);
            documentReference.set(note1).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        //note is added
                        Toast.makeText(getApplicationContext(), "Need to pay first", Toast.LENGTH_SHORT).show();


                    } else {

                    }
                }
            });


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Intent intent1 = new Intent(context,AfterPayment.class);


                    paid();
                }
            });

        }







    public void paid()
    {
        String card= ecard.getText().toString();
        String country= ecountry.getText().toString();
        if(card.matches("1234567") && country.matches("Bangladesh"))
        {
            Toast.makeText(this, "Payment Successfull", Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(this,after.class);
            startActivity(intent);



        }
        else{
            Toast.makeText(this, "Payment Failed", Toast.LENGTH_SHORT).show();


        }

    }


}