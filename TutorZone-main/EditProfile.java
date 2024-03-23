package com.example.myapplication;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class EditProfile extends AppCompatActivity {
    EditText rmail,ename,einstitute,esub,eaddress,enumber,eprefer;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore fstore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Intent data= getIntent();
        String pmail=data.getStringExtra("email");
        String puser=data.getStringExtra("username");
        String pinstitute= getIntent().getStringExtra("institution");
        String psub= getIntent().getStringExtra("subject");
        String paddress = getIntent().getStringExtra("address");
        String pnumber= getIntent().getStringExtra("contact");
        String prefer= getIntent().getStringExtra("preference");

        firebaseAuth = FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();

        rmail=findViewById(R.id.mail);
        ename=findViewById(R.id.uname);
        einstitute= findViewById(R.id.inst);
        esub= findViewById(R.id.sub);
        eaddress= findViewById(R.id.loc);
        enumber= findViewById(R.id.number);
        eprefer= findViewById(R.id.prefer);
        //esave_profile= findViewById(R.id.profile_save);
        rmail.setText(pmail);
        ename.setText(puser);
        einstitute.setText(pinstitute);
        esub.setText(psub);
        eaddress.setText(paddress);
        enumber.setText(pnumber);
        eprefer.setText(prefer);

        Log.d(TAG,"onCreate:"+pmail+""+pinstitute+" "+psub+""+paddress+""+pnumber+""+prefer);

    }
}