 
package com.motiv.example
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.*
import androidx.recyclerview.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.LocalStorage
import com.motiv.example.databinding.UsersfragmentBinding
import kotlin.collections.List
import kotlinx.android.synthetic.main.usersfragment.*

public class UsersFragment : Fragment(), UsersFragmentContract.View {

    private lateinit var usersfragmentBinding: UsersfragmentBinding

    private lateinit var presenter: UsersFragmentContract.Presenter

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
        usersfragmentBinding = UsersfragmentBinding.inflate(inflater)

        usersListAdapter = UsersListAdapter()
        postsAdapter = PostsAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        viewPagerFragmentsAdapter = ViewPagerFragmentsAdapter(activity!!.getSupportFragmentManager())
        localStorage = LocalStorage.getInstance(activity!!)
        navigationController = NavigationController(activity!!)
        goApi = GoApiFactory.getInstance(localStorage)
        authApi = AuthApiFactory.getInstance(localStorage)
        linearlayout00 = usersfragmentBinding.linearlayout00
        recyclerview10 = usersfragmentBinding.recyclerview10
        presenter = UsersFragmentPresenter(this@UsersFragment, goApi, authApi, daoRepository, localStorage)

        recyclerview10?.setLayoutManager(LinearLayoutManager(activity!!))

        recyclerview10?.setAdapter(usersListAdapter)
        presenter.goApigetUsersList()
        usersListAdapter.setOnItemClickListener(object : com.motiv.example.UsersListAdapter.OnItemClickListener {
            override fun onItemClick(argument0: Int, argument1: com.motiv.example.User) {
                presenter.eloonItemClick(argument0, argument1)
            } 
        })

        return usersfragmentBinding.getRoot()
    } override fun usersListAdaptersetData(arg0: List<com.motiv.example.User>) {
        usersListAdapter.setData(arg0)
    } override fun showToast(arg0: String) {
        Toast.makeText(activity!!, arg0, Toast.LENGTH_LONG).show()
    } override fun navigationControllerstartUserActivity(arg0: com.motiv.example.User) {
        navigationController.startUserActivity(arg0)
    }
}
