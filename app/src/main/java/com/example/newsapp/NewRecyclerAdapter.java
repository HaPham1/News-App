package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewRecyclerAdapter extends RecyclerView.Adapter<NewRecyclerAdapter.NewAdapterHolder> {

    private List<News> newsList;
    private Context context;
    private OnRowClickListener listener;

    public NewRecyclerAdapter(List<News> newsList, Context context, OnRowClickListener clickListener) {
        this.newsList = newsList;
        this.context = context;
        this.listener = clickListener;
    }

    public interface OnRowClickListener {
        void onItemClick(int position);
    }


    @NonNull
    @Override
    public NewRecyclerAdapter.NewAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.property_new, parent, false);
        return new NewAdapterHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull NewRecyclerAdapter.NewAdapterHolder holder, int position) {
        holder.imageView.setImageResource(newsList.get(position).getImage());
        holder.titleText.setText(newsList.get(position).getTitle());
        holder.desText.setText((newsList.get(position).getDescription()));

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewAdapterHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public OnRowClickListener onRowClickListener;
        public TextView titleText, desText;

        public NewAdapterHolder(@NonNull View itemView, OnRowClickListener onRowClickListener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image2);
            titleText = itemView.findViewById(R.id.titleText);
            desText = itemView.findViewById(R.id.desText);
            this.onRowClickListener = onRowClickListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            onRowClickListener.onItemClick(getAdapterPosition());
        }
    }

}
