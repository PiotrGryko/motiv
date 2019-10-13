package com.motiv.example.dao;

import androidx.fragment.app.*;
import androidx.room.*;
import com.motiv.example.PostWithReferences;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

@Dao
public interface PostDao {

    @Insert
    public long savePost(com.motiv.example.Post post);

    @Delete
    public int deletePost(com.motiv.example.Post post);

    @Query("SELECT * FROM post")
    @Transaction
    public java.util.List<PostWithReferences> getPosts();

    @Query("SELECT * FROM post WHERE id = :id")
    @Transaction
    public PostWithReferences getPost(java.lang.String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void savePosts(java.util.List<com.motiv.example.Post> post);
}
