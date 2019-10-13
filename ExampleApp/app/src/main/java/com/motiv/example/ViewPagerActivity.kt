 
package com.motiv.example
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.*
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.LocalStorage
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlinx.android.synthetic.main.viewpageractivity.*

public class ViewPagerActivity : AppCompatActivity(), ViewPagerActivityContract.View, HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var presenter: ViewPagerActivityContract.Presenter

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

    private lateinit var tablayout10: TabLayout

    private lateinit var viewpager11: ViewPager

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    } override fun onCreate(savedInstanceState: android.os.Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.viewpageractivity)

        usersListAdapter = UsersListAdapter()
        postsAdapter = PostsAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        viewPagerFragmentsAdapter = ViewPagerFragmentsAdapter(this@ViewPagerActivity.getSupportFragmentManager())
        navigationController = NavigationController(this@ViewPagerActivity)
        linearlayout00 = findViewById<LinearLayout>(R.id.linearlayout00)
        tablayout10 = findViewById<TabLayout>(R.id.tablayout10)
        viewpager11 = findViewById<ViewPager>(R.id.viewpager11)

        presenter = ViewPagerActivityPresenter(this@ViewPagerActivity, goApi, authApi, daoRepository, localStorage)

        viewpager11.setAdapter(viewPagerFragmentsAdapter)
        tablayout10.setupWithViewPager(viewpager11)
    }
}
