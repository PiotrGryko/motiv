 
package com.motiv.example
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.LocalStorage

public class DrawerDashboardPresenter(val view: DrawerDashboardContract.View, val goApi: GoApi, val authApi: AuthApi, val daoRepository: DaoRepository, val localStorage: LocalStorage) : DrawerDashboardContract.Presenter {

    override fun eloonClick(argument0: android.view.View) {
        view.navigationControllerstartUserActivity(view.getuser())
    } override fun eloonNavigationItemSelected(argument0: android.view.MenuItem) {
        view.navigationControllerstartDestinationById(argument0.getItemId())
    }
}
