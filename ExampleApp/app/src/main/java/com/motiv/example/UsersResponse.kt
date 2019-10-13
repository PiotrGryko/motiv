 
package com.motiv.example
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.databinding.BindingAdapter
import androidx.fragment.app.*
import androidx.room.*
import com.bumptech.glide.Glide
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import dagger.*
import dagger.android.*
import dagger.android.support.*
import java.util.*
import java.util.concurrent.*
import javax.inject.*
import kotlin.collections.List
@Entity(tableName = "usersresponse")
public class UsersResponse {

    @NonNull
    @PrimaryKey

    private var id: String = UUID.randomUUID().toString()
    @ColumnInfo(name = "metaId")@ForeignKey(entity = com.motiv.example.Meta::class, parentColumns = ["id"], childColumns = ["metaId"])
    private
    var metaId: String = ""
    @Ignore
    @SerializedName("result")
    private var result: List<com.motiv.example.User> = listOf()
    @Ignore
    @SerializedName("_meta")
    private var meta: com.motiv.example.Meta = com.motiv.example.Meta()

    fun getId(): String {
        return this.id
    } fun setId(id: String) {
        this.id = id
    } fun getResult(): List<com.motiv.example.User> {
        return this.result
    } fun setResult(result: List<com.motiv.example.User>) {
        this.result = result
    } fun getMeta(): com.motiv.example.Meta {
        return this.meta
    } fun setMeta(meta: com.motiv.example.Meta) {
        this.meta = meta
    } @BindingAdapter("bind:imageUrl")
    fun loadImage(view: ImageView, url: String) {
        Glide.with(view.getContext())
            .load(url)
            .into(view)
    } companion object {
        val gson: Gson = Gson()
        fun fromJson(json: String): UsersResponse {
            return gson.fromJson(json, UsersResponse::class.java)
        }

        fun toJson(obj: UsersResponse): String {
            return gson.toJson(obj, UsersResponse::class.java)
        }

        fun toJsonArray(obj: UsersResponse): String {
            return gson.toJson(obj, Array<UsersResponse>::class.java)
        }

        fun fromJsonArray(json: String): Array<UsersResponse> {
            return gson.fromJson(json, Array<UsersResponse>::class.java)
        }
    } public fun getMetaId(): String { return this.metaId; }; public fun setMetaId(metaId: String) { this.metaId = metaId; }
}
