 
package com.motiv.example.di
import androidx.fragment.app.*
import com.motiv.example.BottomNavigationDashboard
import com.motiv.example.DrawerDashboard
import com.motiv.example.MainActivity
import com.motiv.example.PhotosFragment
import com.motiv.example.PostDetailsActivity
import com.motiv.example.PostsFragment
import com.motiv.example.UserActivity
import com.motiv.example.UsersFragment
import com.motiv.example.ViewPagerActivity
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
@Module
public abstract class AppContributions {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity@ContributesAndroidInjector
    abstract fun contributeDrawerDashboard(): DrawerDashboard@ContributesAndroidInjector
    abstract fun contributeUserActivity(): UserActivity@ContributesAndroidInjector
    abstract fun contributePostDetailsActivity(): PostDetailsActivity@ContributesAndroidInjector
    abstract fun contributeBottomNavigationDashboard(): BottomNavigationDashboard@ContributesAndroidInjector
    abstract fun contributeViewPagerActivity(): ViewPagerActivity@ContributesAndroidInjector
    abstract fun contributeUsersFragment(): UsersFragment@ContributesAndroidInjector
    abstract fun contributePostsFragment(): PostsFragment@ContributesAndroidInjector
    abstract fun contributePhotosFragment(): PhotosFragment
}
