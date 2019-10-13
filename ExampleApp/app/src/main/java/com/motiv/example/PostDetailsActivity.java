package com.motiv.example;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.motiv.example.dao.DaoRepository;
import com.motiv.example.dao.LocalStorage;

public class PostDetailsActivity extends AppCompatActivity
        implements PostDetailsActivityContract.View {

    private java.lang.String postId;
    private PostDetailsActivityContract.Presenter presenter;
    private UsersListAdapter usersListAdapter;
    private PostsAdapter postsAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private ViewPagerFragmentsAdapter viewPagerFragmentsAdapter;
    private GoApi goApi;
    private AuthApi authApi;
    private DaoRepository daoRepository =
            DaoRepositoryFactory.getInstance(PostDetailsActivity.this);
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private LinearLayout linearlayout00;
    private TextView textview10;
    private TextView textview11;

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.postdetailsactivity);

        String postId = getIntent().getStringExtra("postId");

        usersListAdapter = new UsersListAdapter();
        postsAdapter = new PostsAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        viewPagerFragmentsAdapter =
                new ViewPagerFragmentsAdapter(PostDetailsActivity.this.getSupportFragmentManager());
        localStorage = LocalStorage.getInstance(PostDetailsActivity.this);
        navigationController = new NavigationController(PostDetailsActivity.this);
        goApi = GoApiFactory.getInstance(localStorage);
        authApi = AuthApiFactory.getInstance(localStorage);
        linearlayout00 = (LinearLayout) findViewById(R.id.linearlayout00);
        textview10 = (TextView) findViewById(R.id.textview10);
        textview11 = (TextView) findViewById(R.id.textview11);

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
