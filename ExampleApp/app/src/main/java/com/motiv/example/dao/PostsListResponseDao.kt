 
package com.motiv.example.dao
import androidx.fragment.app.*
import androidx.room.*
import com.motiv.example.PostsListResponse
import com.motiv.example.PostsListResponseWithReferences
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List
@Dao
public interface PostsListResponseDao {

    @Insert
    public fun savePostsListResponse(postsListResponse: com.motiv.example.PostsListResponse): Long@Delete
    public fun deletePostsListResponse(postsListResponse: com.motiv.example.PostsListResponse): Int@Query("SELECT * FROM postsListResponse")
    @Transaction
    public fun getPostsListResponses(): List<PostsListResponseWithReferences>@Query("SELECT * FROM postsListResponse WHERE id = :id")
    @Transaction
    public fun getPostsListResponse(id: String): PostsListResponseWithReferences@Insert(onConflict = OnConflictStrategy.REPLACE)
    public fun savePostsListResponses(postsListResponse: List<com.motiv.example.PostsListResponse>): Unit
}
