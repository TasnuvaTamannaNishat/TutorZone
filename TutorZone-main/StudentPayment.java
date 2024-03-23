package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentPayment extends AppCompatActivity {
    Button button;
    EditText ecard, ecountry,epostal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_payment);

        ecard = findViewById(R.id.cardnum2);
        ecountry = findViewById(R.id.country2);
        button = findViewById(R.id.pay_btn2);
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
            Intent intent= new Intent(this,post.class);
            startActivity(intent);



        }
        else{
            Toast.makeText(this, "Payment Failed", Toast.LENGTH_SHORT).show();


        }

    }



}
