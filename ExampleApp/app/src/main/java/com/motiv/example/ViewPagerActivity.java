package com.motiv.example;

import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.motiv.example.dao.DaoRepository;
import com.motiv.example.dao.LocalStorage;

public class ViewPagerActivity extends AppCompatActivity implements ViewPagerActivityContract.View {

    private ViewPagerActivityContract.Presenter presenter;
    private UsersListAdapter usersListAdapter;
    private PostsAdapter postsAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private ViewPagerFragmentsAdapter viewPagerFragmentsAdapter;
    private GoApi goApi;
    private AuthApi authApi;
    private DaoRepository daoRepository = DaoRepositoryFactory.getInstance(ViewPagerActivity.this);
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private LinearLayout linearlayout00;
    private TabLayout tablayout10;
    private ViewPager viewpager11;

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpageractivity);

        usersListAdapter = new UsersListAdapter();
        postsAdapter = new PostsAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        viewPagerFragmentsAdapter =
                new ViewPagerFragmentsAdapter(ViewPagerActivity.this.getSupportFragmentManager());
        localStorage = LocalStorage.getInstance(ViewPagerActivity.this);
        navigationController = new NavigationController(ViewPagerActivity.this);
        goApi = GoApiFactory.getInstance(localStorage);
        authApi = AuthApiFactory.getInstance(localStorage);
        linearlayout00 = (LinearLayout) findViewById(R.id.linearlayout00);
        tablayout10 = (TabLayout) findViewById(R.id.tablayout10);
        viewpager11 = (ViewPager) findViewById(R.id.viewpager11);

        presenter =
                new ViewPagerActivityPresenter(
                        ViewPagerActivity.this, goApi, authApi, daoRepository, localStorage);

        viewpager11.setAdapter(viewPagerFragmentsAdapter);
        tablayout10.setupWithViewPager(viewpager11);
    }
}
