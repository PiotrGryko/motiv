package com.motiv.example;

import androidx.room.*;

public class PhotosListResponseWithReferences {

    @Embedded private com.motiv.example.PhotosListResponse photosListResponse;

    @Relation(entity = com.motiv.example.Meta.class, parentColumn = "metaId", entityColumn = "id")
    public java.util.List<com.motiv.example.Meta> meta;

    @Relation(
        entity = com.motiv.example.Photo.class,
        parentColumn = "id",
        entityColumn = "resultOwnerId"
    )
    public java.util.List<com.motiv.example.Photo> result;

    public PhotosListResponse getPhotosListResponse() {
        if (meta.size() > 0) {
            photosListResponse.setMeta(meta.get(0));
        }
        photosListResponse.setResult(result);

        return photosListResponse;
    }

    public void setPhotosListResponse(PhotosListResponse photosListResponse) {
        this.photosListResponse = photosListResponse;
    }
}
