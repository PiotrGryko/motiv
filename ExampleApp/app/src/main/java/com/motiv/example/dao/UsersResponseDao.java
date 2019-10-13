package com.motiv.example.dao;

import androidx.room.*;
import com.motiv.example.UsersResponseWithReferences;

@Dao
public interface UsersResponseDao {

    @Insert
    public long saveUsersResponse(com.motiv.example.UsersResponse usersResponse);

    @Delete
    public int deleteUsersResponse(com.motiv.example.UsersResponse usersResponse);

    @Query("SELECT * FROM usersResponse")
    @Transaction
    public java.util.List<UsersResponseWithReferences> getUsersResponses();

    @Query("SELECT * FROM usersResponse WHERE id = :id")
    @Transaction
    public UsersResponseWithReferences getUsersResponse(java.lang.String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void saveUsersResponses(java.util.List<com.motiv.example.UsersResponse> usersResponse);
}
