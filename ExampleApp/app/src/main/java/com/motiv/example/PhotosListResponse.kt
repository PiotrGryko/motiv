 
package com.motiv.example
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.databinding.BindingAdapter
import androidx.room.*
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import com.squareup.picasso.Picasso
import java.util.*
import java.util.concurrent.*
import kotlin.collections.List
@Entity(tableName = "photoslistresponse")
public class PhotosListResponse {

    @NonNull
    @PrimaryKey

    private var id: String = UUID.randomUUID().toString()
    @ColumnInfo(name = "metaId")@ForeignKey(entity = com.motiv.example.Meta::class, parentColumns = ["id"], childColumns = ["metaId"])
    private
    var metaId: String = ""
    @Ignore
    @SerializedName("result")
    private var result: List<com.motiv.example.Photo> = listOf()
    @Ignore
    @SerializedName("_meta")
    private var meta: com.motiv.example.Meta = com.motiv.example.Meta()

    fun getId(): String {
        return this.id
    } fun setId(id: String) {
        this.id = id
    } fun getResult(): List<com.motiv.example.Photo> {
        return this.result
    } fun setResult(result: List<com.motiv.example.Photo>) {
        this.result = result
    } fun getMeta(): com.motiv.example.Meta {
        return this.meta
    } fun setMeta(meta: com.motiv.example.Meta) {
        this.meta = meta
    } @BindingAdapter("bind:imageUrl")
    fun loadImage(view: ImageView, url: String) {
        Picasso.with(view.getContext()).load(url).into(view)
    } companion object {
        val gson: Gson = Gson()
        fun fromJson(json: String): PhotosListResponse {
            return gson.fromJson(json, PhotosListResponse::class.java)
        }

        fun toJson(obj: PhotosListResponse): String {
            return gson.toJson(obj, PhotosListResponse::class.java)
        }

        fun toJsonArray(obj: PhotosListResponse): String {
            return gson.toJson(obj, Array<PhotosListResponse>::class.java)
        }

        fun fromJsonArray(json: String): Array<PhotosListResponse> {
            return gson.fromJson(json, Array<PhotosListResponse>::class.java)
        }
    } public fun getMetaId(): String { return this.metaId; }; public fun setMetaId(metaId: String) { this.metaId = metaId; }
}
