 
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

public class AuthApi(val authApiApi: AuthApiApi) {

    fun getToken(onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.AuthToken>) {
        authApiApi!!.getToken().enqueue(object : Callback<com.motiv.example.AuthToken> {
            override fun onFailure(call: Call<com.motiv.example.AuthToken>?, t: Throwable?) {
                onResponseListener.onError(Exception(t?.message))
            }

            override fun onResponse(call: Call<com.motiv.example.AuthToken>?, response: Response<com.motiv.example.AuthToken>?) {
                onResponseListener.onSuccess(response?.body() as com.motiv.example.AuthToken)
            }
        })
    }
}
