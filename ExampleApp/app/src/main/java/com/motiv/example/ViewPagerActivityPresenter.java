package com.motiv.example;

import com.motiv.example.dao.DaoRepository;
import com.motiv.example.dao.LocalStorage;

public class ViewPagerActivityPresenter implements ViewPagerActivityContract.Presenter {

    private ViewPagerActivityContract.View view;
    private GoApi goApi;
    private AuthApi authApi;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;

    public ViewPagerActivityPresenter(
            ViewPagerActivityContract.View view,
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
}
