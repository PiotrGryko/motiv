package com.motiv.example;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.*;
import androidx.viewpager.widget.ViewPager;
import com.motiv.example.dao.DaoRepository;
import com.motiv.example.dao.LocalStorage;
import com.motiv.example.databinding.PhotosfragmentBinding;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class PhotosFragment extends Fragment {

    private PhotosfragmentBinding photosfragmentBinding;
    @Inject DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    private UsersListAdapter usersListAdapter;
    private PostsAdapter postsAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private ViewPagerFragmentsAdapter viewPagerFragmentsAdapter;
    @Inject GoApi goApi;
    @Inject AuthApi authApi;
    @Inject DaoRepository daoRepository;
    @Inject LocalStorage localStorage;
    private NavigationController navigationController;
    private LinearLayout linearlayout00;
    private ViewPager viewpager10;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidSupportInjection.inject(this);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup parent,
            @Nullable Bundle savedInstanceState) {

        photosfragmentBinding = PhotosfragmentBinding.inflate(inflater);

        usersListAdapter = new UsersListAdapter();
        postsAdapter = new PostsAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        viewPagerFragmentsAdapter =
                new ViewPagerFragmentsAdapter(
                        PhotosFragment.this.getActivity().getSupportFragmentManager());
        navigationController = new NavigationController(PhotosFragment.this.getActivity());
        linearlayout00 = photosfragmentBinding.linearlayout00;
        viewpager10 = photosfragmentBinding.viewpager10;

        viewpager10.setAdapter(photosPagerAdapter);
        goApi.getPhotos(
                new com.motiv.example.OnResponseListener<com.motiv.example.PhotosListResponse>() {
                    @Override
                    public void onSuccess(com.motiv.example.PhotosListResponse argument0) {
                        photosPagerAdapter.setData(argument0.getResult());
                    }

                    @Override
                    public void onError(Exception argument0) {}
                });

        return photosfragmentBinding.getRoot();
    }
}
