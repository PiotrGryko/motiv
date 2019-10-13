 
package com.motiv.example
import kotlin.collections.List

public interface UsersFragmentContract {

    public interface View {

        public fun usersListAdaptersetData(arg0: List<com.motiv.example.User>): Unit
        public fun showToast(arg0: String): Unit
        public fun navigationControllerstartUserActivity(arg0: com.motiv.example.User): Unit
    }

    public interface Presenter {

        public fun goApigetUsersList(): Unit
        public fun eloonItemClick(argument0: Int, argument1: com.motiv.example.User): Unit
    }
}
