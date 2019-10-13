 
package com.motiv.example
import androidx.fragment.app.*

public class ViewPagerFragmentsAdapter(val fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int {
        return 3
    } override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return UsersFragment()
            1 -> return PostsFragment()
            2 -> return PhotosFragment()
        }
        throw RuntimeException()
    } override fun getPageTitle(position: Int): String {
        when (position) {
            0 -> return "UsersFragment"
            1 -> return "PostsFragment"
            2 -> return "PhotosFragment"
        }
        return ""
    }
}
