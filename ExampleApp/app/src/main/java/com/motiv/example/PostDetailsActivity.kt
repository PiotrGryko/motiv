 
package com.motiv.example
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.*
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.LocalStorage
import com.motiv.example.databinding.PostdetailsactivityBinding
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlinx.android.synthetic.main.postdetailsactivity.*

public class PostDetailsActivity : AppCompatActivity(), PostDetailsActivityContract.View, HasSupportFragmentInjector {

    private lateinit var postdetailsactivityBinding: PostdetailsactivityBinding

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var postId: String

    private lateinit var presenter: PostDetailsActivityContract.Presenter

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

    private lateinit var linearlayout00: LinearLayout

    private lateinit var textview10: TextView

    private lateinit var textview11: TextView

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    } override fun onCreate(savedInstanceState: android.os.Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        postdetailsactivityBinding = DataBindingUtil.setContentView(this, R.layout.postdetailsactivity)

        val postId = getIntent().getStringExtra("postId")

        usersListAdapter = UsersListAdapter()
        postsAdapter = PostsAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        viewPagerFragmentsAdapter = ViewPagerFragmentsAdapter(this@PostDetailsActivity.getSupportFragmentManager())
        navigationController = NavigationController(this@PostDetailsActivity)
        linearlayout00 = postdetailsactivityBinding.linearlayout00
        textview10 = postdetailsactivityBinding.textview10
        textview11 = postdetailsactivityBinding.textview11

        presenter = PostDetailsActivityPresenter(this@PostDetailsActivity, goApi, authApi, daoRepository, localStorage)

        presenter.daoRepositoryloadPost(postId)
    } override fun textview10setText(arg0: CharSequence) {
        textview10.setText(arg0)
    } override fun textview11setText(arg0: CharSequence) {
        textview11.setText(arg0)
    }
}
