 
package com.motiv.example
import androidx.fragment.app.*
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import retrofit2.*
import retrofit2.http.*

public interface AuthApiApi {

    @POST("auth")
    fun getToken(): Call<AuthToken>
}
