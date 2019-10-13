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
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class PhotosFragment extends Fragment implements PhotosFragmentContract.View {

    @Inject DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    private PhotosFragmentContract.Presenter presenter;
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
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup parent,
            final @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.photosfragment, parent, false);

        usersListAdapter = new UsersListAdapter();
        postsAdapter = new PostsAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        viewPagerFragmentsAdapter =
                new ViewPagerFragmentsAdapter(
                        PhotosFragment.this.getActivity().getSupportFragmentManager());
        navigationController = new NavigationController(PhotosFragment.this.getActivity());
        linearlayout00 = (LinearLayout) v.findViewById(R.id.linearlayout00);
        viewpager10 = (ViewPager) v.findViewById(R.id.viewpager10);
        presenter =
                new PhotosFragmentPresenter(
                        PhotosFragment.this, goApi, authApi, daoRepository, localStorage);

        viewpager10.setAdapter(photosPagerAdapter);
        presenter.goApigetPhotos();

        return v;
    }

    @Override
    public void photosPagerAdaptersetData(java.util.List<com.motiv.example.Photo> arg0) {
        photosPagerAdapter.setData(arg0);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidSupportInjection.inject(this);
    }
}
