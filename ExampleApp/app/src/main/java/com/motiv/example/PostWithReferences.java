package com.motiv.example;

import androidx.room.*;

public class PostWithReferences {

    @Embedded private com.motiv.example.Post post;

    @Relation(entity = com.motiv.example.Links.class, parentColumn = "linksId", entityColumn = "id")
    public java.util.List<com.motiv.example.Links> links;

    public Post getPost() {
        if (links.size() > 0) {
            post.setLinks(links.get(0));
        }

        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
