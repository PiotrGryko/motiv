 
package com.motiv.example
import androidx.annotation.NonNull
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import io.realm.*
import java.util.*
import java.util.concurrent.*

public open class PostsListResponse : RealmObject() {

    @NonNull private var id: String = UUID.randomUUID().toString()

    @SerializedName("result")

    private var result: RealmList<com.motiv.example.Post> = RealmList()

    @SerializedName("_meta")

    private var meta: com.motiv.example.Meta = com.motiv.example.Meta()

    fun getId(): String {
        return this.id
    } fun setId(id: String) {
        this.id = id
    } fun getResult(): RealmList<com.motiv.example.Post> {
        return this.result
    } fun setResult(result: RealmList<com.motiv.example.Post>) {
        this.result = result
    } fun getMeta(): com.motiv.example.Meta {
        return this.meta
    } fun setMeta(meta: com.motiv.example.Meta) {
        this.meta = meta
    } companion object {
        val gson: Gson = Gson()
        fun fromJson(json: String): PostsListResponse {
            return gson.fromJson(json, PostsListResponse::class.java)
        }

        fun toJson(obj: PostsListResponse): String {
            return gson.toJson(obj, PostsListResponse::class.java)
        }

        fun toJsonArray(obj: PostsListResponse): String {
            return gson.toJson(obj, Array<PostsListResponse>::class.java)
        }

        fun fromJsonArray(json: String): Array<PostsListResponse> {
            return gson.fromJson(json, Array<PostsListResponse>::class.java)
        }
    }
}
