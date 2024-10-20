package com.example.app2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app2.Domain.FoodDomain;
import com.example.app2.R;
import com.example.app2.ShowDetailActivity;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {

    private Context mContext;
    ArrayList<FoodDomain> popularFoods;

    public PopularAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(ArrayList<FoodDomain> popularFoods) {
        this.popularFoods = popularFoods;
        notifyDataSetChanged();
    }
    public PopularAdapter(ArrayList<FoodDomain> popularFoods) {
        this.popularFoods = popularFoods;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.ViewHolder holder, int position) {
        holder.name.setText(popularFoods.get(position).getName());
        holder.type.setText(popularFoods.get(position).getType());
        holder.rate.setText(String.valueOf(popularFoods.get(position).getRate()));
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(popularFoods.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.pic);

        holder.pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                intent.putExtra("object", popularFoods.get(holder.getAdapterPosition()));
                holder.itemView.getContext().startActivities(new Intent[]{intent});
            }
        });
    }

    @Override
    public int getItemCount() {
        return popularFoods.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pic;
        TextView  name, type, rate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.pic);
            name = itemView.findViewById(R.id.nameTxt);
            type = itemView.findViewById(R.id.typeTxt);
            rate = itemView.findViewById(R.id.rateTxt);
        }
    }
}
