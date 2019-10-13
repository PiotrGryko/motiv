 
package com.motiv.example
import androidx.fragment.app.*
import androidx.room.*
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List

public class PostWithReferences {

    @Embedded
    private lateinit var post: com.motiv.example.Post

    @Relation(entity = com.motiv.example.Links::class, parentColumn = "linksId", entityColumn = "id")

    public var links: List<com.motiv.example.Links> = arrayListOf()

    fun getPost(): Post {
        if (links.size > 0) {
            post.setLinks(links.get(0))
        }

        return post
    } public fun setPost(post: Post) { this.post = post; }
}
