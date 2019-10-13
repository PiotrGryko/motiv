 
package com.motiv.example
import androidx.fragment.app.*
import androidx.room.*
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List

public class PhotosListResponseWithReferences {

    @Embedded
    private lateinit var photosListResponse: com.motiv.example.PhotosListResponse

    @Relation(entity = com.motiv.example.Meta::class, parentColumn = "metaId", entityColumn = "id")

    public var meta: List<com.motiv.example.Meta> = arrayListOf()
    @Relation(entity = com.motiv.example.Photo::class, parentColumn = "id", entityColumn = "resultOwnerId")
    public var result: List<com.motiv.example.Photo> = arrayListOf()

    fun getPhotosListResponse(): PhotosListResponse {
        if (meta.size > 0) {
            photosListResponse.setMeta(meta.get(0))
        }
        photosListResponse.setResult(result)

        return photosListResponse
    } public fun setPhotosListResponse(photosListResponse: PhotosListResponse) { this.photosListResponse = photosListResponse; }
}
