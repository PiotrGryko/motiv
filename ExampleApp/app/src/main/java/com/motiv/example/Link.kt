 
package com.motiv.example
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.databinding.BindingAdapter
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import com.squareup.picasso.Picasso
import io.realm.*
import java.util.*
import java.util.concurrent.*

public open class Link : RealmObject() {

    @NonNull private var id: String = UUID.randomUUID().toString()

    @SerializedName("href")

    private var href: String = ""

    fun getId(): String {
        return this.id
    } fun setId(id: String) {
        this.id = id
    } fun getHref(): String {
        return this.href
    } fun setHref(href: String) {
        this.href = href
    } @BindingAdapter("bind:imageUrl")
    fun loadImage(view: ImageView, url: String) {
        Picasso.with(view.getContext()).load(url).into(view)
    } companion object {
        val gson: Gson = Gson()
        fun fromJson(json: String): Link {
            return gson.fromJson(json, Link::class.java)
        }

        fun toJson(obj: Link): String {
            return gson.toJson(obj, Link::class.java)
        }

        fun toJsonArray(obj: Link): String {
            return gson.toJson(obj, Array<Link>::class.java)
        }

        fun fromJsonArray(json: String): Array<Link> {
            return gson.fromJson(json, Array<Link>::class.java)
        }
    }
}
