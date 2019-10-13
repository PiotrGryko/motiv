 
package com.motiv.example.dao
import com.motiv.example.AuthToken
import com.motiv.example.Link
import com.motiv.example.Links
import com.motiv.example.Meta
import com.motiv.example.OnResponseListener
import com.motiv.example.Photo
import com.motiv.example.PhotosListResponse
import com.motiv.example.Post
import com.motiv.example.PostsListResponse
import com.motiv.example.User
import com.motiv.example.UserResponse
import com.motiv.example.UsersResponse
import io.realm.*
import java.util.*
import java.util.concurrent.*
import kotlin.collections.List

public class DaoRepository {

    private var myDatabase: Realm

    constructor(myDatabase: Realm) {
        this.myDatabase = myDatabase
    }

    fun saveUsers(users: List<com.motiv.example.User>, onResponseListener: OnResponseListener<List<com.motiv.example.User>>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                for (user: User in users) {
                    it.copyToRealm(user)
                }
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(users)
            }
        )
    } fun loadUser(id: String, onResponseListener: OnResponseListener<com.motiv.example.User>) {
        var realmResponse = myDatabase.where(User::class.java).equalTo("id", id).findFirst()
        val result = myDatabase.copyFromRealm(realmResponse)!!
        onResponseListener.onSuccess(result)
    } fun loadUsers(onResponseListener: OnResponseListener<List<com.motiv.example.User>>) {
        val result = myDatabase.where(User::class.java).findAll()
        val users = mutableListOf<User>()
        for (i in result.indices) {
            users.add(myDatabase.copyFromRealm(result.get(i))!!)
        }
        onResponseListener.onSuccess(users)
    } fun saveUser(user: User, onResponseListener: OnResponseListener<User>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                it.copyToRealm(user)
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(user)
            }
        )
    } fun saveLinkss(linkss: List<com.motiv.example.Links>, onResponseListener: OnResponseListener<List<com.motiv.example.Links>>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                for (links: Links in linkss) {
                    it.copyToRealm(links)
                }
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(linkss)
            }
        )
    } fun loadLinks(id: String, onResponseListener: OnResponseListener<com.motiv.example.Links>) {
        var realmResponse = myDatabase.where(Links::class.java).equalTo("id", id).findFirst()
        val result = myDatabase.copyFromRealm(realmResponse)!!
        onResponseListener.onSuccess(result)
    } fun loadLinkss(onResponseListener: OnResponseListener<List<com.motiv.example.Links>>) {
        val result = myDatabase.where(Links::class.java).findAll()
        val linkss = mutableListOf<Links>()
        for (i in result.indices) {
            linkss.add(myDatabase.copyFromRealm(result.get(i))!!)
        }
        onResponseListener.onSuccess(linkss)
    } fun saveLinks(links: Links, onResponseListener: OnResponseListener<Links>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                it.copyToRealm(links)
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(links)
            }
        )
    } fun saveLinks(links: List<com.motiv.example.Link>, onResponseListener: OnResponseListener<List<com.motiv.example.Link>>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                for (link: Link in links) {
                    it.copyToRealm(link)
                }
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(links)
            }
        )
    } fun loadLink(id: String, onResponseListener: OnResponseListener<com.motiv.example.Link>) {
        var realmResponse = myDatabase.where(Link::class.java).equalTo("id", id).findFirst()
        val result = myDatabase.copyFromRealm(realmResponse)!!
        onResponseListener.onSuccess(result)
    } fun loadLinks(onResponseListener: OnResponseListener<List<com.motiv.example.Link>>) {
        val result = myDatabase.where(Link::class.java).findAll()
        val links = mutableListOf<Link>()
        for (i in result.indices) {
            links.add(myDatabase.copyFromRealm(result.get(i))!!)
        }
        onResponseListener.onSuccess(links)
    } fun saveLink(link: Link, onResponseListener: OnResponseListener<Link>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                it.copyToRealm(link)
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(link)
            }
        )
    } fun saveUserResponses(userResponses: List<com.motiv.example.UserResponse>, onResponseListener: OnResponseListener<List<com.motiv.example.UserResponse>>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                for (userResponse: UserResponse in userResponses) {
                    it.copyToRealm(userResponse)
                }
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(userResponses)
            }
        )
    } fun loadUserResponse(id: String, onResponseListener: OnResponseListener<com.motiv.example.UserResponse>) {
        var realmResponse = myDatabase.where(UserResponse::class.java).equalTo("id", id).findFirst()
        val result = myDatabase.copyFromRealm(realmResponse)!!
        onResponseListener.onSuccess(result)
    } fun loadUserResponses(onResponseListener: OnResponseListener<List<com.motiv.example.UserResponse>>) {
        val result = myDatabase.where(UserResponse::class.java).findAll()
        val userResponses = mutableListOf<UserResponse>()
        for (i in result.indices) {
            userResponses.add(myDatabase.copyFromRealm(result.get(i))!!)
        }
        onResponseListener.onSuccess(userResponses)
    } fun saveUserResponse(userResponse: UserResponse, onResponseListener: OnResponseListener<UserResponse>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                it.copyToRealm(userResponse)
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(userResponse)
            }
        )
    } fun saveMetas(metas: List<com.motiv.example.Meta>, onResponseListener: OnResponseListener<List<com.motiv.example.Meta>>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                for (meta: Meta in metas) {
                    it.copyToRealm(meta)
                }
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(metas)
            }
        )
    } fun loadMeta(id: String, onResponseListener: OnResponseListener<com.motiv.example.Meta>) {
        var realmResponse = myDatabase.where(Meta::class.java).equalTo("id", id).findFirst()
        val result = myDatabase.copyFromRealm(realmResponse)!!
        onResponseListener.onSuccess(result)
    } fun loadMetas(onResponseListener: OnResponseListener<List<com.motiv.example.Meta>>) {
        val result = myDatabase.where(Meta::class.java).findAll()
        val metas = mutableListOf<Meta>()
        for (i in result.indices) {
            metas.add(myDatabase.copyFromRealm(result.get(i))!!)
        }
        onResponseListener.onSuccess(metas)
    } fun saveMeta(meta: Meta, onResponseListener: OnResponseListener<Meta>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                it.copyToRealm(meta)
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(meta)
            }
        )
    } fun saveUsersResponses(usersResponses: List<com.motiv.example.UsersResponse>, onResponseListener: OnResponseListener<List<com.motiv.example.UsersResponse>>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                for (usersResponse: UsersResponse in usersResponses) {
                    it.copyToRealm(usersResponse)
                }
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(usersResponses)
            }
        )
    } fun loadUsersResponse(id: String, onResponseListener: OnResponseListener<com.motiv.example.UsersResponse>) {
        var realmResponse = myDatabase.where(UsersResponse::class.java).equalTo("id", id).findFirst()
        val result = myDatabase.copyFromRealm(realmResponse)!!
        onResponseListener.onSuccess(result)
    } fun loadUsersResponses(onResponseListener: OnResponseListener<List<com.motiv.example.UsersResponse>>) {
        val result = myDatabase.where(UsersResponse::class.java).findAll()
        val usersResponses = mutableListOf<UsersResponse>()
        for (i in result.indices) {
            usersResponses.add(myDatabase.copyFromRealm(result.get(i))!!)
        }
        onResponseListener.onSuccess(usersResponses)
    } fun saveUsersResponse(usersResponse: UsersResponse, onResponseListener: OnResponseListener<UsersResponse>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                it.copyToRealm(usersResponse)
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(usersResponse)
            }
        )
    } fun savePostsListResponses(postsListResponses: List<com.motiv.example.PostsListResponse>, onResponseListener: OnResponseListener<List<com.motiv.example.PostsListResponse>>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                for (postsListResponse: PostsListResponse in postsListResponses) {
                    it.copyToRealm(postsListResponse)
                }
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(postsListResponses)
            }
        )
    } fun loadPostsListResponse(id: String, onResponseListener: OnResponseListener<com.motiv.example.PostsListResponse>) {
        var realmResponse = myDatabase.where(PostsListResponse::class.java).equalTo("id", id).findFirst()
        val result = myDatabase.copyFromRealm(realmResponse)!!
        onResponseListener.onSuccess(result)
    } fun loadPostsListResponses(onResponseListener: OnResponseListener<List<com.motiv.example.PostsListResponse>>) {
        val result = myDatabase.where(PostsListResponse::class.java).findAll()
        val postsListResponses = mutableListOf<PostsListResponse>()
        for (i in result.indices) {
            postsListResponses.add(myDatabase.copyFromRealm(result.get(i))!!)
        }
        onResponseListener.onSuccess(postsListResponses)
    } fun savePostsListResponse(postsListResponse: PostsListResponse, onResponseListener: OnResponseListener<PostsListResponse>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                it.copyToRealm(postsListResponse)
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(postsListResponse)
            }
        )
    } fun savePosts(posts: List<com.motiv.example.Post>, onResponseListener: OnResponseListener<List<com.motiv.example.Post>>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                for (post: Post in posts) {
                    it.copyToRealm(post)
                }
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(posts)
            }
        )
    } fun loadPost(id: String, onResponseListener: OnResponseListener<com.motiv.example.Post>) {
        var realmResponse = myDatabase.where(Post::class.java).equalTo("id", id).findFirst()
        val result = myDatabase.copyFromRealm(realmResponse)!!
        onResponseListener.onSuccess(result)
    } fun loadPosts(onResponseListener: OnResponseListener<List<com.motiv.example.Post>>) {
        val result = myDatabase.where(Post::class.java).findAll()
        val posts = mutableListOf<Post>()
        for (i in result.indices) {
            posts.add(myDatabase.copyFromRealm(result.get(i))!!)
        }
        onResponseListener.onSuccess(posts)
    } fun savePost(post: Post, onResponseListener: OnResponseListener<Post>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                it.copyToRealm(post)
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(post)
            }
        )
    } fun savePhotosListResponses(photosListResponses: List<com.motiv.example.PhotosListResponse>, onResponseListener: OnResponseListener<List<com.motiv.example.PhotosListResponse>>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                for (photosListResponse: PhotosListResponse in photosListResponses) {
                    it.copyToRealm(photosListResponse)
                }
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(photosListResponses)
            }
        )
    } fun loadPhotosListResponse(id: String, onResponseListener: OnResponseListener<com.motiv.example.PhotosListResponse>) {
        var realmResponse = myDatabase.where(PhotosListResponse::class.java).equalTo("id", id).findFirst()
        val result = myDatabase.copyFromRealm(realmResponse)!!
        onResponseListener.onSuccess(result)
    } fun loadPhotosListResponses(onResponseListener: OnResponseListener<List<com.motiv.example.PhotosListResponse>>) {
        val result = myDatabase.where(PhotosListResponse::class.java).findAll()
        val photosListResponses = mutableListOf<PhotosListResponse>()
        for (i in result.indices) {
            photosListResponses.add(myDatabase.copyFromRealm(result.get(i))!!)
        }
        onResponseListener.onSuccess(photosListResponses)
    } fun savePhotosListResponse(photosListResponse: PhotosListResponse, onResponseListener: OnResponseListener<PhotosListResponse>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                it.copyToRealm(photosListResponse)
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(photosListResponse)
            }
        )
    } fun savePhotos(photos: List<com.motiv.example.Photo>, onResponseListener: OnResponseListener<List<com.motiv.example.Photo>>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                for (photo: Photo in photos) {
                    it.copyToRealm(photo)
                }
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(photos)
            }
        )
    } fun loadPhoto(id: String, onResponseListener: OnResponseListener<com.motiv.example.Photo>) {
        var realmResponse = myDatabase.where(Photo::class.java).equalTo("id", id).findFirst()
        val result = myDatabase.copyFromRealm(realmResponse)!!
        onResponseListener.onSuccess(result)
    } fun loadPhotos(onResponseListener: OnResponseListener<List<com.motiv.example.Photo>>) {
        val result = myDatabase.where(Photo::class.java).findAll()
        val photos = mutableListOf<Photo>()
        for (i in result.indices) {
            photos.add(myDatabase.copyFromRealm(result.get(i))!!)
        }
        onResponseListener.onSuccess(photos)
    } fun savePhoto(photo: Photo, onResponseListener: OnResponseListener<Photo>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                it.copyToRealm(photo)
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(photo)
            }
        )
    } fun saveAuthTokens(authTokens: List<com.motiv.example.AuthToken>, onResponseListener: OnResponseListener<List<com.motiv.example.AuthToken>>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                for (authToken: AuthToken in authTokens) {
                    it.copyToRealm(authToken)
                }
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(authTokens)
            }
        )
    } fun loadAuthToken(id: String, onResponseListener: OnResponseListener<com.motiv.example.AuthToken>) {
        var realmResponse = myDatabase.where(AuthToken::class.java).equalTo("id", id).findFirst()
        val result = myDatabase.copyFromRealm(realmResponse)!!
        onResponseListener.onSuccess(result)
    } fun loadAuthTokens(onResponseListener: OnResponseListener<List<com.motiv.example.AuthToken>>) {
        val result = myDatabase.where(AuthToken::class.java).findAll()
        val authTokens = mutableListOf<AuthToken>()
        for (i in result.indices) {
            authTokens.add(myDatabase.copyFromRealm(result.get(i))!!)
        }
        onResponseListener.onSuccess(authTokens)
    } fun saveAuthToken(authToken: AuthToken, onResponseListener: OnResponseListener<AuthToken>) {
        myDatabase.executeTransactionAsync(
            Realm.Transaction {
                it.copyToRealm(authToken)
            },
            Realm.Transaction.OnSuccess {
                onResponseListener.onSuccess(authToken)
            }
        )
    }
}
