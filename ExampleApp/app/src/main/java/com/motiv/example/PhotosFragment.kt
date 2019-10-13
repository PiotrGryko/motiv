 
package com.motiv.example
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.*
import androidx.viewpager.widget.ViewPager
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.DaoRepositoryFactory
import com.motiv.example.dao.LocalStorage
import com.motiv.example.databinding.PhotosfragmentBinding
import kotlin.collections.List
import kotlinx.android.synthetic.main.photosfragment.*

public class PhotosFragment : Fragment(), PhotosFragmentContract.View {

    private lateinit var photosfragmentBinding: PhotosfragmentBinding

    private lateinit var presenter: PhotosFragmentContract.Presenter

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

    private lateinit var viewpager10: ViewPager

    override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup?, savedInstanceState: Bundle?): View {
        photosfragmentBinding = PhotosfragmentBinding.inflate(inflater)

        usersListAdapter = UsersListAdapter()
        postsAdapter = PostsAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        viewPagerFragmentsAdapter = ViewPagerFragmentsAdapter(activity!!.getSupportFragmentManager())
        daoRepository = DaoRepositoryFactory.getInstance(activity!!)
        localStorage = LocalStorage.getInstance(activity!!)
        navigationController = NavigationController(activity!!)
        goApi = GoApiFactory.getInstance(localStorage)
        authApi = AuthApiFactory.getInstance(localStorage)
        linearlayout00 = photosfragmentBinding.linearlayout00
        viewpager10 = photosfragmentBinding.viewpager10
        presenter = PhotosFragmentPresenter(this@PhotosFragment, goApi, authApi, daoRepository, localStorage)

        viewpager10.setAdapter(photosPagerAdapter)
        presenter.goApigetPhotos()

        return photosfragmentBinding.getRoot()
    } override fun photosPagerAdaptersetData(arg0: List<com.motiv.example.Photo>) {
        photosPagerAdapter.setData(arg0)
    }
}
