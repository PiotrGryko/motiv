 
package com.motiv.example
import androidx.fragment.app.*
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.LocalStorage
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*

public class UsersFragmentPresenter(val view: UsersFragmentContract.View, val goApi: GoApi, val authApi: AuthApi, val daoRepository: DaoRepository, val localStorage: LocalStorage) : UsersFragmentContract.Presenter {

    override fun goApigetUsersList() {
        goApi.getUsersList(object : com.motiv.example.OnResponseListener<com.motiv.example.UsersResponse> {
            override fun onSuccess(argument0: com.motiv.example.UsersResponse) {
                view.usersListAdaptersetData(argument0.getResult())
                view.showToast(argument0.getMeta().getMessage())
            } override fun onError(argument0: Exception) {
                view.showToast("error fetching data")
            } 
        })
    } override fun eloonItemClick(argument0: Int, argument1: com.motiv.example.User) {
        view.navigationControllerstartUserActivity(argument1)
    }
}
