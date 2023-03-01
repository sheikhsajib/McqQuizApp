package com.example.jobcombat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.jobcombat.databinding.ActivitySignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignupActivity extends AppCompatActivity {

    ActivitySignupBinding binding;
    FirebaseAuth auth;

    FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();
        database = FirebaseFirestore.getInstance();


    binding.signUpSubmitBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String email, pass, name, referCode;

            email = binding.emailBox.getText().toString();
            pass = binding.passwordBox.getText().toString();
            name = binding.nameBox.getText().toString();
            referCode = binding.referBox.getText().toString();

            final User user = new User(email, pass, name, referCode);


        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                String uid = task.getResult().getUser().getUid();

                if (task.isSuccessful()){
                    database
                            .collection("userTable")
                            .document(uid)
                            .set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        startActivity(new Intent(SignupActivity.this, MainActivity.class));
                                        finish();
                                    }else {
    Toast.makeText(SignupActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            })
                    ;



                    Toast.makeText(SignupActivity.this, "Sign Up Successful", Toast.LENGTH_SHORT ).show();
                }else {
                    Toast.makeText(SignupActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        }
    });

        binding.goForLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });


    }
}