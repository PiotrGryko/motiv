 
package com.motiv.example
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.*
import androidx.recyclerview.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.LocalStorage
import com.motiv.example.databinding.PostsfragmentBinding
import kotlin.collections.List
import kotlinx.android.synthetic.main.postsfragment.*

public class PostsFragment : Fragment(), PostsFragmentContract.View {

    private lateinit var postsfragmentBinding: PostsfragmentBinding

    private lateinit var presenter: PostsFragmentContract.Presenter

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

    private lateinit var recyclerview10: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup?, savedInstanceState: Bundle?): View {
        postsfragmentBinding = PostsfragmentBinding.inflate(inflater)

        usersListAdapter = UsersListAdapter()
        postsAdapter = PostsAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        viewPagerFragmentsAdapter = ViewPagerFragmentsAdapter(activity!!.getSupportFragmentManager())
        localStorage = LocalStorage.getInstance(activity!!)
        navigationController = NavigationController(activity!!)
        goApi = GoApiFactory.getInstance(localStorage)
        authApi = AuthApiFactory.getInstance(localStorage)
        linearlayout00 = postsfragmentBinding.linearlayout00
        recyclerview10 = postsfragmentBinding.recyclerview10
        presenter = PostsFragmentPresenter(this@PostsFragment, goApi, authApi, daoRepository, localStorage)

        recyclerview10?.setLayoutManager(LinearLayoutManager(activity!!))

        recyclerview10?.setAdapter(postsAdapter)
        presenter.goApigetPostsList()
        postsAdapter.setOnItemClickListener(object : com.motiv.example.PostsAdapter.OnItemClickListener {
            override fun onItemClick(argument0: Int, argument1: com.motiv.example.Post) {
                presenter.eloonItemClick(argument0, argument1)
            } 
        })

        return postsfragmentBinding.getRoot()
    } override fun postsAdaptersetData(arg0: List<com.motiv.example.Post>) {
        postsAdapter.setData(arg0)
    } override fun navigationControllerstartPostDetailsActivity(arg0: String) {
        navigationController.startPostDetailsActivity(arg0)
    }
}
