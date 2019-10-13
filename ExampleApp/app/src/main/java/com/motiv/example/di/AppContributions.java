package com.motiv.example.di;

import androidx.fragment.app.*;
import com.motiv.example.BottomNavigationDashboard;
import com.motiv.example.DrawerDashboard;
import com.motiv.example.MainActivity;
import com.motiv.example.PhotosFragment;
import com.motiv.example.PostDetailsActivity;
import com.motiv.example.PostsFragment;
import com.motiv.example.UserActivity;
import com.motiv.example.UsersFragment;
import com.motiv.example.ViewPagerActivity;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

@Module
public abstract class AppContributions {

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector
    abstract DrawerDashboard contributeDrawerDashboard();

    @ContributesAndroidInjector
    abstract UserActivity contributeUserActivity();

    @ContributesAndroidInjector
    abstract PostDetailsActivity contributePostDetailsActivity();

    @ContributesAndroidInjector
    abstract BottomNavigationDashboard contributeBottomNavigationDashboard();

    @ContributesAndroidInjector
    abstract ViewPagerActivity contributeViewPagerActivity();

    @ContributesAndroidInjector
    abstract UsersFragment contributeUsersFragment();

    @ContributesAndroidInjector
    abstract PostsFragment contributePostsFragment();

    @ContributesAndroidInjector
    abstract PhotosFragment contributePhotosFragment();
}
