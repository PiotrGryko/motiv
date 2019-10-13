package com.motiv.example;

import androidx.room.*;

public class PostsListResponseWithReferences {

    @Embedded private com.motiv.example.PostsListResponse postsListResponse;

    @Relation(entity = com.motiv.example.Meta.class, parentColumn = "metaId", entityColumn = "id")
    public java.util.List<com.motiv.example.Meta> meta;

    @Relation(
        entity = com.motiv.example.Post.class,
        parentColumn = "id",
        entityColumn = "resultOwnerId"
    )
    public java.util.List<com.motiv.example.Post> result;

    public PostsListResponse getPostsListResponse() {
        if (meta.size() > 0) {
            postsListResponse.setMeta(meta.get(0));
        }
        postsListResponse.setResult(result);

        return postsListResponse;
    }

    public void setPostsListResponse(PostsListResponse postsListResponse) {
        this.postsListResponse = postsListResponse;
    }
}
