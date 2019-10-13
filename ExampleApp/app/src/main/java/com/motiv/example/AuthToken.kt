 
package com.motiv.example
import androidx.annotation.NonNull
import androidx.room.*
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import java.util.*
import java.util.concurrent.*
@Entity(tableName = "authtoken")
public class AuthToken {

    @NonNull
    @PrimaryKey

    private var id: String = UUID.randomUUID().toString()
    @ColumnInfo(name = "token")
    @SerializedName("token")
    private var token: String = ""

    fun getId(): String {
        return this.id
    } fun setId(id: String) {
        this.id = id
    } fun getToken(): String {
        return this.token
    } fun setToken(token: String) {
        this.token = token
    } companion object {
        val gson: Gson = Gson()
        fun fromJson(json: String): AuthToken {
            return gson.fromJson(json, AuthToken::class.java)
        }

        fun toJson(obj: AuthToken): String {
            return gson.toJson(obj, AuthToken::class.java)
        }

        fun toJsonArray(obj: AuthToken): String {
            return gson.toJson(obj, Array<AuthToken>::class.java)
        }

        fun fromJsonArray(json: String): Array<AuthToken> {
            return gson.fromJson(json, Array<AuthToken>::class.java)
        }
    }
}
