package com.motiv.example;

import com.motiv.example.dao.DaoRepository;
import com.motiv.example.dao.LocalStorage;

public class PostDetailsActivityPresenter implements PostDetailsActivityContract.Presenter {

    private PostDetailsActivityContract.View view;
    private GoApi goApi;
    private AuthApi authApi;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;

    public PostDetailsActivityPresenter(
            PostDetailsActivityContract.View view,
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
    public void daoRepositoryloadPost(java.lang.String arg0) {
        daoRepository.loadPost(
                arg0,
                new com.motiv.example.OnResponseListener<com.motiv.example.Post>() {
                    @Override
                    public void onSuccess(com.motiv.example.Post argument0) {
                        view.textview10setText(argument0.getTitle());
                        view.textview11setText(argument0.getBody());
                    }

                    @Override
                    public void onError(Exception argument0) {}
                });
    }
}
