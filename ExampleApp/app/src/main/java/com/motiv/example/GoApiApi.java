package com.motiv.example;

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
