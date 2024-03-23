package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class reg extends AppCompatActivity {

    EditText eusername,eemail,epassword,erepassword;
    Button esignupbtn;
    TextView eloginbtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg);


        eusername = (EditText) findViewById(R.id.username);
        eemail = (EditText) findViewById(R.id.email);
        epassword = (EditText) findViewById(R.id.password);
        erepassword= (EditText) findViewById(R.id.repassword);

        esignupbtn= findViewById(R.id.signupbtn);
        eloginbtn= findViewById(R.id.loginbtn);



        esignupbtn.setOnClickListener(v-> createAccount());
        eloginbtn.setOnClickListener(v-> finish());





    }
    void createAccount(){

        String username  = eusername.getText().toString();
        String email  = eemail.getText().toString();
        String password  = epassword.getText().toString();
        String confirmPassword  = erepassword.getText().toString();

        boolean isValidated = validateData(email,password,confirmPassword);
        if(!isValidated){
            return;
        }

        createAccountInFirebase(email,password);


    }
    void createAccountInFirebase(String email,String password){


        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(reg.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            //creating acc is done

                            firebaseAuth.getCurrentUser().sendEmailVerification();
                            firebaseAuth.signOut();
                            finish();
                        }else{
                            //failure

                        }
                    }
                }
        );



    }
    boolean validateData(String email,String password,String confirmPassword){
        //validate the data that are input by user.

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            eemail.setError("Email is invalid");
            return false;
        }
        if(password.length()<6){
            epassword.setError("Password length is invalid");
            return false;
        }
        if(!password.equals(confirmPassword)){
            erepassword.setError("Password not matched");
            return false;
        }
        return true;
    }

}