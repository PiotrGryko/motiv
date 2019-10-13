package com.motiv.example;

import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.motiv.example.dao.DaoRepository;
import com.motiv.example.dao.DaoRepositoryFactory;
import com.motiv.example.dao.LocalStorage;

public class BottomNavigationDashboard extends AppCompatActivity {

    private UsersListAdapter usersListAdapter;
    private PostsAdapter postsAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private ViewPagerFragmentsAdapter viewPagerFragmentsAdapter;
    private GoApi goApi;
    private AuthApi authApi;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private RelativeLayout relativelayout00;
    private BottomNavigationView bottomnavigationview11;

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottomnavigationdashboard);

        usersListAdapter = new UsersListAdapter();
        postsAdapter = new PostsAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        viewPagerFragmentsAdapter =
                new ViewPagerFragmentsAdapter(
                        BottomNavigationDashboard.this.getSupportFragmentManager());
        daoRepository = DaoRepositoryFactory.getInstance(BottomNavigationDashboard.this);
        localStorage = LocalStorage.getInstance(BottomNavigationDashboard.this);
        navigationController = new NavigationController(BottomNavigationDashboard.this);
        goApi = GoApiFactory.getInstance(localStorage);
        authApi = AuthApiFactory.getInstance(localStorage);
        relativelayout00 = (RelativeLayout) findViewById(R.id.relativelayout00);
        bottomnavigationview11 = (BottomNavigationView) findViewById(R.id.bottomnavigationview11);

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
