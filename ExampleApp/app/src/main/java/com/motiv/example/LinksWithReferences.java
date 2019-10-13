package com.motiv.example;

import androidx.room.*;

public class LinksWithReferences {

    @Embedded private com.motiv.example.Links links;

    @Relation(entity = com.motiv.example.Link.class, parentColumn = "editId", entityColumn = "id")
    public java.util.List<com.motiv.example.Link> edit;

    @Relation(entity = com.motiv.example.Link.class, parentColumn = "selfId", entityColumn = "id")
    public java.util.List<com.motiv.example.Link> self;

    @Relation(entity = com.motiv.example.Link.class, parentColumn = "avatarId", entityColumn = "id")
    public java.util.List<com.motiv.example.Link> avatar;

    public Links getLinks() {
        if (edit.size() > 0) {
            links.setEdit(edit.get(0));
        }
        if (self.size() > 0) {
            links.setSelf(self.get(0));
        }
        if (avatar.size() > 0) {
            links.setAvatar(avatar.get(0));
        }

        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
