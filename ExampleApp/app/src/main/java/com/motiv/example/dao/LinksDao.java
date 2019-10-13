package com.motiv.example.dao;

import androidx.fragment.app.*;
import androidx.room.*;
import com.motiv.example.LinksWithReferences;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

@Dao
public interface LinksDao {

    @Insert
    public long saveLinks(com.motiv.example.Links links);

    @Delete
    public int deleteLinks(com.motiv.example.Links links);

    @Query("SELECT * FROM links")
    @Transaction
    public java.util.List<LinksWithReferences> getLinkss();

    @Query("SELECT * FROM links WHERE id = :id")
    @Transaction
    public LinksWithReferences getLinks(java.lang.String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void saveLinkss(java.util.List<com.motiv.example.Links> links);
}
