 
package com.motiv.example
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.DaoRepositoryFactory
import com.motiv.example.dao.LocalStorage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.drawerdashboard.*

public class DrawerDashboard : AppCompatActivity() {

    private lateinit var user: com.motiv.example.User

    private lateinit var usersListAdapter: UsersListAdapter

    private lateinit var postsAdapter: PostsAdapter

    private lateinit var photosPagerAdapter: PhotosPagerAdapter

    private lateinit var viewPagerFragmentsAdapter: ViewPagerFragmentsAdapter

    private lateinit var goApi: GoApi

    private lateinit var authApi: AuthApi

    private lateinit var daoRepository: DaoRepository

    private lateinit var localStorage: LocalStorage

    private lateinit var navigationController: NavigationController

    private lateinit var drawerlayout00: DrawerLayout

    private lateinit var navigationview11: NavigationView

    private lateinit var headerlinearlayout00: LinearLayout

    private lateinit var headerimageview10: ImageView

    private lateinit var headertextview11: TextView

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawerdashboard)

        user = com.motiv.example.User.fromJson(getIntent().getStringExtra("user"))

        usersListAdapter = UsersListAdapter()
        postsAdapter = PostsAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        viewPagerFragmentsAdapter = ViewPagerFragmentsAdapter(this@DrawerDashboard.getSupportFragmentManager())
        daoRepository = DaoRepositoryFactory.getInstance(this@DrawerDashboard)
        localStorage = LocalStorage.getInstance(this@DrawerDashboard)
        navigationController = NavigationController(this@DrawerDashboard)
        goApi = GoApiFactory.getInstance(localStorage)
        authApi = AuthApiFactory.getInstance(localStorage)
        drawerlayout00 = findViewById<DrawerLayout>(R.id.drawerlayout00)
        navigationview11 = findViewById<NavigationView>(R.id.navigationview11)
        headerlinearlayout00 = navigationview11.getHeaderView(0).findViewById<LinearLayout>(R.id.linearlayout00)
        headerimageview10 = navigationview11.getHeaderView(0).findViewById<ImageView>(R.id.imageview10)
        headertextview11 = navigationview11.getHeaderView(0).findViewById<TextView>(R.id.textview11)

        headertextview11.setText(user.getFirst_name())

        Picasso.with(this@DrawerDashboard).load(user.getLinks().getAvatar().getHref()).into(headerimageview10)
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
