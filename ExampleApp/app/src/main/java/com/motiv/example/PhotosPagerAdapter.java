package com.motiv.example;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.motiv.example.databinding.PhotospageradapterBinding;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class PhotosPagerAdapter extends PagerAdapter {

    private ArrayList<Photo> data = new ArrayList();
    private LinearLayout linearlayout00;
    private ImageView imageview10;

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {

        return view == o;
    }

    public void setData(java.util.List<com.motiv.example.Photo> newData) {
        data.clear();
        data.addAll(newData);
        notifyDataSetChanged();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object o) {
        container.removeView((View) o);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        PhotospageradapterBinding binding = PhotospageradapterBinding.inflate(inflater);
        Photo photo = data.get(position);

        Picasso.with(container.getContext()).load(photo.getUrl()).into(binding.imageview10);
        ;

        container.addView(binding.getRoot());
        return binding.getRoot();
    }
}
