 
package com.motiv.example
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.databinding.BindingAdapter
import androidx.room.*
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import com.squareup.picasso.Picasso
import java.util.*
import java.util.concurrent.*
@Entity(tableName = "meta")
public class Meta {

    @NonNull
    @PrimaryKey

    private var id: String = UUID.randomUUID().toString()
    @ColumnInfo(name = "code")
    @SerializedName("code")
    private var code: Int = 0
    @ColumnInfo(name = "success")
    @SerializedName("success")
    private var success: Boolean = false
    @ColumnInfo(name = "message")
    @SerializedName("message")
    private var message: String = ""

    fun getId(): String {
        return this.id
    } fun setId(id: String) {
        this.id = id
    } fun getCode(): Int {
        return this.code
    } fun setCode(code: Int) {
        this.code = code
    } fun getSuccess(): Boolean {
        return this.success
    } fun setSuccess(success: Boolean) {
        this.success = success
    } fun getMessage(): String {
        return this.message
    } fun setMessage(message: String) {
        this.message = message
    } @BindingAdapter("bind:imageUrl")
    fun loadImage(view: ImageView, url: String) {
        Picasso.with(view.getContext()).load(url).into(view)
    } companion object {
        val gson: Gson = Gson()
        fun fromJson(json: String): Meta {
            return gson.fromJson(json, Meta::class.java)
        }

        fun toJson(obj: Meta): String {
            return gson.toJson(obj, Meta::class.java)
        }

        fun toJsonArray(obj: Meta): String {
            return gson.toJson(obj, Array<Meta>::class.java)
        }

        fun fromJsonArray(json: String): Array<Meta> {
            return gson.fromJson(json, Array<Meta>::class.java)
        }
    }
}
