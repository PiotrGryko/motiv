 
package com.motiv.example
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.LocalStorage

public class ViewPagerActivityPresenter(val view: ViewPagerActivityContract.View, val goApi: GoApi, val authApi: AuthApi, val daoRepository: DaoRepository, val localStorage: LocalStorage) : ViewPagerActivityContract.Presenter
