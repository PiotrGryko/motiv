 
package com.motiv.example.dao
import androidx.fragment.app.*
import androidx.room.*
import com.motiv.example.Post
import com.motiv.example.PostWithReferences
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List
@Dao
public interface PostDao {

    @Insert
    public fun savePost(post: com.motiv.example.Post): Long@Delete
    public fun deletePost(post: com.motiv.example.Post): Int@Query("SELECT * FROM post")
    @Transaction
    public fun getPosts(): List<PostWithReferences>@Query("SELECT * FROM post WHERE id = :id")
    @Transaction
    public fun getPost(id: String): PostWithReferences@Insert(onConflict = OnConflictStrategy.REPLACE)
    public fun savePosts(post: List<com.motiv.example.Post>): Unit
}
