package com.motiv.example;

import com.motiv.example.dao.DaoRepository;
import com.motiv.example.dao.LocalStorage;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private MainActivityContract.View view;
    private GoApi goApi;
    private AuthApi authApi;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;

    public MainActivityPresenter(
            MainActivityContract.View view,
            GoApi goApi,
            AuthApi authApi,
            DaoRepository daoRepository,
            LocalStorage localStorage) {
        this.view = view;
        this.goApi = goApi;
        this.authApi = authApi;
        this.daoRepository = daoRepository;
        this.localStorage = localStorage;
    }

    @Override
    public void eloonClick(android.view.View argument0) {
        authApi.getToken(
                new com.motiv.example.OnResponseListener<com.motiv.example.AuthToken>() {
                    @Override
                    public void onSuccess(com.motiv.example.AuthToken argument0) {
                        localStorage.putString("token", argument0.getToken());
                        goApi.getUser(
                                view.edittext10getText().toString(),
                                new com.motiv.example.OnResponseListener<
                                        com.motiv.example.UserResponse>() {
                                    @Override
                                    public void onSuccess(
                                            com.motiv.example.UserResponse argument0) {
                                        view.showToast(argument0.getMeta().getMessage());
                                        view.navigationControllerstartDrawerDashboard(
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
}
