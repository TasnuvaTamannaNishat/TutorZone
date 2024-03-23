package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import java.util.regex.Pattern;

public class post extends AppCompatActivity {
    EditText enotes_title_text,esubject,elocation,efee,econtact,eothers;
    ImageButton esave_note_btn;
    String contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        enotes_title_text= findViewById(R.id.notes_title_text);
        esubject= findViewById(R.id.subject);
        elocation= findViewById(R.id.location);
        efee= findViewById(R.id.fee);
        econtact= findViewById(R.id.contact);
        eothers= findViewById(R.id.others);
        esave_note_btn= findViewById(R.id.save_note_btn);
        esave_note_btn.setOnClickListener( (v)-> saveNote());
    }
    void saveNote(){
        String notes_title_text = enotes_title_text.getText().toString();
        String subject= esubject.getText().toString();
        String location= elocation.getText().toString();
        String fee = efee.getText().toString();
        String contact= econtact.getText().toString();
        String others= eothers.getText().toString();

        if(notes_title_text==null || notes_title_text.isEmpty() ){
            enotes_title_text.setError("Title is required");
            return;
        }
        else if(!contact.matches("^(?:\\+?88|0088)?01[15-9]\\d{8}$")){
            econtact.setError("Invalid Number");
            return;

        }


        Note note = new Note();

        note.setTitle(notes_title_text);
        note.setSubject(subject);
        note.setLocation(location);

        note.setFee(fee);

        note.setContact(contact);
        note.setOthers(others);
        note.setTimestamp(Timestamp.now());


        saveNoteToFirebase(note);

    }
    void saveNoteToFirebase(Note note){
        DocumentReference documentReference;

            //update the note


            //create new note
            documentReference = Utility.getCollectionReference().document();




        documentReference.set(note).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    //note is added
                    Toast.makeText(getApplicationContext(),"Post added Successfully",Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"Failed while posting",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}