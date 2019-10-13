 
package com.motiv.example
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.*
import com.bumptech.glide.Glide
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.LocalStorage
import com.motiv.example.databinding.UseractivityBinding
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlinx.android.synthetic.main.useractivity.*

public class UserActivity : AppCompatActivity(), UserActivityContract.View, HasSupportFragmentInjector {

    private lateinit var useractivityBinding: UseractivityBinding

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var userArgument: com.motiv.example.User

    private lateinit var presenter: UserActivityContract.Presenter

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

    private lateinit var imageview10: ImageView

    private lateinit var textview11: TextView

    private lateinit var textview12: TextView

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    } override fun onCreate(savedInstanceState: android.os.Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        useractivityBinding = DataBindingUtil.setContentView(this, R.layout.useractivity)

        userArgument = com.motiv.example.User.fromJson(getIntent().getStringExtra("userArgument"))

        usersListAdapter = UsersListAdapter()
        postsAdapter = PostsAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        viewPagerFragmentsAdapter = ViewPagerFragmentsAdapter(this@UserActivity.getSupportFragmentManager())
        navigationController = NavigationController(this@UserActivity)
        linearlayout00 = useractivityBinding.linearlayout00
        imageview10 = useractivityBinding.imageview10
        textview11 = useractivityBinding.textview11
        textview12 = useractivityBinding.textview12

        presenter = UserActivityPresenter(this@UserActivity, goApi, authApi, daoRepository, localStorage)

        Glide.with(this@UserActivity)
            .load(userArgument.getLinks().getAvatar().getHref())
            .into(imageview10)
        textview11.setText(userArgument.getFirst_name())
        textview12.setText(userArgument.getLast_name())
    }
}
