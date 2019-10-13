package com.motiv.example;

import com.motiv.example.dao.DaoRepository;
import com.motiv.example.dao.LocalStorage;

public class DrawerDashboardPresenter implements DrawerDashboardContract.Presenter {

    private DrawerDashboardContract.View view;
    private GoApi goApi;
    private AuthApi authApi;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;

    public DrawerDashboardPresenter(
            DrawerDashboardContract.View view,
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
        view.navigationControllerstartUserActivity(view.getuser());
    }

    @Override
    public void eloonNavigationItemSelected(android.view.MenuItem argument0) {
        view.navigationControllerstartDestinationById(argument0.getItemId());
    }
}
