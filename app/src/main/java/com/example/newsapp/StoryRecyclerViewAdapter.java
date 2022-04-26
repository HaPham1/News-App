package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StoryRecyclerViewAdapter extends RecyclerView.Adapter<StoryRecyclerViewAdapter.StoryAdapterViewHolder> {

    private List<Stories> storiesList;
    private Context context;
    private OnRowClickListener listener;

    public StoryRecyclerViewAdapter(List<Stories> storiesList, Context context, OnRowClickListener clickListener) {
        this.storiesList = storiesList;
        this.context = context;
        this.listener = clickListener;
    }

    public interface OnRowClickListener {
        void onItemClick(int position);
    }


    @NonNull
    @Override
    public StoryRecyclerViewAdapter.StoryAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.property_story, parent, false);
        return new StoryAdapterViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryRecyclerViewAdapter.StoryAdapterViewHolder holder, int position) {
        holder.imageView.setImageResource(storiesList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return storiesList.size();
    }

    public class StoryAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public OnRowClickListener onRowClickListener;

        public StoryAdapterViewHolder(@NonNull View itemView, OnRowClickListener onRowClickListener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image1);
            this.onRowClickListener = onRowClickListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            onRowClickListener.onItemClick(getAdapterPosition());
        }
    }

}
