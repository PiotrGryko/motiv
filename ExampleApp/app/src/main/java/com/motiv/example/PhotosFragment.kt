 
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
import com.motiv.example.databinding.PhotosfragmentBinding
import kotlinx.android.synthetic.main.photosfragment.*

public class PhotosFragment : Fragment() {

    private lateinit var photosfragmentBinding: PhotosfragmentBinding

    private lateinit var usersListAdapter: UsersListAdapter

    private lateinit var postsAdapter: PostsAdapter

    private lateinit var photosPagerAdapter: PhotosPagerAdapter

    private lateinit var viewPagerFragmentsAdapter: ViewPagerFragmentsAdapter

    private lateinit var goApi: GoApi

    private lateinit var authApi: AuthApi

    private var daoRepository: DaoRepository = DaoRepositoryFactory.getInstance(activity!!)

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
        localStorage = LocalStorage.getInstance(activity!!)
        navigationController = NavigationController(activity!!)
        goApi = GoApiFactory.getInstance(localStorage)
        authApi = AuthApiFactory.getInstance(localStorage)
        linearlayout00 = photosfragmentBinding.linearlayout00
        viewpager10 = photosfragmentBinding.viewpager10

        viewpager10.setAdapter(photosPagerAdapter)
        goApi.getPhotos(object : com.motiv.example.OnResponseListener<com.motiv.example.PhotosListResponse> {
            override fun onSuccess(argument0: com.motiv.example.PhotosListResponse) {
                photosPagerAdapter.setData(argument0.getResult())
            } override fun onError(argument0: Exception) {
            } 
        })

        return photosfragmentBinding.getRoot()
    }
}
