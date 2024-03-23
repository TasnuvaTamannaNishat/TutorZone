package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Profile2 extends AppCompatActivity {
    Button button,button1;
    TextView puser,pmail,pname,pinst,psub,paddress,pnumber,prefer;
    FirebaseAuth fauth;
    CollectionReference fstore;
    String userId;
    String docId;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);
         puser=findViewById(R.id.username);
         pmail=findViewById(R.id.mail);
         pinst=findViewById(R.id.institute);
         psub=findViewById(R.id.msubject);
         paddress=findViewById(R.id.address);
         pnumber=findViewById(R.id.number);


         fauth=FirebaseAuth.getInstance();
         //fstore=FirebaseFirestore.getInstance().collection("my_notes").document("2D0cJECNZSce1pGmOrpR");

         userId=fauth.getCurrentUser().getUid();


        //DocumentReference documentReference;

        //update the note
        //String id = fstore.document(userId).collection("profile") .document().getId();

        //create new note

        DocumentReference documentReference = FirebaseFirestore.getInstance().collection("users").document(userId);
      documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
          @Override
          public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {

           pmail.setText(value.getString("email"));
              puser.setText(value.getString("username"));
              pinst.setText(value.getString("institution"));
              psub.setText(value.getString("subject"));
              paddress.setText(value.getString("address"));
              pnumber.setText(value.getString("contact"));
             // prefer.setText((value.getString("preference")));

              Profile profile= new Profile();
             // String smail=profile.setSubject(getText(psub));


            //  String smail=pmail.getText().toString();

              //String snumber="kjhhys";


          }
      });
        /* documentReference.get().addOnSuccessListener(this, new OnSuccessListener<DocumentSnapshot>() {
           @Override
           public void onSuccess(DocumentSnapshot documentSnapshot) {
               pmail.setText(documentSnapshot.getString("email"));
               //puser.setText(documentSnapshot.getString("name"));
               pinst.setText(documentSnapshot.getString("institution"));
               psub.setText(documentSnapshot.getString("subject"));
               paddress.setText(documentSnapshot.getString("address"));
               pnumber.setText(documentSnapshot.getString("contact"));

               prefer.setText(documentSnapshot.getString("preference"));
               Profile profile= new Profile();
               Intent intent= new Intent(Profile2.this, Profile1.class);
               intent.putExtra("email",profile.email);
               intent.putExtra("name",profile.name);
               intent.putExtra("institution",profile.institution);
               intent.putExtra("subject",profile.subject);
               intent.putExtra("address",profile.address);
               intent.putExtra("contact",profile.contact);
               intent.putExtra("preference",profile.preference);



           }
       });*/




        //button=findViewById(R.id.editButton);
        button1=findViewById(R.id.cButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Profile2.this,Profile1.class);
                startActivity(intent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent1 = new Intent(context,AfterPayment.class);
                Profile profile= new Profile();
                Intent intent= new Intent(Profile2.this,Profile1.class);
                intent.putExtra("email",pmail.getText().toString());
               // intent.putExtra("username",pname.getText().toString());
                intent.putExtra("institution","AUSt");
                intent.putExtra("subject",profile.getSubject());
                intent.putExtra("address",paddress.getText().toString());
                intent.putExtra("contact",pnumber.getText().toString());
               // intent.putExtra("preference",prefer.getText().toString());

                Intent intent1= new Intent(Profile2.this,Profile1.class);

                startActivity(intent1);

            }
        });

    }
}