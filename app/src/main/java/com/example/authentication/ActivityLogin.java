package com.example.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ActivityLogin extends AppCompatActivity {
    private FirebaseAuth mAuth;

    Button btnLogin;
    EditText edtEmail, edtPassword;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        edtEmail = findViewById(R.id.edtEmailLogin);
        edtPassword = findViewById(R.id.edtPasswordLogin);

        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener((v) -> {
            if(edtEmail.getText().length()==0)
            {
                edtEmail.setError("Please enter your email!");
            }
            else if(edtPassword.getText().length()==0)
            {
                edtPassword.setError("Please enter your password!");
            }
            else {signIn();}
        });
    }
    private void signIn(){

        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();
        final Intent intentUser = new Intent(this, HomeActivity.class);
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Users").
                                    child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("role");

//                            ref.addListenerForSingleValueEvent(new ValueEventListener() {
//                                @Override
//                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                                    String role = dataSnapshot.getValue().toString();
//                                    if(role.equals("User")){
//                                        startActivity(intentUser);
//                                    }
//                                    else{
//                                        startActivity(intentUser);
//                                    }
//
//                                }
//                                @Override
//                                public void onCancelled(@NonNull DatabaseError databaseError) {
//                                }
//                            });
                            startActivity(intentUser);

                            Toast.makeText(ActivityLogin.this, "Authentication Successful.",
                                    Toast.LENGTH_SHORT).show();

                        } else {
                            // If sign in fails, display a message to the user
                            Toast.makeText(ActivityLogin.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
}
