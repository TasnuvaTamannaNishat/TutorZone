package com.example.myapplication;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Profile1 extends AppCompatActivity {
    EditText email,ename,einstitute,esub,eaddress,enumber;
    ImageButton esave_profile;
   // FirebaseAuth fauth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile1);

        email=findViewById(R.id.mail);
        ename= findViewById(R.id.uname);
        einstitute= findViewById(R.id.inst);
        esub= findViewById(R.id.sub);
        eaddress= findViewById(R.id.loc);
        enumber= findViewById(R.id.number);
        //eprefer= findViewById(R.id.prefer);
        esave_profile= findViewById(R.id.profile_save);

        String pname = getIntent().getStringExtra("username");
        String pinstitute= getIntent().getStringExtra("institution");
        String psub= getIntent().getStringExtra("subject");
        String paddress = getIntent().getStringExtra("address");
        String pnumber= getIntent().getStringExtra("contact");
        String prefer= getIntent().getStringExtra("preference");

        ename.setText(pname);
        einstitute.setText(pinstitute);
        esub.setText(psub);
        eaddress.setText(paddress);
        enumber.setText(pnumber);
        //eprefer.setText(prefer);


        esave_profile.setOnClickListener( (v)-> saveProfile());

    }
    void saveProfile(){

        //String pname1 = ename.getText().toString();




        String memail=email.getText().toString();
        String mname=ename.getText().toString();
        String minstitute=einstitute.getText().toString();

        String msub=esub.getText().toString();
        String maddress=eaddress.getText().toString();
        String mnumber=enumber.getText().toString();
        //String mprefer=eprefer.getText().toString();
        if(memail.isEmpty())
        {
            email.setError("email is required");
            return;
        }
       else if(mname.isEmpty())
        {
            ename.setError("name is required");
            return;
        }
       else if(minstitute.isEmpty())
        {
            einstitute.setError("institution is required");
            return;
        }
        else if(msub.isEmpty())
        {
            esub.setError("subject is required");
            return;
        }
        else if(maddress.isEmpty())
        {
            eaddress.setError("address is required");
            return;
        }
        else if(mnumber.isEmpty())
        {
            enumber.setError("number is required");
            return;
        }

        Profile profile= new Profile();




        profile.setEmail(memail);
        profile.setUsername(mname);
        profile.setInstitution(minstitute);
        profile.setSubject(msub);
        profile.setAddress(maddress);
        profile.setContact(mnumber);
        //profile.setPreference(mprefer);

        saveNoteToFirebase(profile);


        }
    void saveNoteToFirebase(Profile profile){
        DocumentReference documentReference;

        //update the note
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseFirestore fstore=FirebaseFirestore.getInstance();
        //FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        String userId=firebaseAuth.getCurrentUser().getUid();

        //create new note
        documentReference = fstore.collection("users").document(userId);



        documentReference.set(profile).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    //note is added
                    Toast.makeText(getApplicationContext(),"Profile added Successfully",Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"Failed while posting",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }



    }
