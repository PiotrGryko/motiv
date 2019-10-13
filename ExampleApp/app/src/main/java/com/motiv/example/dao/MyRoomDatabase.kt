 
package com.motiv.example.dao
import androidx.fragment.app.*
import androidx.room.*
import com.motiv.example.AuthToken
import com.motiv.example.Link
import com.motiv.example.Links
import com.motiv.example.Meta
import com.motiv.example.Photo
import com.motiv.example.PhotosListResponse
import com.motiv.example.Post
import com.motiv.example.PostsListResponse
import com.motiv.example.User
import com.motiv.example.UserResponse
import com.motiv.example.UsersResponse
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
@TypeConverters(MyTypeConverter::class)
@Database(entities = [User::class, UserResponse::class, AuthToken::class, PhotosListResponse::class, PostsListResponse::class, Meta::class, Photo::class, Post::class, Link::class, Links::class, UsersResponse::class], version = 1)
public abstract class MyRoomDatabase : RoomDatabase() {

    companion object {
        val DATABASE_NAME: String = "test"
    }

    public abstract fun userDao(): com.motiv.example.dao.UserDao
    public abstract fun linksDao(): com.motiv.example.dao.LinksDao
    public abstract fun linkDao(): com.motiv.example.dao.LinkDao
    public abstract fun userResponseDao(): com.motiv.example.dao.UserResponseDao
    public abstract fun metaDao(): com.motiv.example.dao.MetaDao
    public abstract fun usersResponseDao(): com.motiv.example.dao.UsersResponseDao
    public abstract fun postsListResponseDao(): com.motiv.example.dao.PostsListResponseDao
    public abstract fun postDao(): com.motiv.example.dao.PostDao
    public abstract fun photosListResponseDao(): com.motiv.example.dao.PhotosListResponseDao
    public abstract fun photoDao(): com.motiv.example.dao.PhotoDao
    public abstract fun authTokenDao(): com.motiv.example.dao.AuthTokenDao
}
