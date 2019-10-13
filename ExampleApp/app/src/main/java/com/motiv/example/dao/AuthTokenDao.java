package com.motiv.example.dao;

import androidx.room.*;
import com.motiv.example.AuthToken;

@Dao
public interface AuthTokenDao {

    @Insert
    public long saveAuthToken(com.motiv.example.AuthToken authToken);

    @Delete
    public int deleteAuthToken(com.motiv.example.AuthToken authToken);

    @Query("SELECT * FROM authToken")
    public java.util.List<AuthToken> getAuthTokens();

    @Query("SELECT * FROM authToken WHERE id = :id")
    public AuthToken getAuthToken(java.lang.String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void saveAuthTokens(java.util.List<com.motiv.example.AuthToken> authToken);
}
