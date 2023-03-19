package com.example.projectproject;

import android.content.DialogInterface;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projectproject.databinding.ActivityUserrecyclerBinding;
import com.example.projectproject.databinding.UseritemBinding;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ADAPTER extends FirebaseRecyclerAdapter<MODEL,ADAPTER.viewholder> {


    public ADAPTER(@NonNull FirebaseRecyclerOptions<MODEL> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewholder holder, int position, @NonNull MODEL model) {
        holder.binding.ProductName.setText(model.getProductname());
holder.binding.productquantity.setText(String.valueOf(model.getProductquantity()));
holder.binding.productprice.setText(String.valueOf(model.getProductprice()));

        Glide.with(holder.itemView.getContext()).load(model.getProductimage())
                .into(holder.binding.productimage);

        holder.binding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder=new AlertDialog.Builder(holder.binding.productimage.getContext());
                builder.setTitle("Delete Panel");
                builder.setMessage("Delete...?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("School")
                                .child(getRef(position).getKey()).removeValue();

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.show();
            }
        });

    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.useritem,parent,false);
        return new viewholder(view);
    }

    public class viewholder extends RecyclerView.ViewHolder{
UseritemBinding binding;
        public viewholder(@NonNull View itemView) {
            super(itemView);

        binding=UseritemBinding.bind(itemView);

        }
    }
}
