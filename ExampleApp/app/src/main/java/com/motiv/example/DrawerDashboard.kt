 
package com.motiv.example
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.*
import com.bumptech.glide.Glide
import com.google.android.material.navigation.NavigationView
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.LocalStorage
import com.motiv.example.databinding.DrawerdashboardBinding
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlinx.android.synthetic.main.drawerdashboard.*

public class DrawerDashboard : AppCompatActivity(), HasSupportFragmentInjector {

    private lateinit var drawerdashboardBinding: DrawerdashboardBinding

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var user: com.motiv.example.User

    private lateinit var usersListAdapter: UsersListAdapter

    private lateinit var postsAdapter: PostsAdapter

    private lateinit var photosPagerAdapter: PhotosPagerAdapter

    private lateinit var viewPagerFragmentsAdapter: ViewPagerFragmentsAdapter

    @Inject
    lateinit var goApi: GoApi

    @Inject
    lateinit var authApi: AuthApi

    @Inject
    lateinit var daoRepository: DaoRepository

    @Inject
    lateinit var localStorage: LocalStorage

    private lateinit var navigationController: NavigationController

    private lateinit var drawerlayout00: DrawerLayout

    private lateinit var navigationview11: NavigationView

    private lateinit var headerlinearlayout00: LinearLayout

    private lateinit var headerimageview10: ImageView

    private lateinit var headertextview11: TextView

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    } override fun onCreate(savedInstanceState: android.os.Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        drawerdashboardBinding = DataBindingUtil.setContentView(this, R.layout.drawerdashboard)

        user = com.motiv.example.User.fromJson(getIntent().getStringExtra("user"))

        usersListAdapter = UsersListAdapter()
        postsAdapter = PostsAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        viewPagerFragmentsAdapter = ViewPagerFragmentsAdapter(this@DrawerDashboard.getSupportFragmentManager())
        navigationController = NavigationController(this@DrawerDashboard)
        drawerlayout00 = drawerdashboardBinding.drawerlayout00
        navigationview11 = drawerdashboardBinding.navigationview11
        headerlinearlayout00 = navigationview11.getHeaderView(0).findViewById<LinearLayout>(R.id.linearlayout00)
        headerimageview10 = navigationview11.getHeaderView(0).findViewById<ImageView>(R.id.imageview10)
        headertextview11 = navigationview11.getHeaderView(0).findViewById<TextView>(R.id.textview11)

        headertextview11.setText(user.getFirst_name())
        Glide.with(this@DrawerDashboard)
            .load(user.getLinks().getAvatar().getHref())
            .into(headerimageview10)
        headerlinearlayout00.setOnClickListener(object : android.view.View.OnClickListener {
            override fun onClick(argument0: android.view.View) {
                navigationController.startUserActivity(user)
            } 
        })
        navigationview11.setNavigationItemSelectedListener(object : com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(argument0: android.view.MenuItem): Boolean {
                navigationController.startDestinationById(argument0.getItemId())

                return false
            } 
        })
    }
}
