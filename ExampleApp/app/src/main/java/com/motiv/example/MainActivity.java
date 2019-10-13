package com.motiv.example;

import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.*;
import com.motiv.example.dao.DaoRepository;
import com.motiv.example.dao.LocalStorage;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class MainActivity extends AppCompatActivity
        implements MainActivityContract.View, HasSupportFragmentInjector {

    @Inject DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    private MainActivityContract.Presenter presenter;
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
    private EditText edittext10;
    private Button button11;

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {

        return dispatchingAndroidInjector;
    }

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        usersListAdapter = new UsersListAdapter();
        postsAdapter = new PostsAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        viewPagerFragmentsAdapter =
                new ViewPagerFragmentsAdapter(MainActivity.this.getSupportFragmentManager());
        navigationController = new NavigationController(MainActivity.this);
        linearlayout00 = (LinearLayout) findViewById(R.id.linearlayout00);
        edittext10 = (EditText) findViewById(R.id.edittext10);
        button11 = (Button) findViewById(R.id.button11);

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
