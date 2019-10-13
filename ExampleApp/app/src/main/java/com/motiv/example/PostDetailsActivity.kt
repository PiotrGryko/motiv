 
package com.motiv.example
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.LocalStorage
import kotlinx.android.synthetic.main.postdetailsactivity.*

public class PostDetailsActivity : AppCompatActivity(), PostDetailsActivityContract.View {

    private lateinit var postId: String

    private lateinit var presenter: PostDetailsActivityContract.Presenter

    private lateinit var usersListAdapter: UsersListAdapter

    private lateinit var postsAdapter: PostsAdapter

    private lateinit var photosPagerAdapter: PhotosPagerAdapter

    private lateinit var viewPagerFragmentsAdapter: ViewPagerFragmentsAdapter

    private lateinit var goApi: GoApi

    private lateinit var authApi: AuthApi

    private var daoRepository: DaoRepository = DaoRepositoryFactory.getInstance(this@PostDetailsActivity)

    private lateinit var localStorage: LocalStorage

    private lateinit var navigationController: NavigationController

    private lateinit var linearlayout00: LinearLayout

    private lateinit var textview10: TextView

    private lateinit var textview11: TextView

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.postdetailsactivity)

        val postId = getIntent().getStringExtra("postId")

        usersListAdapter = UsersListAdapter()
        postsAdapter = PostsAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        viewPagerFragmentsAdapter = ViewPagerFragmentsAdapter(this@PostDetailsActivity.getSupportFragmentManager())
        localStorage = LocalStorage.getInstance(this@PostDetailsActivity)
        navigationController = NavigationController(this@PostDetailsActivity)
        goApi = GoApiFactory.getInstance(localStorage)
        authApi = AuthApiFactory.getInstance(localStorage)
        linearlayout00 = findViewById<LinearLayout>(R.id.linearlayout00)
        textview10 = findViewById<TextView>(R.id.textview10)
        textview11 = findViewById<TextView>(R.id.textview11)

        presenter = PostDetailsActivityPresenter(this@PostDetailsActivity, goApi, authApi, daoRepository, localStorage)

        presenter.daoRepositoryloadPost(postId)
    } override fun textview10setText(arg0: CharSequence) {
        textview10.setText(arg0)
    } override fun textview11setText(arg0: CharSequence) {
        textview11.setText(arg0)
    }
}
