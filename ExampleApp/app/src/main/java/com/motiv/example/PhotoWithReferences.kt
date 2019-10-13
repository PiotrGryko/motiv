 
package com.motiv.example
import androidx.room.*
import kotlin.collections.List

public class PhotoWithReferences {

    @Embedded
    private lateinit var photo: com.motiv.example.Photo

    @Relation(entity = com.motiv.example.Links::class, parentColumn = "linksId", entityColumn = "id")

    public var links: List<com.motiv.example.Links> = arrayListOf()

    fun getPhoto(): Photo {
        if (links.size > 0) {
            photo.setLinks(links.get(0))
        }

        return photo
    } public fun setPhoto(photo: Photo) { this.photo = photo; }
}
