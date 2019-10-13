package com.motiv.example;

import androidx.fragment.app.*;
import com.motiv.example.dao.DaoRepository;
import com.motiv.example.dao.LocalStorage;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class PhotosFragmentPresenter implements PhotosFragmentContract.Presenter {

    private PhotosFragmentContract.View view;
    private GoApi goApi;
    private AuthApi authApi;
    private DaoRepository daoRepository;
    private LocalStorage localStorage;

    public PhotosFragmentPresenter(
            PhotosFragmentContract.View view,
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
    public void goApigetPhotos() {
        goApi.getPhotos(
                new com.motiv.example.OnResponseListener<com.motiv.example.PhotosListResponse>() {
                    @Override
                    public void onSuccess(com.motiv.example.PhotosListResponse argument0) {
                        view.photosPagerAdaptersetData(argument0.getResult());
                    }

                    @Override
                    public void onError(Exception argument0) {}
                });
    }
}
