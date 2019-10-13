package com.motiv.example;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

public class NavigationController {

    private Activity context;
    private View view;
    private static NavigationController instance;

    public NavigationController(Activity context) {
        this.context = context;
        this.view = context.findViewById(R.id.nav_host_fragment);
    }

    public void startDrawerDashboard(com.motiv.example.User user) {

        Intent intent = new Intent(context, DrawerDashboard.class);
        intent.putExtra("user", com.motiv.example.User.toJson(user));

        context.startActivity(intent);
    }

    public void startUserActivity(com.motiv.example.User userArgument) {

        Intent intent = new Intent(context, UserActivity.class);
        intent.putExtra("userArgument", com.motiv.example.User.toJson(userArgument));

        context.startActivity(intent);
    }

    public void startUsersFragment() {
        Navigation.findNavController(view).navigate(R.id.UsersFragment);
    }

    public void startPostsFragment() {
        Navigation.findNavController(view).navigate(R.id.PostsFragment);
    }

    public void startPostDetailsActivity(java.lang.String postId) {

        Intent intent = new Intent(context, PostDetailsActivity.class);
        intent.putExtra("postId", postId);

        context.startActivity(intent);
    }

    public void startPhotosFragment() {
        Navigation.findNavController(view).navigate(R.id.PhotosFragment);
    }

    public void startBottomNavigationDashboard() {

        Intent intent = new Intent(context, BottomNavigationDashboard.class);

        context.startActivity(intent);
    }

    public void startViewPagerActivity() {

        Intent intent = new Intent(context, ViewPagerActivity.class);

        context.startActivity(intent);
    }

    public void startDestinationById(@Nullable int id) {

        if (id == R.id.BottomNavigationDashboard) {
            Intent intent = new Intent(context, BottomNavigationDashboard.class);
            context.startActivity(intent);
        }

        if (id == R.id.ViewPagerActivity) {
            Intent intent = new Intent(context, ViewPagerActivity.class);
            context.startActivity(intent);
        }

        if (id == R.id.UsersFragment) {
            Navigation.findNavController(view).navigate(R.id.UsersFragment);
        }

        if (id == R.id.PostsFragment) {
            Navigation.findNavController(view).navigate(R.id.PostsFragment);
        }

        if (id == R.id.PhotosFragment) {
            Navigation.findNavController(view).navigate(R.id.PhotosFragment);
        }
    }
}
