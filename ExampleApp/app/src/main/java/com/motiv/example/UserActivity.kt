 
package com.motiv.example
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.LocalStorage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.useractivity.*

public class UserActivity : AppCompatActivity(), UserActivityContract.View {

    private lateinit var userArgument: com.motiv.example.User

    private lateinit var presenter: UserActivityContract.Presenter

    private lateinit var usersListAdapter: UsersListAdapter

    private lateinit var postsAdapter: PostsAdapter

    private lateinit var photosPagerAdapter: PhotosPagerAdapter

    private lateinit var viewPagerFragmentsAdapter: ViewPagerFragmentsAdapter

    private lateinit var goApi: GoApi

    private lateinit var authApi: AuthApi

    private var daoRepository: DaoRepository = DaoRepositoryFactory.getInstance(this@UserActivity)

    private lateinit var localStorage: LocalStorage

    private lateinit var navigationController: NavigationController

    private lateinit var linearlayout00: LinearLayout

    private lateinit var imageview10: ImageView

    private lateinit var textview11: TextView

    private lateinit var textview12: TextView

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.useractivity)

        userArgument = com.motiv.example.User.fromJson(getIntent().getStringExtra("userArgument"))

        usersListAdapter = UsersListAdapter()
        postsAdapter = PostsAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        viewPagerFragmentsAdapter = ViewPagerFragmentsAdapter(this@UserActivity.getSupportFragmentManager())
        localStorage = LocalStorage.getInstance(this@UserActivity)
        navigationController = NavigationController(this@UserActivity)
        goApi = GoApiFactory.getInstance(localStorage)
        authApi = AuthApiFactory.getInstance(localStorage)
        linearlayout00 = findViewById<LinearLayout>(R.id.linearlayout00)
        imageview10 = findViewById<ImageView>(R.id.imageview10)
        textview11 = findViewById<TextView>(R.id.textview11)
        textview12 = findViewById<TextView>(R.id.textview12)

        presenter = UserActivityPresenter(this@UserActivity, goApi, authApi, daoRepository, localStorage)

        Picasso.with(this@UserActivity).load(userArgument.getLinks().getAvatar().getHref()).into(imageview10)
        textview11.setText(userArgument.getFirst_name())
        textview12.setText(userArgument.getLast_name())
    }
}
