 
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
import com.motiv.example.dao.DaoRepositoryFactory
import com.motiv.example.dao.LocalStorage
import com.motiv.example.databinding.UsersfragmentBinding
import kotlinx.android.synthetic.main.usersfragment.*

public class UsersFragment : Fragment() {

    private lateinit var usersfragmentBinding: UsersfragmentBinding

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

    private lateinit var recyclerview10: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup?, savedInstanceState: Bundle?): View {
        usersfragmentBinding = UsersfragmentBinding.inflate(inflater)

        usersListAdapter = UsersListAdapter()
        postsAdapter = PostsAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        viewPagerFragmentsAdapter = ViewPagerFragmentsAdapter(activity!!.getSupportFragmentManager())
        daoRepository = DaoRepositoryFactory.getInstance(activity!!)
        localStorage = LocalStorage.getInstance(activity!!)
        navigationController = NavigationController(activity!!)
        goApi = GoApiFactory.getInstance(localStorage)
        authApi = AuthApiFactory.getInstance(localStorage)
        linearlayout00 = usersfragmentBinding.linearlayout00
        recyclerview10 = usersfragmentBinding.recyclerview10

        recyclerview10?.setLayoutManager(LinearLayoutManager(activity!!))

        recyclerview10?.setAdapter(usersListAdapter)
        goApi.getUsersList(object : com.motiv.example.OnResponseListener<com.motiv.example.UsersResponse> {
            override fun onSuccess(argument0: com.motiv.example.UsersResponse) {
                usersListAdapter.setData(argument0.getResult())
                Toast.makeText(activity!!, argument0.getMeta().getMessage(), Toast.LENGTH_LONG).show()
            } override fun onError(argument0: Exception) {
                Toast.makeText(activity!!, "error fetching data", Toast.LENGTH_LONG).show()
            } 
        })
        usersListAdapter.setOnItemClickListener(object : com.motiv.example.UsersListAdapter.OnItemClickListener {
            override fun onItemClick(argument0: Int, argument1: com.motiv.example.User) {
                navigationController.startUserActivity(argument1)
            } 
        })

        return usersfragmentBinding.getRoot()
    }
}
