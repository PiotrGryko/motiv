package com.motiv.example;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.*;
import com.motiv.example.dao.DaoRepository;
import com.motiv.example.dao.LocalStorage;
import com.motiv.example.databinding.PostdetailsactivityBinding;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class PostDetailsActivity extends AppCompatActivity
        implements PostDetailsActivityContract.View, HasSupportFragmentInjector {

    private PostdetailsactivityBinding postdetailsactivityBinding;
    @Inject DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    private java.lang.String postId;
    private PostDetailsActivityContract.Presenter presenter;
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
    private TextView textview10;
    private TextView textview11;

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {

        return dispatchingAndroidInjector;
    }

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        postdetailsactivityBinding =
                DataBindingUtil.setContentView(this, R.layout.postdetailsactivity);

        String postId = getIntent().getStringExtra("postId");

        usersListAdapter = new UsersListAdapter();
        postsAdapter = new PostsAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        viewPagerFragmentsAdapter =
                new ViewPagerFragmentsAdapter(PostDetailsActivity.this.getSupportFragmentManager());
        navigationController = new NavigationController(PostDetailsActivity.this);
        linearlayout00 = postdetailsactivityBinding.linearlayout00;
        textview10 = postdetailsactivityBinding.textview10;
        textview11 = postdetailsactivityBinding.textview11;

        presenter =
                new PostDetailsActivityPresenter(
                        PostDetailsActivity.this, goApi, authApi, daoRepository, localStorage);

        presenter.daoRepositoryloadPost(postId);
    }

    @Override
    public void textview10setText(java.lang.CharSequence arg0) {
        textview10.setText(arg0);
    }

    @Override
    public void textview11setText(java.lang.CharSequence arg0) {
        textview11.setText(arg0);
    }
}
