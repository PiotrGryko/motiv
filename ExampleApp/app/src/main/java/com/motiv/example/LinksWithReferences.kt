 
package com.motiv.example
import androidx.room.*
import kotlin.collections.List

public class LinksWithReferences {

    @Embedded
    private lateinit var links: com.motiv.example.Links

    @Relation(entity = com.motiv.example.Link::class, parentColumn = "editId", entityColumn = "id")

    public var edit: List<com.motiv.example.Link> = arrayListOf()
    @Relation(entity = com.motiv.example.Link::class, parentColumn = "selfId", entityColumn = "id")
    public var self: List<com.motiv.example.Link> = arrayListOf()
    @Relation(entity = com.motiv.example.Link::class, parentColumn = "avatarId", entityColumn = "id")
    public var avatar: List<com.motiv.example.Link> = arrayListOf()

    fun getLinks(): Links {
        if (edit.size > 0) {
            links.setEdit(edit.get(0))
        }
        if (self.size > 0) {
            links.setSelf(self.get(0))
        }
        if (avatar.size > 0) {
            links.setAvatar(avatar.get(0))
        }

        return links
    } public fun setLinks(links: Links) { this.links = links; }
}
