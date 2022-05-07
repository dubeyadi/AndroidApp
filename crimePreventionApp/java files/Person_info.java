package com.example.registrationpage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class Person_info extends AppCompatActivity {
    FirebaseFirestore db;
    EditText LocalAddress,LocalPoliceSta, LocalParentNo, OtherPhoneNo;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
        db = FirebaseFirestore.getInstance();
        LocalAddress = findViewById(R.id.editTextTextPersonName4);
        LocalPoliceSta = findViewById(R.id.parentnum);
        LocalParentNo = findViewById(R.id.editTextTextPersonName5);
        OtherPhoneNo = findViewById(R.id.editTextTextPersonName6);
        button1 = findViewById(R.id.button);

       button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String LocalAdd = LocalAddress.getText().toString();
               String LocalPoliceStation = LocalPoliceSta.getText().toString();
               String LocalParentNumber = LocalParentNo.getText().toString();
               String OtherPhoneNumber = OtherPhoneNo.getText().toString();
               Map<String,Object> user = new HashMap<>();
               user.put("Local Address",LocalAdd);
               user.put("Local Police Station",LocalPoliceStation);
               user.put("Local Gaurdian Number",LocalParentNumber);
               user.put("Other Contact Number",OtherPhoneNumber);
               db.collection("Personal Details").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                   @Override
                   public void onSuccess(DocumentReference documentReference) {
                       Toast.makeText(Person_info.this,"Succesfully Submitted!",Toast.LENGTH_SHORT).show();
                       Intent intent = new Intent(Person_info.this,NextActivity.class);
                       intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                       startActivity(intent);

                   }
               }).addOnFailureListener(new OnFailureListener() {
                   @Override
                   public void onFailure(@NonNull Exception e) {
                      Toast.makeText(Person_info.this,"Failed",Toast.LENGTH_SHORT).show();
                   }
               });

           }
       });

    }
}