package com.motiv.example.dao;

import androidx.fragment.app.*;
import androidx.room.*;
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
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

@TypeConverters({MyTypeConverter.class})
@Database(
    entities = {
        UserResponse.class,
        UsersResponse.class,
        AuthToken.class,
        Meta.class,
        PostsListResponse.class,
        PhotosListResponse.class,
        Photo.class,
        Links.class,
        Post.class,
        Link.class,
        User.class
    },
    version = 1
)
public abstract class MyRoomDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "test";

    public abstract com.motiv.example.dao.UserDao userDao();

    public abstract com.motiv.example.dao.LinksDao linksDao();

    public abstract com.motiv.example.dao.LinkDao linkDao();

    public abstract com.motiv.example.dao.UserResponseDao userResponseDao();

    public abstract com.motiv.example.dao.MetaDao metaDao();

    public abstract com.motiv.example.dao.UsersResponseDao usersResponseDao();

    public abstract com.motiv.example.dao.PostsListResponseDao postsListResponseDao();

    public abstract com.motiv.example.dao.PostDao postDao();

    public abstract com.motiv.example.dao.PhotosListResponseDao photosListResponseDao();

    public abstract com.motiv.example.dao.PhotoDao photoDao();

    public abstract com.motiv.example.dao.AuthTokenDao authTokenDao();
}
