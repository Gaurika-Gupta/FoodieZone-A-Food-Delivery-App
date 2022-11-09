package com.example.foodiezoneapp.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodiezoneapp.Domain.FoodDomain;
import com.example.foodiezoneapp.R;

import java.util.ArrayList;

 public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.ViewHolder>{

    public ArrayList<FoodDomain> recommendedDomains;

    public RecommendedAdapter(ArrayList<FoodDomain> recommendedDomains){
        this.recommendedDomains = recommendedDomains;


    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext() ).inflate(R.layout.viewholder_recommended,parent,false);
        return new ViewHolder(inflate);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.title.setText(recommendedDomains.get(position).getTitle());
//        holder.fee.setText(String.valueOf(recommendedDomains.get(position).getFee()));
        String picUrl = " ";
        switch (position) {
            case 0: {
                picUrl = "cat_1";
                break;
            }
            case 1: {
                picUrl = "cat_2";
                break;
            }
            case 2: {
                picUrl = "cat_3";
                break;
            }
            case 3: {
                picUrl = "cat_4";
                break;
            }
            case 4: {
                picUrl = "cat_5";
                break;
            }
        }
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(picUrl,"drawable",holder.itemView.getContext().getPackageName());

      //  Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.pic);

    }

    @Override
    public int getItemCount() {
        return recommendedDomains.size();
    }
    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView title,fee;
        ImageView pic;
        ImageView addBtn;

        ConstraintLayout mainLayout;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
//            title = itemView.findViewById(R.categoryName);
//            fee = itemView.findViewById(R.categoryPic);
//            pic = itemView.findViewById(R.categoryPic);
//            addBtn = itemView.findViewById(R.id.addBtn);
        }
    }
}