 
package com.motiv.example.dao
import androidx.room.*
import com.motiv.example.UserResponse
import com.motiv.example.UserResponseWithReferences
import kotlin.collections.List
@Dao
public interface UserResponseDao {

    @Insert
    public fun saveUserResponse(userResponse: com.motiv.example.UserResponse): Long@Delete
    public fun deleteUserResponse(userResponse: com.motiv.example.UserResponse): Int@Query("SELECT * FROM userResponse")
    @Transaction
    public fun getUserResponses(): List<UserResponseWithReferences>@Query("SELECT * FROM userResponse WHERE id = :id")
    @Transaction
    public fun getUserResponse(id: String): UserResponseWithReferences@Insert(onConflict = OnConflictStrategy.REPLACE)
    public fun saveUserResponses(userResponse: List<com.motiv.example.UserResponse>): Unit
}
