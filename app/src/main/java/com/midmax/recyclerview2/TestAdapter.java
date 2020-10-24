package com.midmax.recyclerview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {
    ArrayList<Model> list;
    Context context;
    public TestAdapter( ArrayList<Model> list,Context context){
        this.context=context;
        this.list=list;
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.list_item_layout,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model model=list.get(position);
        final String Name=model.getStudent_Name();
        holder.name.setText(model.getStudent_Name());
        holder.roll_no.setText(model.getRoll_no());
        holder.age.setText(model.getAge());
        holder.phone_no.setText(model.getPhone_no());
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context,Name,Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,roll_no,age,phone_no;
        ImageView img;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            roll_no=itemView.findViewById(R.id.rollno);
            age=itemView.findViewById(R.id.age);
            phone_no=itemView.findViewById(R.id.phoneno);
            img=itemView.findViewById(R.id.image);
            cardView=itemView.findViewById(R.id.cardview);
        }
    }
}
