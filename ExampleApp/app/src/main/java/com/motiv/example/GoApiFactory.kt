 
package com.motiv.example
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import com.motiv.example.dao.LocalStorage
import java.io.*
import okhttp3.*
import okhttp3.Response
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

public class GoApiFactory {

    private var goApiApi: GoApiApi

    private var goApi: GoApi

    private var instance: GoApiFactory? = null

    constructor(localStorage: LocalStorage) {
        val client = OkHttpClient.Builder()
            .addInterceptor(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    val request = chain
                        .request()
                        .newBuilder()
                        .addHeader("Authorization", localStorage.getString("token"))
                        .build()
                    return chain.proceed(request);
                }
            })
            .build()
        val gson: Gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://gorest.co.in/public-api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        goApiApi = retrofit.create(GoApiApi::class.java)
        goApi = GoApi(goApiApi)
    }

    companion object {
        @Volatile private var INSTANCE: GoApi? = null
        fun getInstance(localStorage: LocalStorage): GoApi =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildInstance(localStorage).also { INSTANCE = it }
            }
        private fun buildInstance(localStorage: LocalStorage) = GoApiFactory(localStorage).goApi
    }
}
