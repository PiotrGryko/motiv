 
package com.motiv.example
import androidx.annotation.NonNull
import androidx.fragment.app.*
import androidx.room.*
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import dagger.*
import dagger.android.*
import dagger.android.support.*
import java.util.*
import java.util.concurrent.*
import javax.inject.*
@Entity(tableName = "user")
public class User {

    @NonNull
    @PrimaryKey

    private var id: String = UUID.randomUUID().toString()
    @ColumnInfo(name = "linksId")@ForeignKey(entity = com.motiv.example.Links::class, parentColumns = ["id"], childColumns = ["linksId"])
    private
    var linksId: String = ""
    @ColumnInfo(name = "resultOwnerId")@ForeignKey(entity = com.motiv.example.UsersResponse::class, parentColumns = ["id"], childColumns = ["resultOwnerId"])
    private
    var resultOwnerId: String = ""
    @ColumnInfo(name = "website")
    @SerializedName("website")
    private var website: String = ""
    @ColumnInfo(name = "address")
    @SerializedName("address")
    private var address: String = ""
    @ColumnInfo(name = "gender")
    @SerializedName("gender")
    private var gender: String = ""
    @ColumnInfo(name = "phone")
    @SerializedName("phone")
    private var phone: String = ""
    @Ignore
    @SerializedName("_links")
    private var links: com.motiv.example.Links = com.motiv.example.Links()
    @ColumnInfo(name = "dob")
    @SerializedName("dob")
    private var dob: String = ""
    @ColumnInfo(name = "last_name")
    @SerializedName("last_name")
    private var last_name: String = ""
    @ColumnInfo(name = "first_name")
    @SerializedName("first_name")
    private var first_name: String = ""
    @ColumnInfo(name = "email")
    @SerializedName("email")
    private var email: String = ""
    @ColumnInfo(name = "status")
    @SerializedName("status")
    private var status: String = ""

    fun getId(): String {
        return this.id
    } fun setId(id: String) {
        this.id = id
    } fun getWebsite(): String {
        return this.website
    } fun setWebsite(website: String) {
        this.website = website
    } fun getAddress(): String {
        return this.address
    } fun setAddress(address: String) {
        this.address = address
    } fun getGender(): String {
        return this.gender
    } fun setGender(gender: String) {
        this.gender = gender
    } fun getPhone(): String {
        return this.phone
    } fun setPhone(phone: String) {
        this.phone = phone
    } fun getLinks(): com.motiv.example.Links {
        return this.links
    } fun setLinks(links: com.motiv.example.Links) {
        this.links = links
    } fun getDob(): String {
        return this.dob
    } fun setDob(dob: String) {
        this.dob = dob
    } fun getLast_name(): String {
        return this.last_name
    } fun setLast_name(last_name: String) {
        this.last_name = last_name
    } fun getFirst_name(): String {
        return this.first_name
    } fun setFirst_name(first_name: String) {
        this.first_name = first_name
    } fun getEmail(): String {
        return this.email
    } fun setEmail(email: String) {
        this.email = email
    } fun getStatus(): String {
        return this.status
    } fun setStatus(status: String) {
        this.status = status
    } companion object {
        val gson: Gson = Gson()
        fun fromJson(json: String): User {
            return gson.fromJson(json, User::class.java)
        }

        fun toJson(obj: User): String {
            return gson.toJson(obj, User::class.java)
        }

        fun toJsonArray(obj: User): String {
            return gson.toJson(obj, Array<User>::class.java)
        }

        fun fromJsonArray(json: String): Array<User> {
            return gson.fromJson(json, Array<User>::class.java)
        }
    } public fun getLinksId(): String { return this.linksId; }; public fun setLinksId(linksId: String) { this.linksId = linksId; } public fun getResultOwnerId(): String { return this.resultOwnerId; }; public fun setResultOwnerId(resultOwnerId: String) { this.resultOwnerId = resultOwnerId; }
}
