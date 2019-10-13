package com.motiv.example;

import androidx.fragment.app.*;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;
import retrofit2.*;
import retrofit2.http.*;

public class GoApi {

    private static GoApiApi goApiApi;

    public GoApi(GoApiApi goApiApi) {
        this.goApiApi = goApiApi;
    }

    public void getUser(
            java.lang.String userId,
            final com.motiv.example.OnResponseListener<com.motiv.example.UserResponse>
                    onResponseListener) {

        goApiApi.getUser(userId)
                .enqueue(
                        new Callback<com.motiv.example.UserResponse>() {
                            @Override
                            public void onResponse(
                                    Call<com.motiv.example.UserResponse> call,
                                    retrofit2.Response<com.motiv.example.UserResponse> response) {

                                onResponseListener.onSuccess(response.body());
                            }

                            @Override
                            public void onFailure(
                                    Call<com.motiv.example.UserResponse> call, Throwable t) {
                                onResponseListener.onError(new Exception(t.getMessage()));
                            }
                        });
    }

    public void getUsersList(
            final com.motiv.example.OnResponseListener<com.motiv.example.UsersResponse>
                    onResponseListener) {
        goApiApi.getUsersList()
                .enqueue(
                        new Callback<com.motiv.example.UsersResponse>() {
                            @Override
                            public void onResponse(
                                    Call<com.motiv.example.UsersResponse> call,
                                    retrofit2.Response<com.motiv.example.UsersResponse> response) {

                                onResponseListener.onSuccess(response.body());
                            }

                            @Override
                            public void onFailure(
                                    Call<com.motiv.example.UsersResponse> call, Throwable t) {

                                onResponseListener.onError(new Exception(t.getMessage()));
                            }
                        });
    }

    public void getPostsList(
            final com.motiv.example.OnResponseListener<com.motiv.example.PostsListResponse>
                    onResponseListener) {
        goApiApi.getPostsList()
                .enqueue(
                        new Callback<com.motiv.example.PostsListResponse>() {
                            @Override
                            public void onResponse(
                                    Call<com.motiv.example.PostsListResponse> call,
                                    retrofit2.Response<com.motiv.example.PostsListResponse>
                                            response) {

                                onResponseListener.onSuccess(response.body());
                            }

                            @Override
                            public void onFailure(
                                    Call<com.motiv.example.PostsListResponse> call, Throwable t) {

                                onResponseListener.onError(new Exception(t.getMessage()));
                            }
                        });
    }

    public void getPhotos(
            final com.motiv.example.OnResponseListener<com.motiv.example.PhotosListResponse>
                    onResponseListener) {
        goApiApi.getPhotos()
                .enqueue(
                        new Callback<com.motiv.example.PhotosListResponse>() {
                            @Override
                            public void onResponse(
                                    Call<com.motiv.example.PhotosListResponse> call,
                                    retrofit2.Response<com.motiv.example.PhotosListResponse>
                                            response) {

                                onResponseListener.onSuccess(response.body());
                            }

                            @Override
                            public void onFailure(
                                    Call<com.motiv.example.PhotosListResponse> call, Throwable t) {

                                onResponseListener.onError(new Exception(t.getMessage()));
                            }
                        });
    }
}
