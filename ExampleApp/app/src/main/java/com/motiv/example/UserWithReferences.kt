 
package com.motiv.example
import androidx.room.*
import kotlin.collections.List

public class UserWithReferences {

    @Embedded
    private lateinit var user: com.motiv.example.User

    @Relation(entity = com.motiv.example.Links::class, parentColumn = "linksId", entityColumn = "id")

    public var links: List<com.motiv.example.Links> = arrayListOf()

    fun getUser(): User {
        if (links.size > 0) {
            user.setLinks(links.get(0))
        }

        return user
    } public fun setUser(user: User) { this.user = user; }
}
