 
package com.motiv.example
import androidx.fragment.app.*
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.LocalStorage
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*

public class DrawerDashboardPresenter(val view: DrawerDashboardContract.View, val goApi: GoApi, val authApi: AuthApi, val daoRepository: DaoRepository, val localStorage: LocalStorage) : DrawerDashboardContract.Presenter {

    override fun eloonClick(argument0: android.view.View) {
        view.navigationControllerstartUserActivity(view.getuser())
    } override fun eloonNavigationItemSelected(argument0: android.view.MenuItem) {
        view.navigationControllerstartDestinationById(argument0.getItemId())
    }
}
