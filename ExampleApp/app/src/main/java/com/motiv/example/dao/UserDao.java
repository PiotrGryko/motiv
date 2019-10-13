package com.motiv.example.dao;

import androidx.room.*;
import com.motiv.example.UserWithReferences;

@Dao
public interface UserDao {

    @Insert
    public long saveUser(com.motiv.example.User user);

    @Delete
    public int deleteUser(com.motiv.example.User user);

    @Query("SELECT * FROM user")
    @Transaction
    public java.util.List<UserWithReferences> getUsers();

    @Query("SELECT * FROM user WHERE id = :id")
    @Transaction
    public UserWithReferences getUser(java.lang.String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void saveUsers(java.util.List<com.motiv.example.User> user);
}
