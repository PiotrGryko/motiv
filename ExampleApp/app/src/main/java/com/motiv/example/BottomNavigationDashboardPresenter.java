package com.motiv.example;

import com.motiv.example.dao.DaoRepository;
import com.motiv.example.dao.LocalStorage;

public class BottomNavigationDashboardPresenter
        implements BottomNavigationDashboardContract.Presenter {

    private BottomNavigationDashboardContract.View view;
    private GoApi goApi;
    private AuthApi authApi;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;

    public BottomNavigationDashboardPresenter(
            BottomNavigationDashboardContract.View view,
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
    public void eloonNavigationItemSelected(android.view.MenuItem argument0) {
        view.navigationControllerstartDestinationById(argument0.getItemId());
    }
}
