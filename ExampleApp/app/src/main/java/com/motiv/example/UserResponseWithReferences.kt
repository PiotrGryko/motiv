 
package com.motiv.example
import androidx.fragment.app.*
import androidx.room.*
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List

public class UserResponseWithReferences {

    @Embedded
    private lateinit var userResponse: com.motiv.example.UserResponse

    @Relation(entity = com.motiv.example.User::class, parentColumn = "resultId", entityColumn = "id")

    public var result: List<com.motiv.example.User> = arrayListOf()
    @Relation(entity = com.motiv.example.Meta::class, parentColumn = "metaId", entityColumn = "id")
    public var meta: List<com.motiv.example.Meta> = arrayListOf()

    fun getUserResponse(): UserResponse {
        if (result.size > 0) {
            userResponse.setResult(result.get(0))
        }
        if (meta.size > 0) {
            userResponse.setMeta(meta.get(0))
        }

        return userResponse
    } public fun setUserResponse(userResponse: UserResponse) { this.userResponse = userResponse; }
}
