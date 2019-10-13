package com.motiv.example;

import androidx.room.*;

public class UserResponseWithReferences {

    @Embedded private com.motiv.example.UserResponse userResponse;

    @Relation(entity = com.motiv.example.User.class, parentColumn = "resultId", entityColumn = "id")
    public java.util.List<com.motiv.example.User> result;

    @Relation(entity = com.motiv.example.Meta.class, parentColumn = "metaId", entityColumn = "id")
    public java.util.List<com.motiv.example.Meta> meta;

    public UserResponse getUserResponse() {
        if (result.size() > 0) {
            userResponse.setResult(result.get(0));
        }
        if (meta.size() > 0) {
            userResponse.setMeta(meta.get(0));
        }

        return userResponse;
    }

    public void setUserResponse(UserResponse userResponse) {
        this.userResponse = userResponse;
    }
}
