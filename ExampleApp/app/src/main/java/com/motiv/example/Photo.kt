 
package com.motiv.example
import androidx.annotation.NonNull
import androidx.room.*
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import java.util.*
import java.util.concurrent.*
@Entity(tableName = "photo")
public class Photo {

    @NonNull
    @PrimaryKey

    private var id: String = UUID.randomUUID().toString()
    @ColumnInfo(name = "resultOwnerId")@ForeignKey(entity = com.motiv.example.PhotosListResponse::class, parentColumns = ["id"], childColumns = ["resultOwnerId"])
    private
    var resultOwnerId: String = ""
    @ColumnInfo(name = "linksId")@ForeignKey(entity = com.motiv.example.Links::class, parentColumns = ["id"], childColumns = ["linksId"])
    private
    var linksId: String = ""
    @ColumnInfo(name = "thumbnail")
    @SerializedName("thumbnail")
    private var thumbnail: String = ""
    @Ignore
    @SerializedName("_links")
    private var links: com.motiv.example.Links = com.motiv.example.Links()
    @ColumnInfo(name = "album_id")
    @SerializedName("album_id")
    private var album_id: String = ""
    @ColumnInfo(name = "title")
    @SerializedName("title")
    private var title: String = ""
    @ColumnInfo(name = "url")
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
    } public fun getResultOwnerId(): String { return this.resultOwnerId; }; public fun setResultOwnerId(resultOwnerId: String) { this.resultOwnerId = resultOwnerId; } public fun getLinksId(): String { return this.linksId; }; public fun setLinksId(linksId: String) { this.linksId = linksId; }
}
