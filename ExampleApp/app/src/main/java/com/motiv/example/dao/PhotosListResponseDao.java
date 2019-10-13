package com.motiv.example.dao;

import androidx.room.*;
import com.motiv.example.PhotosListResponseWithReferences;

@Dao
public interface PhotosListResponseDao {

    @Insert
    public long savePhotosListResponse(com.motiv.example.PhotosListResponse photosListResponse);

    @Delete
    public int deletePhotosListResponse(com.motiv.example.PhotosListResponse photosListResponse);

    @Query("SELECT * FROM photosListResponse")
    @Transaction
    public java.util.List<PhotosListResponseWithReferences> getPhotosListResponses();

    @Query("SELECT * FROM photosListResponse WHERE id = :id")
    @Transaction
    public PhotosListResponseWithReferences getPhotosListResponse(java.lang.String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void savePhotosListResponses(
            java.util.List<com.motiv.example.PhotosListResponse> photosListResponse);
}
