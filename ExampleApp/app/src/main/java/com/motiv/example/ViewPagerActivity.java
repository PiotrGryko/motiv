package com.motiv.example;

import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.*;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.motiv.example.dao.DaoRepository;
import com.motiv.example.dao.LocalStorage;
import com.motiv.example.databinding.ViewpageractivityBinding;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class ViewPagerActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    private ViewpageractivityBinding viewpageractivityBinding;
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
    private TabLayout tablayout10;
    private ViewPager viewpager11;

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {

        return dispatchingAndroidInjector;
    }

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        viewpageractivityBinding = DataBindingUtil.setContentView(this, R.layout.viewpageractivity);

        usersListAdapter = new UsersListAdapter();
        postsAdapter = new PostsAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        viewPagerFragmentsAdapter =
                new ViewPagerFragmentsAdapter(ViewPagerActivity.this.getSupportFragmentManager());
        navigationController = new NavigationController(ViewPagerActivity.this);
        linearlayout00 = viewpageractivityBinding.linearlayout00;
        tablayout10 = viewpageractivityBinding.tablayout10;
        viewpager11 = viewpageractivityBinding.viewpager11;

        viewpager11.setAdapter(viewPagerFragmentsAdapter);
        tablayout10.setupWithViewPager(viewpager11);
    }
}
