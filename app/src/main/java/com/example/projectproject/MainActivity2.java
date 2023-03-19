package com.example.projectproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.projectproject.databinding.ActivityMain2Binding;
import com.example.projectproject.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class MainActivity2 extends AppCompatActivity {
ActivityMain2Binding binding;
/*FirebaseAuth auth;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

/*auth=FirebaseAuth.getInstance();*/


binding.btnlogin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String name=binding.loginmail.getText().toString();
        String password=binding.loginPassword.getText().toString();

      /*  if (TextUtils.isEmpty(binding.loginmail.getText().toString()) ||
                TextUtils.isEmpty(binding.loginPassword.getText().toString()))
        Toast.makeText(MainActivity2.this, "Please fulfil the requirements", Toast.LENGTH_SHORT).show();*/

    if (name.isEmpty()) {
        Toast.makeText(MainActivity2.this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
    }else if (password.isEmpty()){

            Toast.makeText(MainActivity2.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
        }
    else if (name.equals("Admin")&&password.equals("1234")){
        Intent i=new Intent(MainActivity2.this,admin.class);
        startActivity(i);
        }else {
        Toast.makeText(MainActivity2.this, "You are not admin", Toast.LENGTH_SHORT).show();
    }
/*else {
    auth.createUserWithEmailAndPassword(name,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()){
                Toast.makeText(MainActivity2.this, "Login Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity2.this,admin.class));

            }else {
                Toast.makeText(MainActivity2.this, "Login Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    });  }*/

    }
});

    }
}