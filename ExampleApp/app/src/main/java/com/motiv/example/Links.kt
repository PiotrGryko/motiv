 
package com.motiv.example
import androidx.annotation.NonNull
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import io.realm.*
import java.util.*
import java.util.concurrent.*

public open class Links : RealmObject() {

    @NonNull private var id: String = UUID.randomUUID().toString()

    @SerializedName("edit")

    private var edit: com.motiv.example.Link = com.motiv.example.Link()

    @SerializedName("self")

    private var self: com.motiv.example.Link = com.motiv.example.Link()

    @SerializedName("avatar")

    private var avatar: com.motiv.example.Link = com.motiv.example.Link()

    fun getId(): String {
        return this.id
    } fun setId(id: String) {
        this.id = id
    } fun getEdit(): com.motiv.example.Link {
        return this.edit
    } fun setEdit(edit: com.motiv.example.Link) {
        this.edit = edit
    } fun getSelf(): com.motiv.example.Link {
        return this.self
    } fun setSelf(self: com.motiv.example.Link) {
        this.self = self
    } fun getAvatar(): com.motiv.example.Link {
        return this.avatar
    } fun setAvatar(avatar: com.motiv.example.Link) {
        this.avatar = avatar
    } companion object {
        val gson: Gson = Gson()
        fun fromJson(json: String): Links {
            return gson.fromJson(json, Links::class.java)
        }

        fun toJson(obj: Links): String {
            return gson.toJson(obj, Links::class.java)
        }

        fun toJsonArray(obj: Links): String {
            return gson.toJson(obj, Array<Links>::class.java)
        }

        fun fromJsonArray(json: String): Array<Links> {
            return gson.fromJson(json, Array<Links>::class.java)
        }
    }
}
