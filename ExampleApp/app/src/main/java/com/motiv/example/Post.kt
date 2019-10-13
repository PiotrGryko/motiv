 
package com.motiv.example
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.databinding.BindingAdapter
import androidx.fragment.app.*
import com.bumptech.glide.Glide
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import dagger.*
import dagger.android.*
import dagger.android.support.*
import io.realm.*
import java.util.*
import java.util.concurrent.*
import javax.inject.*

public open class Post : RealmObject() {

    @NonNull private var id: String = UUID.randomUUID().toString()

    @SerializedName("user_id")

    private var user_id: String = ""

    @SerializedName("_links")

    private var links: com.motiv.example.Links = com.motiv.example.Links()

    @SerializedName("title")

    private var title: String = ""

    @SerializedName("body")

    private var body: String = ""

    fun getId(): String {
        return this.id
    } fun setId(id: String) {
        this.id = id
    } fun getUser_id(): String {
        return this.user_id
    } fun setUser_id(user_id: String) {
        this.user_id = user_id
    } fun getLinks(): com.motiv.example.Links {
        return this.links
    } fun setLinks(links: com.motiv.example.Links) {
        this.links = links
    } fun getTitle(): String {
        return this.title
    } fun setTitle(title: String) {
        this.title = title
    } fun getBody(): String {
        return this.body
    } fun setBody(body: String) {
        this.body = body
    } @BindingAdapter("bind:imageUrl")
    fun loadImage(view: ImageView, url: String) {
        Glide.with(view.getContext())
            .load(url)
            .into(view)
    } companion object {
        val gson: Gson = Gson()
        fun fromJson(json: String): Post {
            return gson.fromJson(json, Post::class.java)
        }

        fun toJson(obj: Post): String {
            return gson.toJson(obj, Post::class.java)
        }

        fun toJsonArray(obj: Post): String {
            return gson.toJson(obj, Array<Post>::class.java)
        }

        fun fromJsonArray(json: String): Array<Post> {
            return gson.fromJson(json, Array<Post>::class.java)
        }
    }
}
