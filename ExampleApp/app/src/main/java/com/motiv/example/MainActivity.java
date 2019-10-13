package com.motiv.example;

import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.motiv.example.dao.DaoRepository;
import com.motiv.example.dao.LocalStorage;

public class MainActivity extends AppCompatActivity {

    private UsersListAdapter usersListAdapter;
    private PostsAdapter postsAdapter;
    private PhotosPagerAdapter photosPagerAdapter;
    private ViewPagerFragmentsAdapter viewPagerFragmentsAdapter;
    private GoApi goApi;
    private AuthApi authApi;
    private DaoRepository daoRepository = DaoRepositoryFactory.getInstance(MainActivity.this);
    private LocalStorage localStorage;
    private NavigationController navigationController;
    private LinearLayout linearlayout00;
    private EditText edittext10;
    private Button button11;

    @Override
    protected void onCreate(@Nullable android.os.Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        usersListAdapter = new UsersListAdapter();
        postsAdapter = new PostsAdapter();
        photosPagerAdapter = new PhotosPagerAdapter();
        viewPagerFragmentsAdapter =
                new ViewPagerFragmentsAdapter(MainActivity.this.getSupportFragmentManager());
        localStorage = LocalStorage.getInstance(MainActivity.this);
        navigationController = new NavigationController(MainActivity.this);
        goApi = GoApiFactory.getInstance(localStorage);
        authApi = AuthApiFactory.getInstance(localStorage);
        linearlayout00 = (LinearLayout) findViewById(R.id.linearlayout00);
        edittext10 = (EditText) findViewById(R.id.edittext10);
        button11 = (Button) findViewById(R.id.button11);

        button11.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View argument0) {
                        authApi.getToken(
                                new com.motiv.example.OnResponseListener<
                                        com.motiv.example.AuthToken>() {
                                    @Override
                                    public void onSuccess(com.motiv.example.AuthToken argument0) {
                                        localStorage.putString("token", argument0.getToken());
                                        goApi.getUser(
                                                edittext10.getText().toString(),
                                                new com.motiv.example.OnResponseListener<
                                                        com.motiv.example.UserResponse>() {
                                                    @Override
                                                    public void onSuccess(
                                                            com.motiv.example.UserResponse
                                                                    argument0) {
                                                        Toast.makeText(
                                                                        MainActivity.this,
                                                                        argument0
                                                                                .getMeta()
                                                                                .getMessage(),
                                                                        Toast.LENGTH_LONG)
                                                                .show();
                                                        ;
                                                        navigationController.startDrawerDashboard(
                                                                argument0.getResult());
                                                    }

                                                    @Override
                                                    public void onError(Exception argument0) {}
                                                });
                                    }

                                    @Override
                                    public void onError(Exception argument0) {}
                                });
                    }
                });
    }
}
