 
package com.motiv.example
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.*
import androidx.viewpager.widget.ViewPager
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.LocalStorage
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List
import kotlinx.android.synthetic.main.photosfragment.*

public class PhotosFragment : Fragment(), PhotosFragmentContract.View {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var presenter: PhotosFragmentContract.Presenter

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

    private lateinit var viewpager10: ViewPager

    override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup?, savedInstanceState: Bundle?): View {
        val v: View = inflater.inflate(R.layout.photosfragment, parent, false)

        usersListAdapter = UsersListAdapter()
        postsAdapter = PostsAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        viewPagerFragmentsAdapter = ViewPagerFragmentsAdapter(activity!!.getSupportFragmentManager())
        navigationController = NavigationController(activity!!)
        linearlayout00 = v.findViewById<LinearLayout>(R.id.linearlayout00)
        viewpager10 = v.findViewById<ViewPager>(R.id.viewpager10)
        presenter = PhotosFragmentPresenter(this@PhotosFragment, goApi, authApi, daoRepository, localStorage)

        viewpager10.setAdapter(photosPagerAdapter)
        presenter.goApigetPhotos()

        return v
    } override fun photosPagerAdaptersetData(arg0: List<com.motiv.example.Photo>) {
        photosPagerAdapter.setData(arg0)
    } override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }
}
