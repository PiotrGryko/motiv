 
package com.motiv.example.dao
import androidx.fragment.app.*
import androidx.room.*
import com.motiv.example.Meta
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List
@Dao
public interface MetaDao {

    @Insert
    public fun saveMeta(meta: com.motiv.example.Meta): Long@Delete
    public fun deleteMeta(meta: com.motiv.example.Meta): Int@Query("SELECT * FROM meta")
    public fun getMetas(): List<Meta>@Query("SELECT * FROM meta WHERE id = :id")
    public fun getMeta(id: String): Meta@Insert(onConflict = OnConflictStrategy.REPLACE)
    public fun saveMetas(meta: List<com.motiv.example.Meta>): Unit
}
