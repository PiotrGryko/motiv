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

public class UsersFragment extends Fragment implements UsersFragmentContract.View {

    private UsersfragmentBinding usersfragmentBinding;
    private UsersFragmentContract.Presenter presenter;
    private UsersListAdapter usersListAdapter;
    private PostsAdapter postsAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private ViewPagerFragmentsAdapter viewPagerFragmentsAdapter;
    private GoApi goApi;
    private AuthApi authApi;
    private DaoRepository daoRepository =
            DaoRepositoryFactory.getInstance(UsersFragment.this.getActivity());
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private LinearLayout linearlayout00;
    private RecyclerView recyclerview10;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup parent,
            final @Nullable Bundle savedInstanceState) {

        usersfragmentBinding = UsersfragmentBinding.inflate(inflater);

        usersListAdapter = new UsersListAdapter();
        postsAdapter = new PostsAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        viewPagerFragmentsAdapter =
                new ViewPagerFragmentsAdapter(
                        UsersFragment.this.getActivity().getSupportFragmentManager());
        localStorage = LocalStorage.getInstance(UsersFragment.this.getActivity());
        navigationController = new NavigationController(UsersFragment.this.getActivity());
        goApi = GoApiFactory.getInstance(localStorage);
        authApi = AuthApiFactory.getInstance(localStorage);
        linearlayout00 = usersfragmentBinding.linearlayout00;
        recyclerview10 = usersfragmentBinding.recyclerview10;
        presenter =
                new UsersFragmentPresenter(
                        UsersFragment.this, goApi, authApi, daoRepository, localStorage);

        recyclerview10.setLayoutManager(new LinearLayoutManager(UsersFragment.this.getActivity()));

        recyclerview10.setAdapter(usersListAdapter);
        ;
        presenter.goApigetUsersList();
        usersListAdapter.setOnItemClickListener(
                new com.motiv.example.UsersListAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int argument0, com.motiv.example.User argument1) {
                        presenter.eloonItemClick(argument0, argument1);
                    }
                });

        return usersfragmentBinding.getRoot();
    }

    @Override
    public void usersListAdaptersetData(java.util.List<com.motiv.example.User> arg0) {
        usersListAdapter.setData(arg0);
    }

    @Override
    public void showToast(java.lang.String arg0) {
        Toast.makeText(UsersFragment.this.getActivity(), arg0, Toast.LENGTH_LONG).show();
        ;
    }

    @Override
    public void navigationControllerstartUserActivity(com.motiv.example.User arg0) {
        navigationController.startUserActivity(arg0);
    }
}
