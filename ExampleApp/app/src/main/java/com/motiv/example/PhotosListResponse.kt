 
package com.motiv.example
import androidx.annotation.NonNull
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import io.realm.*
import java.util.*
import java.util.concurrent.*

public open class PhotosListResponse : RealmObject() {

    @NonNull private var id: String = UUID.randomUUID().toString()

    @SerializedName("result")

    private var result: RealmList<com.motiv.example.Photo> = RealmList()

    @SerializedName("_meta")

    private var meta: com.motiv.example.Meta = com.motiv.example.Meta()

    fun getId(): String {
        return this.id
    } fun setId(id: String) {
        this.id = id
    } fun getResult(): RealmList<com.motiv.example.Photo> {
        return this.result
    } fun setResult(result: RealmList<com.motiv.example.Photo>) {
        this.result = result
    } fun getMeta(): com.motiv.example.Meta {
        return this.meta
    } fun setMeta(meta: com.motiv.example.Meta) {
        this.meta = meta
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
    }
}
