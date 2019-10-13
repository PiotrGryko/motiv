package com.motiv.example;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.motiv.example.dao.DaoRepository;
import com.motiv.example.dao.DaoRepositoryFactory;
import com.motiv.example.dao.LocalStorage;
import com.motiv.example.databinding.PostdetailsactivityBinding;

public class PostDetailsActivity extends AppCompatActivity
        implements PostDetailsActivityContract.View {

    private PostdetailsactivityBinding postdetailsactivityBinding;
    private java.lang.String postId;
    private PostDetailsActivityContract.Presenter presenter;
    private UsersListAdapter usersListAdapter;
    private PostsAdapter postsAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private ViewPagerFragmentsAdapter viewPagerFragmentsAdapter;
    private GoApi goApi;
    private AuthApi authApi;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private LinearLayout linearlayout00;
    private TextView textview10;
    private TextView textview11;

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        postdetailsactivityBinding =
                DataBindingUtil.setContentView(this, R.layout.postdetailsactivity);

        String postId = getIntent().getStringExtra("postId");

        usersListAdapter = new UsersListAdapter();
        postsAdapter = new PostsAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        viewPagerFragmentsAdapter =
                new ViewPagerFragmentsAdapter(PostDetailsActivity.this.getSupportFragmentManager());
        daoRepository = DaoRepositoryFactory.getInstance(PostDetailsActivity.this);
        localStorage = LocalStorage.getInstance(PostDetailsActivity.this);
        navigationController = new NavigationController(PostDetailsActivity.this);
        goApi = GoApiFactory.getInstance(localStorage);
        authApi = AuthApiFactory.getInstance(localStorage);
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
