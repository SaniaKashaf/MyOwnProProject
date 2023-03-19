package com.example.projectproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.projectproject.databinding.ActivityMainBinding;
import com.example.projectproject.databinding.ActivityUserrecyclerBinding;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class userrecycler extends AppCompatActivity {

ActivityUserrecyclerBinding binding;
ADAPTER adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityUserrecyclerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        binding.recyclerr.setLayoutManager(linearLayoutManager);

        Query query=FirebaseDatabase.getInstance().getReference().child("School");
        FirebaseRecyclerOptions<MODEL> options=new FirebaseRecyclerOptions.Builder<MODEL>()
                .setQuery(query,MODEL.class).build();


        adapter=new ADAPTER(options);
        binding.recyclerr.setAdapter(adapter);


    }
    @Override
    protected void onStart(){
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop(){
        super.onStop();
        adapter.stopListening();
    }

}