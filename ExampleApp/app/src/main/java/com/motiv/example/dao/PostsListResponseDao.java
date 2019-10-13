package com.motiv.example.dao;

import androidx.room.*;
import com.motiv.example.PostsListResponseWithReferences;

@Dao
public interface PostsListResponseDao {

    @Insert
    public long savePostsListResponse(com.motiv.example.PostsListResponse postsListResponse);

    @Delete
    public int deletePostsListResponse(com.motiv.example.PostsListResponse postsListResponse);

    @Query("SELECT * FROM postsListResponse")
    @Transaction
    public java.util.List<PostsListResponseWithReferences> getPostsListResponses();

    @Query("SELECT * FROM postsListResponse WHERE id = :id")
    @Transaction
    public PostsListResponseWithReferences getPostsListResponse(java.lang.String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void savePostsListResponses(
            java.util.List<com.motiv.example.PostsListResponse> postsListResponse);
}
