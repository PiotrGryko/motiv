 
package com.motiv.example
import androidx.fragment.app.*
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import retrofit2.*
import retrofit2.http.*

public interface GoApiApi {

    @GET("users/{userId}")
    fun getUser(
        @Path("userId")
        userId: String
    ): Call<UserResponse>@GET("users")
    fun getUsersList(): Call<UsersResponse>@GET("posts")
    fun getPostsList(): Call<PostsListResponse>@GET("photos")
    fun getPhotos(): Call<PhotosListResponse>
}
