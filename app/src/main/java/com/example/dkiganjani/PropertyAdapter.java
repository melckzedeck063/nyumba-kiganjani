package com.example.dkiganjani;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PropertyAdapter extends RecyclerView.Adapter<PropertyAdapter.MyViewHolder> {

    private LayoutInflater layoutInflater;
    private ArrayList<Property> propertyArrayList;
    private Context context;

    public PropertyAdapter(ArrayList<Property> propertyArrayList, Context context) {
        layoutInflater = LayoutInflater.from(context);
        this.propertyArrayList = propertyArrayList;
        this.context = context;
    }

    @Override
    public PropertyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view;
        view = layoutInflater.inflate(R.layout.property,parent,false);

        PropertyAdapter.MyViewHolder holder =  new PropertyAdapter.MyViewHolder(view);
        return holder;

    }


    @Override
    public void onBindViewHolder(PropertyAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.property.setText(propertyArrayList.get(position).getProperty());
        holder.owner.setText(propertyArrayList.get(position).getOwner());
        holder.location.setText(propertyArrayList.get(position).getLocation());
        holder.pay_duration.setText(propertyArrayList.get(position).getPay_duration());
        holder.image.setImageResource(propertyArrayList.get(position).getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"You have clicked " + propertyArrayList.get(position).getProperty(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(view.getContext(), "You have clicked " + propertyArrayList.get(position).getProperty(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return propertyArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView owner, property,pay_duration,location;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            location = itemView.findViewById(R.id.location_text);
            owner = itemView.findViewById(R.id.price_text);
            property = itemView.findViewById(R.id.desc_text);
            pay_duration  = itemView.findViewById(R.id.pay_duration);
            image = itemView.findViewById(R.id.image_item);
        }
    }
}
