package com.motiv.example;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.*;
import com.bumptech.glide.Glide;
import com.motiv.example.dao.DaoRepository;
import com.motiv.example.dao.LocalStorage;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class UserActivity extends AppCompatActivity
        implements UserActivityContract.View, HasSupportFragmentInjector {

    @Inject DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    private com.motiv.example.User userArgument;
    private UserActivityContract.Presenter presenter;
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
    private ImageView imageview10;
    private TextView textview11;
    private TextView textview12;

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {

        return dispatchingAndroidInjector;
    }

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.useractivity);

        userArgument = com.motiv.example.User.fromJson(getIntent().getStringExtra("userArgument"));

        usersListAdapter = new UsersListAdapter();
        postsAdapter = new PostsAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        viewPagerFragmentsAdapter =
                new ViewPagerFragmentsAdapter(UserActivity.this.getSupportFragmentManager());
        navigationController = new NavigationController(UserActivity.this);
        linearlayout00 = (LinearLayout) findViewById(R.id.linearlayout00);
        imageview10 = (ImageView) findViewById(R.id.imageview10);
        textview11 = (TextView) findViewById(R.id.textview11);
        textview12 = (TextView) findViewById(R.id.textview12);

        presenter =
                new UserActivityPresenter(
                        UserActivity.this, goApi, authApi, daoRepository, localStorage);

        Glide.with(UserActivity.this)
                .load(userArgument.getLinks().getAvatar().getHref())
                .into(imageview10);
        ;
        textview11.setText(userArgument.getFirst_name());
        textview12.setText(userArgument.getLast_name());
    }
}
