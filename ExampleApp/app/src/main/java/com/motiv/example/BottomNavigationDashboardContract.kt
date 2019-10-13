 
package com.motiv.example
import androidx.fragment.app.*
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*

public interface BottomNavigationDashboardContract {

    public interface View {

        public fun navigationControllerstartDestinationById(arg0: Int): Unit
    }

    public interface Presenter {

        public fun eloonNavigationItemSelected(argument0: android.view.MenuItem): Unit
    }
}
