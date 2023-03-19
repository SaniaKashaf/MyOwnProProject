package com.example.projectproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;

import com.example.projectproject.databinding.ActivityMainBinding;
import com.example.projectproject.databinding.ActivityUseradminBinding;

public class useradmin extends AppCompatActivity {
ActivityUseradminBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityUseradminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(useradmin.this,MainActivity2.class);
                startActivity(i);
            }
        });
   binding.textuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(useradmin.this,userrecycler.class);
                startActivity(i);
            }
        });


    }
}