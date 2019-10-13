package com.motiv.example;

import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.*;
import com.motiv.example.databinding.UserslistadapterBinding;
import com.squareup.picasso.Picasso;
import java.util.*;
import java.util.ArrayList;
import java.util.concurrent.*;

public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.AdapterViewHolder> {

    private OnItemClickListener onItemClickListener;
    private ArrayList<User> data = new ArrayList();

    public interface OnItemClickListener {

        public void onItemClick(int position, com.motiv.example.User item);
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {

        private UserslistadapterBinding binding;

        public AdapterViewHolder(UserslistadapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public User getElement(int position) {

        return data.get(position);
    }

    public void setData(java.util.List<com.motiv.example.User> newData) {
        data.clear();
        data.addAll(newData);
        notifyDataSetChanged();
    }

    @Override
    public AdapterViewHolder onCreateViewHolder(android.view.ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        UserslistadapterBinding binding = UserslistadapterBinding.inflate(inflater);
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
        User user = data.get(position);
        viewHolder.binding.textview11.setText(user.getFirst_name());

        Picasso.with(viewHolder.itemView.getContext())
                .load(user.getLinks().getAvatar().getHref())
                .into(viewHolder.binding.imageview10);
        ;
    }

    public void setOnItemClickListener(
            com.motiv.example.UsersListAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
