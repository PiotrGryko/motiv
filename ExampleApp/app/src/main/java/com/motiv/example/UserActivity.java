package com.motiv.example;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.motiv.example.dao.DaoRepository;
import com.motiv.example.dao.DaoRepositoryFactory;
import com.motiv.example.dao.LocalStorage;
import com.squareup.picasso.Picasso;

public class UserActivity extends AppCompatActivity {

    private com.motiv.example.User userArgument;
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
    private ImageView imageview10;
    private TextView textview11;
    private TextView textview12;

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.useractivity);

        userArgument = com.motiv.example.User.fromJson(getIntent().getStringExtra("userArgument"));

        usersListAdapter = new UsersListAdapter();
        postsAdapter = new PostsAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        viewPagerFragmentsAdapter =
                new ViewPagerFragmentsAdapter(UserActivity.this.getSupportFragmentManager());
        daoRepository = DaoRepositoryFactory.getInstance(UserActivity.this);
        localStorage = LocalStorage.getInstance(UserActivity.this);
        navigationController = new NavigationController(UserActivity.this);
        goApi = GoApiFactory.getInstance(localStorage);
        authApi = AuthApiFactory.getInstance(localStorage);
        linearlayout00 = (LinearLayout) findViewById(R.id.linearlayout00);
        imageview10 = (ImageView) findViewById(R.id.imageview10);
        textview11 = (TextView) findViewById(R.id.textview11);
        textview12 = (TextView) findViewById(R.id.textview12);

        Picasso.with(UserActivity.this)
                .load(userArgument.getLinks().getAvatar().getHref())
                .into(imageview10);
        ;
        textview11.setText(userArgument.getFirst_name());
        textview12.setText(userArgument.getLast_name());
    }
}
