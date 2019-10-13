package com.motiv.example;

import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.motiv.example.dao.DaoRepository;
import com.motiv.example.dao.LocalStorage;
import com.motiv.example.databinding.BottomnavigationdashboardBinding;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class BottomNavigationDashboard extends AppCompatActivity
        implements BottomNavigationDashboardContract.View, HasSupportFragmentInjector {

    private BottomnavigationdashboardBinding bottomnavigationdashboardBinding;
    @Inject DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    private BottomNavigationDashboardContract.Presenter presenter;
    private UsersListAdapter usersListAdapter;
    private PostsAdapter postsAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private ViewPagerFragmentsAdapter viewPagerFragmentsAdapter;
    @Inject GoApi goApi;
    @Inject AuthApi authApi;
    @Inject DaoRepository daoRepository;
    @Inject LocalStorage localStorage;
    private NavigationController navigationController;
    private RelativeLayout relativelayout00;
    private BottomNavigationView bottomnavigationview11;

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {

        return dispatchingAndroidInjector;
    }

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        bottomnavigationdashboardBinding =
                DataBindingUtil.setContentView(this, R.layout.bottomnavigationdashboard);

        usersListAdapter = new UsersListAdapter();
        postsAdapter = new PostsAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        viewPagerFragmentsAdapter =
                new ViewPagerFragmentsAdapter(
                        BottomNavigationDashboard.this.getSupportFragmentManager());
        navigationController = new NavigationController(BottomNavigationDashboard.this);
        relativelayout00 = bottomnavigationdashboardBinding.relativelayout00;
        bottomnavigationview11 = bottomnavigationdashboardBinding.bottomnavigationview11;

        presenter =
                new BottomNavigationDashboardPresenter(
                        BottomNavigationDashboard.this,
                        goApi,
                        authApi,
                        daoRepository,
                        localStorage);

        bottomnavigationview11.setOnNavigationItemSelectedListener(
                new com.google.android.material.bottomnavigation.BottomNavigationView
                        .OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(android.view.MenuItem argument0) {
                        presenter.eloonNavigationItemSelected(argument0);

                        return false;
                    }
                });
    }

    @Override
    public void navigationControllerstartDestinationById(int arg0) {
        navigationController.startDestinationById(arg0);
    }
}
