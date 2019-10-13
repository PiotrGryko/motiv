package com.motiv.example;

import androidx.fragment.app.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class ViewPagerFragmentsAdapter extends FragmentStatePagerAdapter {

    public ViewPagerFragmentsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {

        return 3;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new UsersFragment();
            case 1:
                return new PostsFragment();
            case 2:
                return new PhotosFragment();
        }
        throw new RuntimeException();
    }

    @Override
    public java.lang.String getPageTitle(int position) {

        switch (position) {
            case 0:
                return "UsersFragment";
            case 1:
                return "PostsFragment";
            case 2:
                return "PhotosFragment";
        }
        return "";
    }
}
