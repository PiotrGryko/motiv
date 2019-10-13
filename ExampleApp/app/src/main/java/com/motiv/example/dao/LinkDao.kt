 
package com.motiv.example.dao
import androidx.room.*
import com.motiv.example.Link
import kotlin.collections.List
@Dao
public interface LinkDao {

    @Insert
    public fun saveLink(link: com.motiv.example.Link): Long@Delete
    public fun deleteLink(link: com.motiv.example.Link): Int@Query("SELECT * FROM link")
    public fun getLinks(): List<Link>@Query("SELECT * FROM link WHERE id = :id")
    public fun getLink(id: String): Link@Insert(onConflict = OnConflictStrategy.REPLACE)
    public fun saveLinks(link: List<com.motiv.example.Link>): Unit
}
