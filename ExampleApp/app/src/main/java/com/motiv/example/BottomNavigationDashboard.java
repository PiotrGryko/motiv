package com.motiv.example;

import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.motiv.example.dao.DaoRepository;
import com.motiv.example.dao.LocalStorage;
import com.motiv.example.databinding.BottomnavigationdashboardBinding;

public class BottomNavigationDashboard extends AppCompatActivity {

    private BottomnavigationdashboardBinding bottomnavigationdashboardBinding;
    private UsersListAdapter usersListAdapter;
    private PostsAdapter postsAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private ViewPagerFragmentsAdapter viewPagerFragmentsAdapter;
    private GoApi goApi;
    private AuthApi authApi;
    private DaoRepository daoRepository =
            DaoRepositoryFactory.getInstance(BottomNavigationDashboard.this);
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private RelativeLayout relativelayout00;
    private BottomNavigationView bottomnavigationview11;

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        bottomnavigationdashboardBinding =
                DataBindingUtil.setContentView(this, R.layout.bottomnavigationdashboard);

        usersListAdapter = new UsersListAdapter();
        postsAdapter = new PostsAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        viewPagerFragmentsAdapter =
                new ViewPagerFragmentsAdapter(
                        BottomNavigationDashboard.this.getSupportFragmentManager());
        localStorage = LocalStorage.getInstance(BottomNavigationDashboard.this);
        navigationController = new NavigationController(BottomNavigationDashboard.this);
        goApi = GoApiFactory.getInstance(localStorage);
        authApi = AuthApiFactory.getInstance(localStorage);
        relativelayout00 = bottomnavigationdashboardBinding.relativelayout00;
        bottomnavigationview11 = bottomnavigationdashboardBinding.bottomnavigationview11;

        bottomnavigationview11.setOnNavigationItemSelectedListener(
                new com.google.android.material.bottomnavigation.BottomNavigationView
                        .OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(android.view.MenuItem argument0) {
                        navigationController.startDestinationById(argument0.getItemId());

                        return false;
                    }
                });
    }
}
