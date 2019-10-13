 
package com.motiv.example
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.LocalStorage
import com.motiv.example.databinding.BottomnavigationdashboardBinding
import kotlinx.android.synthetic.main.bottomnavigationdashboard.*

public class BottomNavigationDashboard : AppCompatActivity() {

    private lateinit var bottomnavigationdashboardBinding: BottomnavigationdashboardBinding

    private lateinit var usersListAdapter: UsersListAdapter

    private lateinit var postsAdapter: PostsAdapter

    private lateinit var photosPagerAdapter: PhotosPagerAdapter

    private lateinit var viewPagerFragmentsAdapter: ViewPagerFragmentsAdapter

    private lateinit var goApi: GoApi

    private lateinit var authApi: AuthApi

    private var daoRepository: DaoRepository = DaoRepositoryFactory.getInstance(this@BottomNavigationDashboard)

    private lateinit var localStorage: LocalStorage

    private lateinit var navigationController: NavigationController

    private lateinit var relativelayout00: RelativeLayout

    private lateinit var bottomnavigationview11: BottomNavigationView

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        bottomnavigationdashboardBinding = DataBindingUtil.setContentView(this, R.layout.bottomnavigationdashboard)

        usersListAdapter = UsersListAdapter()
        postsAdapter = PostsAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        viewPagerFragmentsAdapter = ViewPagerFragmentsAdapter(this@BottomNavigationDashboard.getSupportFragmentManager())
        localStorage = LocalStorage.getInstance(this@BottomNavigationDashboard)
        navigationController = NavigationController(this@BottomNavigationDashboard)
        goApi = GoApiFactory.getInstance(localStorage)
        authApi = AuthApiFactory.getInstance(localStorage)
        relativelayout00 = bottomnavigationdashboardBinding.relativelayout00
        bottomnavigationview11 = bottomnavigationdashboardBinding.bottomnavigationview11

        bottomnavigationview11.setOnNavigationItemSelectedListener(object : com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(argument0: android.view.MenuItem): Boolean {
                navigationController.startDestinationById(argument0.getItemId())

                return false
            } 
        })
    }
}
