 
package com.motiv.example
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.LocalStorage

public class BottomNavigationDashboardPresenter(val view: BottomNavigationDashboardContract.View, val goApi: GoApi, val authApi: AuthApi, val daoRepository: DaoRepository, val localStorage: LocalStorage) : BottomNavigationDashboardContract.Presenter {

    override fun eloonNavigationItemSelected(argument0: android.view.MenuItem) {
        view.navigationControllerstartDestinationById(argument0.getItemId())
    }
}
