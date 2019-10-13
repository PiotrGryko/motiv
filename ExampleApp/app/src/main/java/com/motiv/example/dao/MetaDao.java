package com.motiv.example.dao;

import androidx.room.*;
import com.motiv.example.Meta;

@Dao
public interface MetaDao {

    @Insert
    public long saveMeta(com.motiv.example.Meta meta);

    @Delete
    public int deleteMeta(com.motiv.example.Meta meta);

    @Query("SELECT * FROM meta")
    public java.util.List<Meta> getMetas();

    @Query("SELECT * FROM meta WHERE id = :id")
    public Meta getMeta(java.lang.String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void saveMetas(java.util.List<com.motiv.example.Meta> meta);
}
