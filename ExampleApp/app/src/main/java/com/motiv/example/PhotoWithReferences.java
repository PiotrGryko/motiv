package com.motiv.example;

import androidx.fragment.app.*;
import androidx.room.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class PhotoWithReferences {

    @Embedded private com.motiv.example.Photo photo;

    @Relation(entity = com.motiv.example.Links.class, parentColumn = "linksId", entityColumn = "id")
    public java.util.List<com.motiv.example.Links> links;

    public Photo getPhoto() {
        if (links.size() > 0) {
            photo.setLinks(links.get(0));
        }

        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
}
