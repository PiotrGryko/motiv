 
package com.motiv.example.dao
import androidx.fragment.app.*
import androidx.room.*
import com.motiv.example.Links
import com.motiv.example.LinksWithReferences
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List
@Dao
public interface LinksDao {

    @Insert
    public fun saveLinks(links: com.motiv.example.Links): Long@Delete
    public fun deleteLinks(links: com.motiv.example.Links): Int@Query("SELECT * FROM links")
    @Transaction
    public fun getLinkss(): List<LinksWithReferences>@Query("SELECT * FROM links WHERE id = :id")
    @Transaction
    public fun getLinks(id: String): LinksWithReferences@Insert(onConflict = OnConflictStrategy.REPLACE)
    public fun saveLinkss(links: List<com.motiv.example.Links>): Unit
}
