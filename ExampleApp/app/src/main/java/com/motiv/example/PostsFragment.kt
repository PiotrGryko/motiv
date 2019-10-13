 
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
import com.motiv.example.dao.DaoRepositoryFactory
import com.motiv.example.dao.LocalStorage
import kotlin.collections.List
import kotlinx.android.synthetic.main.postsfragment.*

public class PostsFragment : Fragment() {

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
        val v: View = inflater.inflate(R.layout.postsfragment, parent, false)

        usersListAdapter = UsersListAdapter()
        postsAdapter = PostsAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        viewPagerFragmentsAdapter = ViewPagerFragmentsAdapter(activity!!.getSupportFragmentManager())
        daoRepository = DaoRepositoryFactory.getInstance(activity!!)
        localStorage = LocalStorage.getInstance(activity!!)
        navigationController = NavigationController(activity!!)
        goApi = GoApiFactory.getInstance(localStorage)
        authApi = AuthApiFactory.getInstance(localStorage)
        linearlayout00 = v.findViewById<LinearLayout>(R.id.linearlayout00)
        recyclerview10 = v.findViewById<RecyclerView>(R.id.recyclerview10)

        recyclerview10?.setLayoutManager(LinearLayoutManager(activity!!))

        recyclerview10?.setAdapter(postsAdapter)
        goApi.getPostsList(object : com.motiv.example.OnResponseListener<com.motiv.example.PostsListResponse> {
            override fun onSuccess(argument0: com.motiv.example.PostsListResponse) {
                daoRepository.savePosts(
                    argument0.getResult(),
                    object : com.motiv.example.OnResponseListener<List<com.motiv.example.Post>> {
                        override fun onSuccess(argument0: List<com.motiv.example.Post>) {
                            postsAdapter.setData(argument0)
                        } override fun onError(argument0: Exception) {
                        } 
                    }
                )
            } override fun onError(argument0: Exception) {
            } 
        })
        postsAdapter.setOnItemClickListener(object : com.motiv.example.PostsAdapter.OnItemClickListener {
            override fun onItemClick(argument0: Int, argument1: com.motiv.example.Post) {
                navigationController.startPostDetailsActivity(argument1.getId())
            } 
        })

        return v
    }
}
