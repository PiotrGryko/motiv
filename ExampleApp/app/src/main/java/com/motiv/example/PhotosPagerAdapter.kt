 
package com.motiv.example
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import com.squareup.picasso.Picasso
import kotlin.collections.List

public class PhotosPagerAdapter : PagerAdapter() {

    private var data: ArrayList<Photo> = ArrayList()

    private lateinit var linearlayout00: LinearLayout

    private lateinit var imageview10: ImageView

    override fun getCount(): Int {
        return data.size
    } override fun isViewFromObject(view: View, o: Any): Boolean {
        return view == o
    } fun setData(newData: List<com.motiv.example.Photo>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    } override fun destroyItem(container: ViewGroup, position: Int, o: Any) {
        container.removeView(o as View)
    } override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.getContext())
        val v = inflater.inflate(R.layout.photospageradapter, container, false)
        linearlayout00 = v.findViewById<LinearLayout>(R.id.linearlayout00)
        imageview10 = v.findViewById<ImageView>(R.id.imageview10)

        val photo: Photo = data.get(position)

        Picasso.with(container.getContext()).load(photo.getUrl()).into(imageview10)

        container.addView(v)
        return v
    }
}
