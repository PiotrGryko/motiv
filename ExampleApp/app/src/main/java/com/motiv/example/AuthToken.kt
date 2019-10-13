 
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

public open class AuthToken : RealmObject() {

    @NonNull private var id: String = UUID.randomUUID().toString()

    @SerializedName("token")

    private var token: String = ""

    fun getId(): String {
        return this.id
    } fun setId(id: String) {
        this.id = id
    } fun getToken(): String {
        return this.token
    } fun setToken(token: String) {
        this.token = token
    } @BindingAdapter("bind:imageUrl")
    fun loadImage(view: ImageView, url: String) {
        Glide.with(view.getContext())
            .load(url)
            .into(view)
    } companion object {
        val gson: Gson = Gson()
        fun fromJson(json: String): AuthToken {
            return gson.fromJson(json, AuthToken::class.java)
        }

        fun toJson(obj: AuthToken): String {
            return gson.toJson(obj, AuthToken::class.java)
        }

        fun toJsonArray(obj: AuthToken): String {
            return gson.toJson(obj, Array<AuthToken>::class.java)
        }

        fun fromJsonArray(json: String): Array<AuthToken> {
            return gson.fromJson(json, Array<AuthToken>::class.java)
        }
    }
}
