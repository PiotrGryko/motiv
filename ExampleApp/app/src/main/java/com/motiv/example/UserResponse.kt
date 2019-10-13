 
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

public open class UserResponse : RealmObject() {

    @NonNull private var id: String = UUID.randomUUID().toString()

    @SerializedName("result")

    private var result: com.motiv.example.User = com.motiv.example.User()

    @SerializedName("_meta")

    private var meta: com.motiv.example.Meta = com.motiv.example.Meta()

    fun getId(): String {
        return this.id
    } fun setId(id: String) {
        this.id = id
    } fun getResult(): com.motiv.example.User {
        return this.result
    } fun setResult(result: com.motiv.example.User) {
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
        fun fromJson(json: String): UserResponse {
            return gson.fromJson(json, UserResponse::class.java)
        }

        fun toJson(obj: UserResponse): String {
            return gson.toJson(obj, UserResponse::class.java)
        }

        fun toJsonArray(obj: UserResponse): String {
            return gson.toJson(obj, Array<UserResponse>::class.java)
        }

        fun fromJsonArray(json: String): Array<UserResponse> {
            return gson.fromJson(json, Array<UserResponse>::class.java)
        }
    }
}
