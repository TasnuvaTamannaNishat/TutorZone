package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class studentlogin extends AppCompatActivity {
    private Button button,button3;
    EditText eeditTextTextPersonName2,eeditTextTextPersonName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlogin);
        button =  findViewById(R.id.button1);
        button3 =  findViewById(R.id.button2);



        eeditTextTextPersonName2= findViewById(R.id.editTextTextPersonName2);
        eeditTextTextPersonName= findViewById(R.id.editTextTextPersonName);

        button.setOnClickListener((v)-> loginUser() );
        button3.setOnClickListener((v)->startActivity(new Intent(this,reg.class)) );
    }

    void loginUser(){
        String email  = eeditTextTextPersonName.getText().toString();
        String password  = eeditTextTextPersonName2.getText().toString();


        boolean isValidated = validateData(email,password);
        if(!isValidated){
            return;
        }

        loginAccountInFirebase(email,password);

    }
    void loginAccountInFirebase(String email,String password){
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    //login is success
                    if(firebaseAuth.getCurrentUser().isEmailVerified()){

                        startActivity(new Intent(studentlogin.this,sixcardbackup2.class));
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(),"Verify your mail first",Toast.LENGTH_SHORT).show();
                    }

                }else{
                    //login failed

                }
            }
        });
    }
    boolean validateData(String email,String password){
        //validate the data that are input by user.

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            eeditTextTextPersonName.setError("Email is invalid");
            return false;
        }
        if(password.length()<6){
            eeditTextTextPersonName2.setError("Password length is invalid");
            return false;
        }
        return true;
    }

}