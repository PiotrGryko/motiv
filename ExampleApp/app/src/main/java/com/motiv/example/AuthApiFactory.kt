 
package com.motiv.example
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import com.motiv.example.dao.LocalStorage
import java.io.*
import okhttp3.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

public class AuthApiFactory {

    private var authApiApi: AuthApiApi

    private var authApi: AuthApi

    private var instance: AuthApiFactory? = null

    constructor(localStorage: LocalStorage) {
        val client = OkHttpClient.Builder()

            .build()
        val gson: Gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://private-fe08d8-auth130.apiary-mock.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        authApiApi = retrofit.create(AuthApiApi::class.java)
        authApi = AuthApi(authApiApi)
    }

    companion object {
        @Volatile private var INSTANCE: AuthApi? = null
        fun getInstance(localStorage: LocalStorage): AuthApi =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildInstance(localStorage).also { INSTANCE = it }
            }
        private fun buildInstance(localStorage: LocalStorage) = AuthApiFactory(localStorage).authApi
    }
}
