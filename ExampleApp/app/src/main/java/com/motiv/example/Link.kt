 
package com.motiv.example
import androidx.annotation.NonNull
import androidx.fragment.app.*
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
