package com.motiv.example;

import com.motiv.example.dao.DaoRepository;
import com.motiv.example.dao.LocalStorage;

public class PostsFragmentPresenter implements PostsFragmentContract.Presenter {

    private PostsFragmentContract.View view;
    private GoApi goApi;
    private AuthApi authApi;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;

    public PostsFragmentPresenter(
            PostsFragmentContract.View view,
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
    public void goApigetPostsList() {
        goApi.getPostsList(
                new com.motiv.example.OnResponseListener<com.motiv.example.PostsListResponse>() {
                    @Override
                    public void onSuccess(com.motiv.example.PostsListResponse argument0) {
                        daoRepository.savePosts(
                                argument0.getResult(),
                                new com.motiv.example.OnResponseListener<
                                        java.util.List<com.motiv.example.Post>>() {
                                    @Override
                                    public void onSuccess(
                                            java.util.List<com.motiv.example.Post> argument0) {
                                        view.postsAdaptersetData(argument0);
                                    }

                                    @Override
                                    public void onError(Exception argument0) {}
                                });
                    }

                    @Override
                    public void onError(Exception argument0) {}
                });
    }

    @Override
    public void eloonItemClick(int argument0, com.motiv.example.Post argument1) {
        view.navigationControllerstartPostDetailsActivity(argument1.getId());
    }
}
