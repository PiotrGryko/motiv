package com.motiv.example;

import androidx.fragment.app.*;
import androidx.room.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class UserWithReferences {

    @Embedded private com.motiv.example.User user;

    @Relation(entity = com.motiv.example.Links.class, parentColumn = "linksId", entityColumn = "id")
    public java.util.List<com.motiv.example.Links> links;

    public User getUser() {
        if (links.size() > 0) {
            user.setLinks(links.get(0));
        }

        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
