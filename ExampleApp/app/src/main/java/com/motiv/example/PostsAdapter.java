package com.motiv.example;

import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.*;
import androidx.recyclerview.widget.*;
import com.motiv.example.databinding.PostsadapterBinding;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import java.util.*;
import java.util.ArrayList;
import java.util.concurrent.*;
import javax.inject.*;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.AdapterViewHolder> {

    private OnItemClickListener onItemClickListener;
    private ArrayList<Post> data = new ArrayList();

    public interface OnItemClickListener {

        public void onItemClick(int position, com.motiv.example.Post item);
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {

        private PostsadapterBinding binding;

        public AdapterViewHolder(PostsadapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public Post getElement(int position) {

        return data.get(position);
    }

    public void setData(java.util.List<com.motiv.example.Post> newData) {
        data.clear();
        data.addAll(newData);
        notifyDataSetChanged();
    }

    @Override
    public AdapterViewHolder onCreateViewHolder(android.view.ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        PostsadapterBinding binding = PostsadapterBinding.inflate(inflater);
        return new AdapterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final AdapterViewHolder viewHolder, final int position) {
        viewHolder.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (onItemClickListener != null)
                            onItemClickListener.onItemClick(position, data.get(position));
                    }
                });
        Post post = data.get(position);
        viewHolder.binding.textview10.setText(post.getTitle());
    }

    public void setOnItemClickListener(
            com.motiv.example.PostsAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
