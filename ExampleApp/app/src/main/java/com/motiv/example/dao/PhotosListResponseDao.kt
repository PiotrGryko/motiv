 
package com.motiv.example.dao
import androidx.fragment.app.*
import androidx.room.*
import com.motiv.example.PhotosListResponse
import com.motiv.example.PhotosListResponseWithReferences
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List
@Dao
public interface PhotosListResponseDao {

    @Insert
    public fun savePhotosListResponse(photosListResponse: com.motiv.example.PhotosListResponse): Long@Delete
    public fun deletePhotosListResponse(photosListResponse: com.motiv.example.PhotosListResponse): Int@Query("SELECT * FROM photosListResponse")
    @Transaction
    public fun getPhotosListResponses(): List<PhotosListResponseWithReferences>@Query("SELECT * FROM photosListResponse WHERE id = :id")
    @Transaction
    public fun getPhotosListResponse(id: String): PhotosListResponseWithReferences@Insert(onConflict = OnConflictStrategy.REPLACE)
    public fun savePhotosListResponses(photosListResponse: List<com.motiv.example.PhotosListResponse>): Unit
}
