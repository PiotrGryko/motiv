 
package com.motiv.example
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.DaoRepositoryFactory
import com.motiv.example.dao.LocalStorage
import kotlinx.android.synthetic.main.bottomnavigationdashboard.*

public class BottomNavigationDashboard : AppCompatActivity(), BottomNavigationDashboardContract.View {

    private lateinit var presenter: BottomNavigationDashboardContract.Presenter

    private lateinit var usersListAdapter: UsersListAdapter

    private lateinit var postsAdapter: PostsAdapter

    private lateinit var photosPagerAdapter: PhotosPagerAdapter

    private lateinit var viewPagerFragmentsAdapter: ViewPagerFragmentsAdapter

    private lateinit var goApi: GoApi

    private lateinit var authApi: AuthApi

    private lateinit var daoRepository: DaoRepository

    private lateinit var localStorage: LocalStorage

    private lateinit var navigationController: NavigationController

    private lateinit var relativelayout00: RelativeLayout

    private lateinit var bottomnavigationview11: BottomNavigationView

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bottomnavigationdashboard)

        usersListAdapter = UsersListAdapter()
        postsAdapter = PostsAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        viewPagerFragmentsAdapter = ViewPagerFragmentsAdapter(this@BottomNavigationDashboard.getSupportFragmentManager())
        daoRepository = DaoRepositoryFactory.getInstance(this@BottomNavigationDashboard)
        localStorage = LocalStorage.getInstance(this@BottomNavigationDashboard)
        navigationController = NavigationController(this@BottomNavigationDashboard)
        goApi = GoApiFactory.getInstance(localStorage)
        authApi = AuthApiFactory.getInstance(localStorage)
        relativelayout00 = findViewById<RelativeLayout>(R.id.relativelayout00)
        bottomnavigationview11 = findViewById<BottomNavigationView>(R.id.bottomnavigationview11)

        presenter = BottomNavigationDashboardPresenter(this@BottomNavigationDashboard, goApi, authApi, daoRepository, localStorage)

        bottomnavigationview11.setOnNavigationItemSelectedListener(object : com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(argument0: android.view.MenuItem): Boolean {
                presenter.eloonNavigationItemSelected(argument0)

                return false
            } 
        })
    } override fun navigationControllerstartDestinationById(arg0: Int) {
        navigationController.startDestinationById(arg0)
    }
}
