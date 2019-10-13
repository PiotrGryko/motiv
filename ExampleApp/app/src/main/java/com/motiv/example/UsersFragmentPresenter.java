package com.motiv.example;

import com.motiv.example.dao.DaoRepository;
import com.motiv.example.dao.LocalStorage;

public class UsersFragmentPresenter implements UsersFragmentContract.Presenter {

    private UsersFragmentContract.View view;
    private GoApi goApi;
    private AuthApi authApi;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;

    public UsersFragmentPresenter(
            UsersFragmentContract.View view,
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
    public void goApigetUsersList() {
        goApi.getUsersList(
                new com.motiv.example.OnResponseListener<com.motiv.example.UsersResponse>() {
                    @Override
                    public void onSuccess(com.motiv.example.UsersResponse argument0) {
                        view.usersListAdaptersetData(argument0.getResult());
                        view.showToast(argument0.getMeta().getMessage());
                    }

                    @Override
                    public void onError(Exception argument0) {
                        view.showToast("error fetching data");
                    }
                });
    }

    @Override
    public void eloonItemClick(int argument0, com.motiv.example.User argument1) {
        view.navigationControllerstartUserActivity(argument1);
    }
}
