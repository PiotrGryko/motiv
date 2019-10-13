package com.motiv.example;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.*;
import androidx.recyclerview.widget.*;
import com.bumptech.glide.Glide;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import java.util.*;
import java.util.ArrayList;
import java.util.concurrent.*;
import javax.inject.*;

public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.AdapterViewHolder> {

    private OnItemClickListener onItemClickListener;
    private ArrayList<User> data = new ArrayList();

    public interface OnItemClickListener {

        public void onItemClick(int position, com.motiv.example.User item);
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearlayout00;
        ImageView imageview10;
        TextView textview11;

        public AdapterViewHolder(View itemView) {
            super(itemView);
            linearlayout00 = (LinearLayout) itemView.findViewById(R.id.linearlayout00);
            imageview10 = (ImageView) itemView.findViewById(R.id.imageview10);
            textview11 = (TextView) itemView.findViewById(R.id.textview11);
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
        View row = inflater.inflate(R.layout.userslistadapter, parent, false);
        return new AdapterViewHolder(row);
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
        viewHolder.textview11.setText(user.getFirst_name());
        Glide.with(viewHolder.itemView.getContext())
                .load(user.getLinks().getAvatar().getHref())
                .into(viewHolder.imageview10);
        ;
    }

    public void setOnItemClickListener(
            com.motiv.example.UsersListAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
