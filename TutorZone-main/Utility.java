package com.example.myapplication;

import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;

public class Utility {

    static CollectionReference getCollectionReferenceForNotes(){
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        return FirebaseFirestore.getInstance().collection("user")
                .document(currentUser.getUid()).collection("payment");
    }

    static CollectionReference getCollectionReference(){

        return FirebaseFirestore.getInstance().collection("my_notes");
    }
    static CollectionReference getCollectionReferenceForPayment(){
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        return FirebaseFirestore.getInstance().collection("user")
                .document(currentUser.getUid()).collection("payment");
    }
    static DocumentReference getCollectionReferenceFor(){
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

                return FirebaseFirestore.getInstance().collection("Users").document(currentUser.getUid());

    }

    static CollectionReference getCollectionReferenceForProfile(){
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        return FirebaseFirestore.getInstance().collection("users")
                .document(currentUser.getUid()).collection("profile");
    }

    static String timestampToString(Timestamp timestamp){
        return new SimpleDateFormat("MM/dd/yyyy").format(timestamp.toDate());
    }
}
