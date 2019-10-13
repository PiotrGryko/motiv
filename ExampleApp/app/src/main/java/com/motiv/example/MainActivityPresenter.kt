 
package com.motiv.example
import androidx.fragment.app.*
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.LocalStorage
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*

public class MainActivityPresenter(val view: MainActivityContract.View, val goApi: GoApi, val authApi: AuthApi, val daoRepository: DaoRepository, val localStorage: LocalStorage) : MainActivityContract.Presenter {

    override fun eloonClick(argument0: android.view.View) {
        authApi.getToken(object : com.motiv.example.OnResponseListener<com.motiv.example.AuthToken> {
            override fun onSuccess(argument0: com.motiv.example.AuthToken) {
                localStorage.putString("token", argument0.getToken())
                goApi.getUser(
                    view.edittext10getText().toString(),
                    object : com.motiv.example.OnResponseListener<com.motiv.example.UserResponse> {
                        override fun onSuccess(argument0: com.motiv.example.UserResponse) {
                            view.showToast(argument0.getMeta().getMessage())
                            view.navigationControllerstartDrawerDashboard(argument0.getResult())
                        } override fun onError(argument0: Exception) {
                        } 
                    }
                )
            } override fun onError(argument0: Exception) {
            } 
        })
    }
}
