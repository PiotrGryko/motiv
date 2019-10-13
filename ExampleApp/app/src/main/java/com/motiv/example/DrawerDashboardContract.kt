 
package com.motiv.example
import androidx.fragment.app.*
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*

public interface DrawerDashboardContract {

    public interface View {

        public fun navigationControllerstartUserActivity(arg0: com.motiv.example.User): Unit
        public fun getuser(): com.motiv.example.User
        public fun navigationControllerstartDestinationById(arg0: Int): Unit
    }

    public interface Presenter {

        public fun eloonClick(argument0: android.view.View): Unit
        public fun eloonNavigationItemSelected(argument0: android.view.MenuItem): Unit
    }
}
