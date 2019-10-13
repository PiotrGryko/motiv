 
package com.motiv.example
import androidx.annotation.NonNull
import androidx.room.*
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import java.util.*
import java.util.concurrent.*
@Entity(tableName = "post")
public class Post {

    @NonNull
    @PrimaryKey

    private var id: String = UUID.randomUUID().toString()
    @ColumnInfo(name = "resultOwnerId")@ForeignKey(entity = com.motiv.example.PostsListResponse::class, parentColumns = ["id"], childColumns = ["resultOwnerId"])
    private
    var resultOwnerId: String = ""
    @ColumnInfo(name = "linksId")@ForeignKey(entity = com.motiv.example.Links::class, parentColumns = ["id"], childColumns = ["linksId"])
    private
    var linksId: String = ""
    @ColumnInfo(name = "user_id")
    @SerializedName("user_id")
    private var user_id: String = ""
    @Ignore
    @SerializedName("_links")
    private var links: com.motiv.example.Links = com.motiv.example.Links()
    @ColumnInfo(name = "title")
    @SerializedName("title")
    private var title: String = ""
    @ColumnInfo(name = "body")
    @SerializedName("body")
    private var body: String = ""

    fun getId(): String {
        return this.id
    } fun setId(id: String) {
        this.id = id
    } fun getUser_id(): String {
        return this.user_id
    } fun setUser_id(user_id: String) {
        this.user_id = user_id
    } fun getLinks(): com.motiv.example.Links {
        return this.links
    } fun setLinks(links: com.motiv.example.Links) {
        this.links = links
    } fun getTitle(): String {
        return this.title
    } fun setTitle(title: String) {
        this.title = title
    } fun getBody(): String {
        return this.body
    } fun setBody(body: String) {
        this.body = body
    } companion object {
        val gson: Gson = Gson()
        fun fromJson(json: String): Post {
            return gson.fromJson(json, Post::class.java)
        }

        fun toJson(obj: Post): String {
            return gson.toJson(obj, Post::class.java)
        }

        fun toJsonArray(obj: Post): String {
            return gson.toJson(obj, Array<Post>::class.java)
        }

        fun fromJsonArray(json: String): Array<Post> {
            return gson.fromJson(json, Array<Post>::class.java)
        }
    } public fun getResultOwnerId(): String { return this.resultOwnerId; }; public fun setResultOwnerId(resultOwnerId: String) { this.resultOwnerId = resultOwnerId; } public fun getLinksId(): String { return this.linksId; }; public fun setLinksId(linksId: String) { this.linksId = linksId; }
}
