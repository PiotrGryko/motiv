 
package com.motiv.example.dao
import androidx.fragment.app.*
import androidx.room.*
import com.motiv.example.UsersResponse
import com.motiv.example.UsersResponseWithReferences
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List
@Dao
public interface UsersResponseDao {

    @Insert
    public fun saveUsersResponse(usersResponse: com.motiv.example.UsersResponse): Long@Delete
    public fun deleteUsersResponse(usersResponse: com.motiv.example.UsersResponse): Int@Query("SELECT * FROM usersResponse")
    @Transaction
    public fun getUsersResponses(): List<UsersResponseWithReferences>@Query("SELECT * FROM usersResponse WHERE id = :id")
    @Transaction
    public fun getUsersResponse(id: String): UsersResponseWithReferences@Insert(onConflict = OnConflictStrategy.REPLACE)
    public fun saveUsersResponses(usersResponse: List<com.motiv.example.UsersResponse>): Unit
}
