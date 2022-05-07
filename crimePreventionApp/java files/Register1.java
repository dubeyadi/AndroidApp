package com.example.registrationpage;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register1 extends AppCompatActivity {

    Button button;
    EditText editTextTextPersonName,editTextTextPersonName2;
    Button button3;
    String emailPattern ="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+" ;
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;


    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);
        button = findViewById(R.id.button4);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);
        button3 = findViewById(R.id.button3);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),createAccountPage.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerforLogin();
            }
        });

    }

    private void PerforLogin() {
        String email = editTextTextPersonName.getText().toString();
        String password = editTextTextPersonName2.getText().toString();
        if(!email.matches(emailPattern)){
            editTextTextPersonName.setError("Enter the Correct Email.");
        }else if(password.isEmpty() || password.length() < 6){
            editTextTextPersonName2.setError("Enter the Proper Password");
        }else{
            progressDialog.setMessage("Please wait...");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

           mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
               @Override
               public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {
                   if(task.isSuccessful()){
                       progressDialog.dismiss();
                       sendUserToNextActivity();
                       Toast.makeText(Register1.this,"Login Succesfully", Toast.LENGTH_SHORT).show();

                   }else{
                       progressDialog.dismiss();
                       Toast.makeText(Register1.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                   }
               }
           });

        }
    }


    private void sendUserToNextActivity() {
        Intent intent = new Intent(Register1.this,Person_info.class);
        //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}