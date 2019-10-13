 
package com.motiv.example
import androidx.annotation.NonNull
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import io.realm.*
import java.util.*
import java.util.concurrent.*

public open class Meta : RealmObject() {

    @NonNull private var id: String = UUID.randomUUID().toString()

    @SerializedName("code")

    private var code: Int = 0

    @SerializedName("success")

    private var success: Boolean = false

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
