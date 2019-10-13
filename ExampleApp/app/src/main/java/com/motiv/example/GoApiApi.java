package com.motiv.example;

import androidx.fragment.app.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;
import retrofit2.*;
import retrofit2.http.*;

public interface GoApiApi {

    @GET("users/{userId}")
    Call<UserResponse> getUser(@Path("userId") java.lang.String userId);

    @GET("users")
    Call<UsersResponse> getUsersList();

    @GET("posts")
    Call<PostsListResponse> getPostsList();

    @GET("photos")
    Call<PhotosListResponse> getPhotos();
}
