 
package com.motiv.example
import androidx.room.*
import kotlin.collections.List

public class UsersResponseWithReferences {

    @Embedded
    private lateinit var usersResponse: com.motiv.example.UsersResponse

    @Relation(entity = com.motiv.example.Meta::class, parentColumn = "metaId", entityColumn = "id")

    public var meta: List<com.motiv.example.Meta> = arrayListOf()
    @Relation(entity = com.motiv.example.User::class, parentColumn = "id", entityColumn = "resultOwnerId")
    public var result: List<com.motiv.example.User> = arrayListOf()

    fun getUsersResponse(): UsersResponse {
        if (meta.size > 0) {
            usersResponse.setMeta(meta.get(0))
        }
        usersResponse.setResult(result)

        return usersResponse
    } public fun setUsersResponse(usersResponse: UsersResponse) { this.usersResponse = usersResponse; }
}
