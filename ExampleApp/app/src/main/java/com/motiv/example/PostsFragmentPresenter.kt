 
package com.motiv.example
import androidx.fragment.app.*
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.LocalStorage
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List

public class PostsFragmentPresenter(val view: PostsFragmentContract.View, val goApi: GoApi, val authApi: AuthApi, val daoRepository: DaoRepository, val localStorage: LocalStorage) : PostsFragmentContract.Presenter {

    override fun goApigetPostsList() {
        goApi.getPostsList(object : com.motiv.example.OnResponseListener<com.motiv.example.PostsListResponse> {
            override fun onSuccess(argument0: com.motiv.example.PostsListResponse) {
                daoRepository.savePosts(
                    argument0.getResult(),
                    object : com.motiv.example.OnResponseListener<List<com.motiv.example.Post>> {
                        override fun onSuccess(argument0: List<com.motiv.example.Post>) {
                            view.postsAdaptersetData(argument0)
                        } override fun onError(argument0: Exception) {
                        } 
                    }
                )
            } override fun onError(argument0: Exception) {
            } 
        })
    } override fun eloonItemClick(argument0: Int, argument1: com.motiv.example.Post) {
        view.navigationControllerstartPostDetailsActivity(argument1.getId())
    }
}
