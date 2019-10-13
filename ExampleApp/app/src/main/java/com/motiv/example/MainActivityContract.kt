 
package com.motiv.example
import androidx.fragment.app.*
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*

public interface MainActivityContract {

    public interface View {

        public fun edittext10getText(): CharSequence
        public fun showToast(arg0: String): Unit
        public fun navigationControllerstartDrawerDashboard(arg0: com.motiv.example.User): Unit
    }

    public interface Presenter {

        public fun eloonClick(argument0: android.view.View): Unit
    }
}
