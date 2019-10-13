 
package com.motiv.example.di
import android.app.Application
import android.os.Handler
import androidx.fragment.app.*
import androidx.room.*
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import com.motiv.example.AuthApi
import com.motiv.example.AuthApiApi
import com.motiv.example.GoApi
import com.motiv.example.GoApiApi
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.LocalStorage
import com.motiv.example.dao.MyRoomDatabase
import dagger.*
import dagger.android.*
import dagger.android.support.*
import java.io.*
import java.util.*
import java.util.concurrent.*
import javax.inject.*
import okhttp3.*
import okhttp3.Response
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
@Module
public class AppModule(private val application: Application) {

    @Provides
    @Singleton

    fun getLocalStorage(): LocalStorage {
        return LocalStorage(application)
    } @Provides
    @Singleton
    fun getGoApiApi(localStorage: LocalStorage): GoApiApi {
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
        var goApiApi = retrofit.create(GoApiApi::class.java)

        return goApiApi
    } @Provides
    @Singleton
    fun getGoApi(goApiApi: GoApiApi): GoApi {
        var goApi = GoApi(goApiApi)

        return goApi
    } @Provides
    @Singleton
    fun getAuthApiApi(localStorage: LocalStorage): AuthApiApi {
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
            .baseUrl("https://private-fe08d8-auth130.apiary-mock.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        var authApiApi = retrofit.create(AuthApiApi::class.java)

        return authApiApi
    } @Provides
    @Singleton
    fun getAuthApi(authApiApi: AuthApiApi): AuthApi {
        var authApi = AuthApi(authApiApi)

        return authApi
    } @Provides fun provideHandler(): Handler {
        return Handler(application.getMainLooper())
    } @Provides
    @Singleton
    fun provideMyRoomDatabase(): MyRoomDatabase {
        return Room.databaseBuilder(application, MyRoomDatabase::class.java, MyRoomDatabase.DATABASE_NAME).build()
    } @Provides
    @Singleton
    fun provideExecutor(): Executor {
        val NUMBER_OF_CORES: Int = Runtime.getRuntime().availableProcessors()
        val KEEP_ALIVE_TIME: Long = 1
        val KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS
        val mDecodeWorkQueue = LinkedBlockingQueue<Runnable>()
        return ThreadPoolExecutor(NUMBER_OF_CORES, NUMBER_OF_CORES, KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, mDecodeWorkQueue)
    } @Provides
    @Singleton
    fun getDaoRepository(handler: Handler, myRoomDatabase: MyRoomDatabase, executor: Executor): DaoRepository {
        return DaoRepository(handler, myRoomDatabase, executor)
    }
}
