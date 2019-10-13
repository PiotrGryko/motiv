package com.motiv.example;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.*;
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import com.motiv.example.dao.DaoRepository;
import com.motiv.example.dao.LocalStorage;
import com.motiv.example.databinding.UsersfragmentBinding;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class UsersFragment extends Fragment {

    private UsersfragmentBinding usersfragmentBinding;
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
    private RecyclerView recyclerview10;

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

        usersfragmentBinding = UsersfragmentBinding.inflate(inflater);

        usersListAdapter = new UsersListAdapter();
        postsAdapter = new PostsAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        viewPagerFragmentsAdapter =
                new ViewPagerFragmentsAdapter(
                        UsersFragment.this.getActivity().getSupportFragmentManager());
        navigationController = new NavigationController(UsersFragment.this.getActivity());
        linearlayout00 = usersfragmentBinding.linearlayout00;
        recyclerview10 = usersfragmentBinding.recyclerview10;

        recyclerview10.setLayoutManager(new LinearLayoutManager(UsersFragment.this.getActivity()));

        recyclerview10.setAdapter(usersListAdapter);
        ;
        goApi.getUsersList(
                new com.motiv.example.OnResponseListener<com.motiv.example.UsersResponse>() {
                    @Override
                    public void onSuccess(com.motiv.example.UsersResponse argument0) {
                        usersListAdapter.setData(argument0.getResult());
                        Toast.makeText(
                                        UsersFragment.this.getActivity(),
                                        argument0.getMeta().getMessage(),
                                        Toast.LENGTH_LONG)
                                .show();
                        ;
                    }

                    @Override
                    public void onError(Exception argument0) {
                        Toast.makeText(
                                        UsersFragment.this.getActivity(),
                                        "error fetching data",
                                        Toast.LENGTH_LONG)
                                .show();
                        ;
                    }
                });
        usersListAdapter.setOnItemClickListener(
                new com.motiv.example.UsersListAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int argument0, com.motiv.example.User argument1) {
                        navigationController.startUserActivity(argument1);
                    }
                });

        return usersfragmentBinding.getRoot();
    }
}
