 
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

public open class Photo : RealmObject() {

    @NonNull private var id: String = UUID.randomUUID().toString()

    @SerializedName("thumbnail")

    private var thumbnail: String = ""

    @SerializedName("_links")

    private var links: com.motiv.example.Links = com.motiv.example.Links()

    @SerializedName("album_id")

    private var album_id: String = ""

    @SerializedName("title")

    private var title: String = ""

    @SerializedName("url")

    private var url: String = ""

    fun getId(): String {
        return this.id
    } fun setId(id: String) {
        this.id = id
    } fun getThumbnail(): String {
        return this.thumbnail
    } fun setThumbnail(thumbnail: String) {
        this.thumbnail = thumbnail
    } fun getLinks(): com.motiv.example.Links {
        return this.links
    } fun setLinks(links: com.motiv.example.Links) {
        this.links = links
    } fun getAlbum_id(): String {
        return this.album_id
    } fun setAlbum_id(album_id: String) {
        this.album_id = album_id
    } fun getTitle(): String {
        return this.title
    } fun setTitle(title: String) {
        this.title = title
    } fun getUrl(): String {
        return this.url
    } fun setUrl(url: String) {
        this.url = url
    } @BindingAdapter("bind:imageUrl")
    fun loadImage(view: ImageView, url: String) {
        Glide.with(view.getContext())
            .load(url)
            .into(view)
    } companion object {
        val gson: Gson = Gson()
        fun fromJson(json: String): Photo {
            return gson.fromJson(json, Photo::class.java)
        }

        fun toJson(obj: Photo): String {
            return gson.toJson(obj, Photo::class.java)
        }

        fun toJsonArray(obj: Photo): String {
            return gson.toJson(obj, Array<Photo>::class.java)
        }

        fun fromJsonArray(json: String): Array<Photo> {
            return gson.fromJson(json, Array<Photo>::class.java)
        }
    }
}
