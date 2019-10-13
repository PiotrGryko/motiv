 
package com.motiv.example
import androidx.fragment.app.*
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*

public interface PostDetailsActivityContract {

    public interface View {

        public fun textview10setText(arg0: CharSequence): Unit
        public fun textview11setText(arg0: CharSequence): Unit
    }

    public interface Presenter {

        public fun daoRepositoryloadPost(arg0: String): Unit
    }
}
