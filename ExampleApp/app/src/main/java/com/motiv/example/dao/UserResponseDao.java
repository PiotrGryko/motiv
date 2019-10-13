package com.motiv.example.dao;

import androidx.room.*;
import com.motiv.example.UserResponseWithReferences;

@Dao
public interface UserResponseDao {

    @Insert
    public long saveUserResponse(com.motiv.example.UserResponse userResponse);

    @Delete
    public int deleteUserResponse(com.motiv.example.UserResponse userResponse);

    @Query("SELECT * FROM userResponse")
    @Transaction
    public java.util.List<UserResponseWithReferences> getUserResponses();

    @Query("SELECT * FROM userResponse WHERE id = :id")
    @Transaction
    public UserResponseWithReferences getUserResponse(java.lang.String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void saveUserResponses(java.util.List<com.motiv.example.UserResponse> userResponse);
}
