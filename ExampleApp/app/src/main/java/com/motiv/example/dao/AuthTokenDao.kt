 
package com.motiv.example.dao
import androidx.room.*
import com.motiv.example.AuthToken
import kotlin.collections.List
@Dao
public interface AuthTokenDao {

    @Insert
    public fun saveAuthToken(authToken: com.motiv.example.AuthToken): Long@Delete
    public fun deleteAuthToken(authToken: com.motiv.example.AuthToken): Int@Query("SELECT * FROM authToken")
    public fun getAuthTokens(): List<AuthToken>@Query("SELECT * FROM authToken WHERE id = :id")
    public fun getAuthToken(id: String): AuthToken@Insert(onConflict = OnConflictStrategy.REPLACE)
    public fun saveAuthTokens(authToken: List<com.motiv.example.AuthToken>): Unit
}
