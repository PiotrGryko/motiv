package com.motiv.example.dao;

import androidx.room.*;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import com.motiv.example.AuthToken;
import com.motiv.example.Link;
import com.motiv.example.Links;
import com.motiv.example.Meta;
import com.motiv.example.Photo;
import com.motiv.example.PhotosListResponse;
import com.motiv.example.Post;
import com.motiv.example.PostsListResponse;
import com.motiv.example.User;
import com.motiv.example.UserResponse;
import com.motiv.example.UsersResponse;
import java.util.List;

public class MyTypeConverter {

    @TypeConverter
    public static java.lang.String userToString(java.util.List<User> value) {

        return new Gson().toJson(value, new TypeToken<List<User>>() {}.getType());
    }

    @TypeConverter
    public static java.util.List<User> stringToUsers(java.lang.String value) {

        return new Gson().fromJson(value, new TypeToken<List<User>>() {}.getType());
    }

    @TypeConverter
    public static java.lang.String linksToString(java.util.List<Links> value) {

        return new Gson().toJson(value, new TypeToken<List<Links>>() {}.getType());
    }

    @TypeConverter
    public static java.util.List<Links> stringToLinkss(java.lang.String value) {

        return new Gson().fromJson(value, new TypeToken<List<Links>>() {}.getType());
    }

    @TypeConverter
    public static java.lang.String linkToString(java.util.List<Link> value) {

        return new Gson().toJson(value, new TypeToken<List<Link>>() {}.getType());
    }

    @TypeConverter
    public static java.util.List<Link> stringToLinks(java.lang.String value) {

        return new Gson().fromJson(value, new TypeToken<List<Link>>() {}.getType());
    }

    @TypeConverter
    public static java.lang.String userresponseToString(java.util.List<UserResponse> value) {

        return new Gson().toJson(value, new TypeToken<List<UserResponse>>() {}.getType());
    }

    @TypeConverter
    public static java.util.List<UserResponse> stringToUserResponses(java.lang.String value) {

        return new Gson().fromJson(value, new TypeToken<List<UserResponse>>() {}.getType());
    }

    @TypeConverter
    public static java.lang.String metaToString(java.util.List<Meta> value) {

        return new Gson().toJson(value, new TypeToken<List<Meta>>() {}.getType());
    }

    @TypeConverter
    public static java.util.List<Meta> stringToMetas(java.lang.String value) {

        return new Gson().fromJson(value, new TypeToken<List<Meta>>() {}.getType());
    }

    @TypeConverter
    public static java.lang.String usersresponseToString(java.util.List<UsersResponse> value) {

        return new Gson().toJson(value, new TypeToken<List<UsersResponse>>() {}.getType());
    }

    @TypeConverter
    public static java.util.List<UsersResponse> stringToUsersResponses(java.lang.String value) {

        return new Gson().fromJson(value, new TypeToken<List<UsersResponse>>() {}.getType());
    }

    @TypeConverter
    public static java.lang.String postslistresponseToString(
            java.util.List<PostsListResponse> value) {

        return new Gson().toJson(value, new TypeToken<List<PostsListResponse>>() {}.getType());
    }

    @TypeConverter
    public static java.util.List<PostsListResponse> stringToPostsListResponses(
            java.lang.String value) {

        return new Gson().fromJson(value, new TypeToken<List<PostsListResponse>>() {}.getType());
    }

    @TypeConverter
    public static java.lang.String postToString(java.util.List<Post> value) {

        return new Gson().toJson(value, new TypeToken<List<Post>>() {}.getType());
    }

    @TypeConverter
    public static java.util.List<Post> stringToPosts(java.lang.String value) {

        return new Gson().fromJson(value, new TypeToken<List<Post>>() {}.getType());
    }

    @TypeConverter
    public static java.lang.String photoslistresponseToString(
            java.util.List<PhotosListResponse> value) {

        return new Gson().toJson(value, new TypeToken<List<PhotosListResponse>>() {}.getType());
    }

    @TypeConverter
    public static java.util.List<PhotosListResponse> stringToPhotosListResponses(
            java.lang.String value) {

        return new Gson().fromJson(value, new TypeToken<List<PhotosListResponse>>() {}.getType());
    }

    @TypeConverter
    public static java.lang.String photoToString(java.util.List<Photo> value) {

        return new Gson().toJson(value, new TypeToken<List<Photo>>() {}.getType());
    }

    @TypeConverter
    public static java.util.List<Photo> stringToPhotos(java.lang.String value) {

        return new Gson().fromJson(value, new TypeToken<List<Photo>>() {}.getType());
    }

    @TypeConverter
    public static java.lang.String authtokenToString(java.util.List<AuthToken> value) {

        return new Gson().toJson(value, new TypeToken<List<AuthToken>>() {}.getType());
    }

    @TypeConverter
    public static java.util.List<AuthToken> stringToAuthTokens(java.lang.String value) {

        return new Gson().fromJson(value, new TypeToken<List<AuthToken>>() {}.getType());
    }
}
