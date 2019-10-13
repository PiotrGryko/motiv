package com.motiv.example;

import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.motiv.example.dao.DaoRepository;
import com.motiv.example.dao.DaoRepositoryFactory;
import com.motiv.example.dao.LocalStorage;
import com.motiv.example.databinding.MainactivityBinding;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    private MainactivityBinding mainactivityBinding;
    private MainActivityContract.Presenter presenter;
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
    private EditText edittext10;
    private Button button11;

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mainactivityBinding = DataBindingUtil.setContentView(this, R.layout.mainactivity);

        usersListAdapter = new UsersListAdapter();
        postsAdapter = new PostsAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        viewPagerFragmentsAdapter =
                new ViewPagerFragmentsAdapter(MainActivity.this.getSupportFragmentManager());
        daoRepository = DaoRepositoryFactory.getInstance(MainActivity.this);
        localStorage = LocalStorage.getInstance(MainActivity.this);
        navigationController = new NavigationController(MainActivity.this);
        goApi = GoApiFactory.getInstance(localStorage);
        authApi = AuthApiFactory.getInstance(localStorage);
        linearlayout00 = mainactivityBinding.linearlayout00;
        edittext10 = mainactivityBinding.edittext10;
        button11 = mainactivityBinding.button11;

        presenter =
                new MainActivityPresenter(
                        MainActivity.this, goApi, authApi, daoRepository, localStorage);

        button11.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View argument0) {
                        presenter.eloonClick(argument0);
                    }
                });
    }

    @Override
    public java.lang.CharSequence edittext10getText() {
        return edittext10.getText().toString();
    }

    @Override
    public void showToast(java.lang.String arg0) {
        Toast.makeText(MainActivity.this, arg0, Toast.LENGTH_LONG).show();
        ;
    }

    @Override
    public void navigationControllerstartDrawerDashboard(com.motiv.example.User arg0) {
        navigationController.startDrawerDashboard(arg0);
    }
}
