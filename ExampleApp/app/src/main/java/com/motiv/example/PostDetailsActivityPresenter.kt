 
package com.motiv.example
import androidx.fragment.app.*
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.LocalStorage
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*

public class PostDetailsActivityPresenter(val view: PostDetailsActivityContract.View, val goApi: GoApi, val authApi: AuthApi, val daoRepository: DaoRepository, val localStorage: LocalStorage) : PostDetailsActivityContract.Presenter {

    override fun daoRepositoryloadPost(arg0: String) {
        daoRepository.loadPost(
            arg0,
            object : com.motiv.example.OnResponseListener<com.motiv.example.Post> {
                override fun onSuccess(argument0: com.motiv.example.Post) {
                    view.textview10setText(argument0.getTitle())
                    view.textview11setText(argument0.getBody())
                } override fun onError(argument0: Exception) {
                } 
            }
        )
    }
}
