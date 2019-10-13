 
package com.motiv.example
import androidx.fragment.app.*
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import retrofit2.*
import retrofit2.http.*

public class GoApi(val goApiApi: GoApiApi) {

    fun getUser(userId: String, onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.UserResponse>) {
        goApiApi!!.getUser(userId).enqueue(object : Callback<com.motiv.example.UserResponse> {
            override fun onFailure(call: Call<com.motiv.example.UserResponse>?, t: Throwable?) {
                onResponseListener.onError(Exception(t?.message))
            }

            override fun onResponse(call: Call<com.motiv.example.UserResponse>?, response: Response<com.motiv.example.UserResponse>?) {
                onResponseListener.onSuccess(response?.body() as com.motiv.example.UserResponse)
            }
        })
    } fun getUsersList(onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.UsersResponse>) {
        goApiApi!!.getUsersList().enqueue(object : Callback<com.motiv.example.UsersResponse> {
            override fun onFailure(call: Call<com.motiv.example.UsersResponse>?, t: Throwable?) {
                onResponseListener.onError(Exception(t?.message))
            }

            override fun onResponse(call: Call<com.motiv.example.UsersResponse>?, response: Response<com.motiv.example.UsersResponse>?) {
                onResponseListener.onSuccess(response?.body() as com.motiv.example.UsersResponse)
            }
        })
    } fun getPostsList(onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.PostsListResponse>) {
        goApiApi!!.getPostsList().enqueue(object : Callback<com.motiv.example.PostsListResponse> {
            override fun onFailure(call: Call<com.motiv.example.PostsListResponse>?, t: Throwable?) {
                onResponseListener.onError(Exception(t?.message))
            }

            override fun onResponse(call: Call<com.motiv.example.PostsListResponse>?, response: Response<com.motiv.example.PostsListResponse>?) {
                onResponseListener.onSuccess(response?.body() as com.motiv.example.PostsListResponse)
            }
        })
    } fun getPhotos(onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.PhotosListResponse>) {
        goApiApi!!.getPhotos().enqueue(object : Callback<com.motiv.example.PhotosListResponse> {
            override fun onFailure(call: Call<com.motiv.example.PhotosListResponse>?, t: Throwable?) {
                onResponseListener.onError(Exception(t?.message))
            }

            override fun onResponse(call: Call<com.motiv.example.PhotosListResponse>?, response: Response<com.motiv.example.PhotosListResponse>?) {
                onResponseListener.onSuccess(response?.body() as com.motiv.example.PhotosListResponse)
            }
        })
    }
}
