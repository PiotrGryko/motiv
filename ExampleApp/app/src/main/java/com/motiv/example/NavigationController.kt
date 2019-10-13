 
package com.motiv.example
import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.fragment.app.*
import androidx.navigation.Navigation
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*

public class NavigationController {

    private var context: Activity

    private var view: View? = null

    constructor(context: Activity) {
        this.context = context
        this.view = context.findViewById(R.id.nav_host_fragment)
    }

    fun startDrawerDashboard(user: com.motiv.example.User) {
        val intent = Intent(context, DrawerDashboard::class.java)
        intent.putExtra("user", com.motiv.example.User.toJson(user))

        context.startActivity(intent)
    } fun startUserActivity(userArgument: com.motiv.example.User) {
        val intent = Intent(context, UserActivity::class.java)
        intent.putExtra("userArgument", com.motiv.example.User.toJson(userArgument))

        context.startActivity(intent)
    } fun startUsersFragment() {
        Navigation.findNavController(view!!).navigate(R.id.UsersFragment)
    } fun startPostsFragment() {
        Navigation.findNavController(view!!).navigate(R.id.PostsFragment)
    } fun startPostDetailsActivity(postId: String) {
        val intent = Intent(context, PostDetailsActivity::class.java)
        intent.putExtra("postId", postId)

        context.startActivity(intent)
    } fun startPhotosFragment() {
        Navigation.findNavController(view!!).navigate(R.id.PhotosFragment)
    } fun startBottomNavigationDashboard() {
        val intent = Intent(context, BottomNavigationDashboard::class.java)

        context.startActivity(intent)
    } fun startViewPagerActivity() {
        val intent = Intent(context, ViewPagerActivity::class.java)

        context.startActivity(intent)
    } fun startDestinationById(id: Int?) {
        if (id == R.id.BottomNavigationDashboard) {
            val intent = Intent(context, BottomNavigationDashboard::class.java)
            context.startActivity(intent)
        }

        if (id == R.id.ViewPagerActivity) {
            val intent = Intent(context, ViewPagerActivity::class.java)
            context.startActivity(intent)
        }

        if (id == R.id.UsersFragment) {
            Navigation.findNavController(view!!).navigate(R.id.UsersFragment)
        }

        if (id == R.id.PostsFragment) {
            Navigation.findNavController(view!!).navigate(R.id.PostsFragment)
        }

        if (id == R.id.PhotosFragment) {
            Navigation.findNavController(view!!).navigate(R.id.PhotosFragment)
        }
    }
}
