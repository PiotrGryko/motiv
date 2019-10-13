 
package com.motiv.example
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.*
import com.bumptech.glide.Glide
import com.google.android.material.navigation.NavigationView
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.LocalStorage
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlinx.android.synthetic.main.drawerdashboard.*

public class DrawerDashboard : AppCompatActivity(), DrawerDashboardContract.View, HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var user: com.motiv.example.User

    private lateinit var presenter: DrawerDashboardContract.Presenter

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
        setContentView(R.layout.drawerdashboard)

        user = com.motiv.example.User.fromJson(getIntent().getStringExtra("user"))

        usersListAdapter = UsersListAdapter()
        postsAdapter = PostsAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        viewPagerFragmentsAdapter = ViewPagerFragmentsAdapter(this@DrawerDashboard.getSupportFragmentManager())
        navigationController = NavigationController(this@DrawerDashboard)
        drawerlayout00 = findViewById<DrawerLayout>(R.id.drawerlayout00)
        navigationview11 = findViewById<NavigationView>(R.id.navigationview11)
        headerlinearlayout00 = navigationview11.getHeaderView(0).findViewById<LinearLayout>(R.id.linearlayout00)
        headerimageview10 = navigationview11.getHeaderView(0).findViewById<ImageView>(R.id.imageview10)
        headertextview11 = navigationview11.getHeaderView(0).findViewById<TextView>(R.id.textview11)

        presenter = DrawerDashboardPresenter(this@DrawerDashboard, goApi, authApi, daoRepository, localStorage)

        headertextview11.setText(user.getFirst_name())
        Glide.with(this@DrawerDashboard)
            .load(user.getLinks().getAvatar().getHref())
            .into(headerimageview10)
        headerlinearlayout00.setOnClickListener(object : android.view.View.OnClickListener {
            override fun onClick(argument0: android.view.View) {
                presenter.eloonClick(argument0)
            } 
        })
        navigationview11.setNavigationItemSelectedListener(object : com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(argument0: android.view.MenuItem): Boolean {
                presenter.eloonNavigationItemSelected(argument0)

                return false
            } 
        })
    } override fun navigationControllerstartUserActivity(arg0: com.motiv.example.User) {
        navigationController.startUserActivity(arg0)
    } override fun getuser(): com.motiv.example.User {
        return user
    } override fun navigationControllerstartDestinationById(arg0: Int) {
        navigationController.startDestinationById(arg0)
    }
}
