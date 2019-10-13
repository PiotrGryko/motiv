package com.motiv.example;

import androidx.fragment.app.*;
import androidx.room.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class UsersResponseWithReferences {

    @Embedded private com.motiv.example.UsersResponse usersResponse;

    @Relation(entity = com.motiv.example.Meta.class, parentColumn = "metaId", entityColumn = "id")
    public java.util.List<com.motiv.example.Meta> meta;

    @Relation(
        entity = com.motiv.example.User.class,
        parentColumn = "id",
        entityColumn = "resultOwnerId"
    )
    public java.util.List<com.motiv.example.User> result;

    public UsersResponse getUsersResponse() {
        if (meta.size() > 0) {
            usersResponse.setMeta(meta.get(0));
        }
        usersResponse.setResult(result);

        return usersResponse;
    }

    public void setUsersResponse(UsersResponse usersResponse) {
        this.usersResponse = usersResponse;
    }
}
