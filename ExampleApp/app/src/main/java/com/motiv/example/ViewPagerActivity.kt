 
package com.motiv.example
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.DaoRepositoryFactory
import com.motiv.example.dao.LocalStorage
import com.motiv.example.databinding.ViewpageractivityBinding
import kotlinx.android.synthetic.main.viewpageractivity.*

public class ViewPagerActivity : AppCompatActivity(), ViewPagerActivityContract.View {

    private lateinit var viewpageractivityBinding: ViewpageractivityBinding

    private lateinit var presenter: ViewPagerActivityContract.Presenter

    private lateinit var usersListAdapter: UsersListAdapter

    private lateinit var postsAdapter: PostsAdapter

    private lateinit var photosPagerAdapter: PhotosPagerAdapter

    private lateinit var viewPagerFragmentsAdapter: ViewPagerFragmentsAdapter

    private lateinit var goApi: GoApi

    private lateinit var authApi: AuthApi

    private lateinit var daoRepository: DaoRepository

    private lateinit var localStorage: LocalStorage

    private lateinit var navigationController: NavigationController

    private lateinit var linearlayout00: LinearLayout

    private lateinit var tablayout10: TabLayout

    private lateinit var viewpager11: ViewPager

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        viewpageractivityBinding = DataBindingUtil.setContentView(this, R.layout.viewpageractivity)

        usersListAdapter = UsersListAdapter()
        postsAdapter = PostsAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        viewPagerFragmentsAdapter = ViewPagerFragmentsAdapter(this@ViewPagerActivity.getSupportFragmentManager())
        daoRepository = DaoRepositoryFactory.getInstance(this@ViewPagerActivity)
        localStorage = LocalStorage.getInstance(this@ViewPagerActivity)
        navigationController = NavigationController(this@ViewPagerActivity)
        goApi = GoApiFactory.getInstance(localStorage)
        authApi = AuthApiFactory.getInstance(localStorage)
        linearlayout00 = viewpageractivityBinding.linearlayout00
        tablayout10 = viewpageractivityBinding.tablayout10
        viewpager11 = viewpageractivityBinding.viewpager11

        presenter = ViewPagerActivityPresenter(this@ViewPagerActivity, goApi, authApi, daoRepository, localStorage)

        viewpager11.setAdapter(viewPagerFragmentsAdapter)
        tablayout10.setupWithViewPager(viewpager11)
    }
}
