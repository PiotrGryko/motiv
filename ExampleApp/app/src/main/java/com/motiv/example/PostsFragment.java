package com.motiv.example;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.*;
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import com.motiv.example.dao.DaoRepository;
import com.motiv.example.dao.DaoRepositoryFactory;
import com.motiv.example.dao.LocalStorage;

public class PostsFragment extends Fragment implements PostsFragmentContract.View {

    private PostsFragmentContract.Presenter presenter;
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
    private RecyclerView recyclerview10;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup parent,
            final @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.postsfragment, parent, false);

        usersListAdapter = new UsersListAdapter();
        postsAdapter = new PostsAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        viewPagerFragmentsAdapter =
                new ViewPagerFragmentsAdapter(
                        PostsFragment.this.getActivity().getSupportFragmentManager());
        daoRepository = DaoRepositoryFactory.getInstance(PostsFragment.this.getActivity());
        localStorage = LocalStorage.getInstance(PostsFragment.this.getActivity());
        navigationController = new NavigationController(PostsFragment.this.getActivity());
        goApi = GoApiFactory.getInstance(localStorage);
        authApi = AuthApiFactory.getInstance(localStorage);
        linearlayout00 = (LinearLayout) v.findViewById(R.id.linearlayout00);
        recyclerview10 = (RecyclerView) v.findViewById(R.id.recyclerview10);
        presenter =
                new PostsFragmentPresenter(
                        PostsFragment.this, goApi, authApi, daoRepository, localStorage);

        recyclerview10.setLayoutManager(new LinearLayoutManager(PostsFragment.this.getActivity()));

        recyclerview10.setAdapter(postsAdapter);
        ;
        presenter.goApigetPostsList();
        postsAdapter.setOnItemClickListener(
                new com.motiv.example.PostsAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int argument0, com.motiv.example.Post argument1) {
                        presenter.eloonItemClick(argument0, argument1);
                    }
                });

        return v;
    }

    @Override
    public void postsAdaptersetData(java.util.List<com.motiv.example.Post> arg0) {
        postsAdapter.setData(arg0);
    }

    @Override
    public void navigationControllerstartPostDetailsActivity(java.lang.String arg0) {
        navigationController.startPostDetailsActivity(arg0);
    }
}
