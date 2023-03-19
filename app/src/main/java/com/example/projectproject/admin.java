package com.example.projectproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Toast;

import com.example.projectproject.databinding.ActivityAdminBinding;
import com.example.projectproject.databinding.ActivityMain2Binding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

@SuppressWarnings("ALL")
public class admin extends AppCompatActivity {
ActivityAdminBinding binding;
    int maxid;
    String ImageUrl;
    Uri uri;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.adminimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,46);
            }
        });

        FirebaseDatabase.getInstance().getReference().child("School").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                maxid =(int) snapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

binding.adminPSend.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        FirebaseStorage.getInstance().getReference().child("My Folder").child(String.valueOf(maxid+1)).putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(admin.this, "Succeed", Toast.LENGTH_SHORT).show();

                Task<Uri> task=taskSnapshot.getStorage().getDownloadUrl();
                while (!task.isComplete());
                ImageUrl=task.getResult().toString();

                HashMap<String,Object> map=new HashMap<>();

                map.put("productname",binding.adminPName.getText().toString());
                map.put("productprice",String.valueOf(binding.adminPPrice.getText().toString()));
                map.put("productquantity",String.valueOf(binding.adminPQuantity.getText().toString()));
                map.put("productimage",ImageUrl);

                FirebaseDatabase.getInstance().getReference().child("School").child(String.valueOf(maxid+1)).setValue(map);
    }
});
    }
});
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){

            uri=data.getData();
            binding.adminimage.setImageURI(data.getData());

        }
    }

}