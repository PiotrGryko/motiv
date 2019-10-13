 
package com.motiv.example
import androidx.fragment.app.*
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List

public interface PostsFragmentContract {

    public interface View {

        public fun postsAdaptersetData(arg0: List<com.motiv.example.Post>): Unit
        public fun navigationControllerstartPostDetailsActivity(arg0: String): Unit
    }

    public interface Presenter {

        public fun goApigetPostsList(): Unit
        public fun eloonItemClick(argument0: Int, argument1: com.motiv.example.Post): Unit
    }
}
