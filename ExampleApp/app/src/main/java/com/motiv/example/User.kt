 
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

public open class User : RealmObject() {

    @NonNull private var id: String = UUID.randomUUID().toString()

    @SerializedName("website")

    private var website: String = ""

    @SerializedName("address")

    private var address: String = ""

    @SerializedName("gender")

    private var gender: String = ""

    @SerializedName("phone")

    private var phone: String = ""

    @SerializedName("_links")

    private var links: com.motiv.example.Links = com.motiv.example.Links()

    @SerializedName("dob")

    private var dob: String = ""

    @SerializedName("last_name")

    private var last_name: String = ""

    @SerializedName("first_name")

    private var first_name: String = ""

    @SerializedName("email")

    private var email: String = ""

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
    } @BindingAdapter("bind:imageUrl")
    fun loadImage(view: ImageView, url: String) {
        Glide.with(view.getContext())
            .load(url)
            .into(view)
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
    }
}
