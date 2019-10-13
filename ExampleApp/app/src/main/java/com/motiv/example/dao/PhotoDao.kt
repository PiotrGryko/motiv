 
package com.motiv.example.dao
import androidx.fragment.app.*
import androidx.room.*
import com.motiv.example.Photo
import com.motiv.example.PhotoWithReferences
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List
@Dao
public interface PhotoDao {

    @Insert
    public fun savePhoto(photo: com.motiv.example.Photo): Long@Delete
    public fun deletePhoto(photo: com.motiv.example.Photo): Int@Query("SELECT * FROM photo")
    @Transaction
    public fun getPhotos(): List<PhotoWithReferences>@Query("SELECT * FROM photo WHERE id = :id")
    @Transaction
    public fun getPhoto(id: String): PhotoWithReferences@Insert(onConflict = OnConflictStrategy.REPLACE)
    public fun savePhotos(photo: List<com.motiv.example.Photo>): Unit
}
