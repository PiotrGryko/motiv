package com.motiv.example;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.*;
import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.motiv.example.dao.DaoRepository;
import com.motiv.example.dao.LocalStorage;
import com.motiv.example.databinding.DrawerdashboardBinding;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class DrawerDashboard extends AppCompatActivity implements HasSupportFragmentInjector {

    private DrawerdashboardBinding drawerdashboardBinding;
    @Inject DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    private com.motiv.example.User user;
    private UsersListAdapter usersListAdapter;
    private PostsAdapter postsAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private ViewPagerFragmentsAdapter viewPagerFragmentsAdapter;
    @Inject GoApi goApi;
    @Inject AuthApi authApi;
    @Inject DaoRepository daoRepository;
    @Inject LocalStorage localStorage;
    private NavigationController navigationController;
    private DrawerLayout drawerlayout00;
    private NavigationView navigationview11;
    private LinearLayout headerlinearlayout00;
    private ImageView headerimageview10;
    private TextView headertextview11;

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {

        return dispatchingAndroidInjector;
    }

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        drawerdashboardBinding = DataBindingUtil.setContentView(this, R.layout.drawerdashboard);

        user = com.motiv.example.User.fromJson(getIntent().getStringExtra("user"));

        usersListAdapter = new UsersListAdapter();
        postsAdapter = new PostsAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        viewPagerFragmentsAdapter =
                new ViewPagerFragmentsAdapter(DrawerDashboard.this.getSupportFragmentManager());
        navigationController = new NavigationController(DrawerDashboard.this);
        drawerlayout00 = drawerdashboardBinding.drawerlayout00;
        navigationview11 = drawerdashboardBinding.navigationview11;
        headerlinearlayout00 =
                (LinearLayout) navigationview11.getHeaderView(0).findViewById(R.id.linearlayout00);
        headerimageview10 =
                (ImageView) navigationview11.getHeaderView(0).findViewById(R.id.imageview10);
        headertextview11 =
                (TextView) navigationview11.getHeaderView(0).findViewById(R.id.textview11);

        headertextview11.setText(user.getFirst_name());
        Glide.with(DrawerDashboard.this)
                .load(user.getLinks().getAvatar().getHref())
                .into(headerimageview10);
        ;
        headerlinearlayout00.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View argument0) {
                        navigationController.startUserActivity(user);
                    }
                });
        navigationview11.setNavigationItemSelectedListener(
                new com.google.android.material.navigation.NavigationView
                        .OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(android.view.MenuItem argument0) {
                        navigationController.startDestinationById(argument0.getItemId());

                        return false;
                    }
                });
    }
}
