 
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
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List
import kotlinx.android.synthetic.main.postsfragment.*

public class PostsFragment : Fragment() {

    private lateinit var postsfragmentBinding: PostsfragmentBinding

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

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

    private lateinit var recyclerview10: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    } override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup?, savedInstanceState: Bundle?): View {
        postsfragmentBinding = PostsfragmentBinding.inflate(inflater)

        usersListAdapter = UsersListAdapter()
        postsAdapter = PostsAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        viewPagerFragmentsAdapter = ViewPagerFragmentsAdapter(activity!!.getSupportFragmentManager())
        navigationController = NavigationController(activity!!)
        linearlayout00 = postsfragmentBinding.linearlayout00
        recyclerview10 = postsfragmentBinding.recyclerview10

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

        return postsfragmentBinding.getRoot()
    }
}
