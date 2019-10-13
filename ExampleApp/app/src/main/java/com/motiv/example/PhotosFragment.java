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
import com.motiv.example.dao.DaoRepositoryFactory;
import com.motiv.example.dao.LocalStorage;

public class PhotosFragment extends Fragment {

    private UsersListAdapter usersListAdapter;
    private PostsAdapter postsAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private ViewPagerFragmentsAdapter viewPagerFragmentsAdapter;
    private GoApi goApi;
    private AuthApi authApi;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private LinearLayout linearlayout00;
    private ViewPager viewpager10;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup parent,
            @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.photosfragment, parent, false);

        usersListAdapter = new UsersListAdapter();
        postsAdapter = new PostsAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        viewPagerFragmentsAdapter =
                new ViewPagerFragmentsAdapter(
                        PhotosFragment.this.getActivity().getSupportFragmentManager());
        daoRepository = DaoRepositoryFactory.getInstance(PhotosFragment.this.getActivity());
        localStorage = LocalStorage.getInstance(PhotosFragment.this.getActivity());
        navigationController = new NavigationController(PhotosFragment.this.getActivity());
        goApi = GoApiFactory.getInstance(localStorage);
        authApi = AuthApiFactory.getInstance(localStorage);
        linearlayout00 = (LinearLayout) v.findViewById(R.id.linearlayout00);
        viewpager10 = (ViewPager) v.findViewById(R.id.viewpager10);

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

        return v;
    }
}
