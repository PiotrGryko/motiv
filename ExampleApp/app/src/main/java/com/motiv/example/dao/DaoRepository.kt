 
package com.motiv.example.dao
import android.os.Handler
import com.motiv.example.AuthToken
import com.motiv.example.Link
import com.motiv.example.Links
import com.motiv.example.LinksWithReferences
import com.motiv.example.Meta
import com.motiv.example.OnResponseListener
import com.motiv.example.Photo
import com.motiv.example.PhotoWithReferences
import com.motiv.example.PhotosListResponse
import com.motiv.example.PhotosListResponseWithReferences
import com.motiv.example.Post
import com.motiv.example.PostWithReferences
import com.motiv.example.PostsListResponse
import com.motiv.example.PostsListResponseWithReferences
import com.motiv.example.User
import com.motiv.example.UserResponse
import com.motiv.example.UserResponseWithReferences
import com.motiv.example.UserWithReferences
import com.motiv.example.UsersResponse
import com.motiv.example.UsersResponseWithReferences
import java.util.*
import java.util.concurrent.*
import kotlin.collections.List

public class DaoRepository(val handler: Handler, val myRoomDatabase: MyRoomDatabase, val executor: Executor) {

    fun saveUser(user: com.motiv.example.User, onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.User>) {
        updateUser(user); executor.execute {
            myRoomDatabase.userDao().saveUser(user)
            passSuccessResultToUi(user, onResponseListener)
        }
    } fun saveUsers(users: List<com.motiv.example.User>, onResponseListener: com.motiv.example.OnResponseListener<List<com.motiv.example.User>>) {
        updateUsers(users)
        executor.execute {
            myRoomDatabase.userDao().saveUsers(users)
            passSuccessResultToUi(users, onResponseListener)
        }
    } fun loadUsers(onResponseListener: com.motiv.example.OnResponseListener<List<com.motiv.example.User>>) {
        executor.execute {
            val resultWithReferences = myRoomDatabase.userDao().getUsers()
            val result = ArrayList<User>()
            for (withReference: UserWithReferences in resultWithReferences) {
                result.add(withReference.getUser())
            }
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun loadUser(id: String, onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.User>) {
        executor.execute {
            val resultWithReference = myRoomDatabase.userDao().getUser(id)
            passSuccessResultToUi(resultWithReference.getUser(), onResponseListener)
        }
    } fun saveLinks(links: com.motiv.example.Links, onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.Links>) {
        updateLinks(links); executor.execute {
            myRoomDatabase.linksDao().saveLinks(links)
            passSuccessResultToUi(links, onResponseListener)
        }
    } fun saveLinkss(linkss: List<com.motiv.example.Links>, onResponseListener: com.motiv.example.OnResponseListener<List<com.motiv.example.Links>>) {
        updateLinkss(linkss)
        executor.execute {
            myRoomDatabase.linksDao().saveLinkss(linkss)
            passSuccessResultToUi(linkss, onResponseListener)
        }
    } fun loadLinkss(onResponseListener: com.motiv.example.OnResponseListener<List<com.motiv.example.Links>>) {
        executor.execute {
            val resultWithReferences = myRoomDatabase.linksDao().getLinkss()
            val result = ArrayList<Links>()
            for (withReference: LinksWithReferences in resultWithReferences) {
                result.add(withReference.getLinks())
            }
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun loadLinks(id: String, onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.Links>) {
        executor.execute {
            val resultWithReference = myRoomDatabase.linksDao().getLinks(id)
            passSuccessResultToUi(resultWithReference.getLinks(), onResponseListener)
        }
    } fun saveLink(link: com.motiv.example.Link, onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.Link>) {
        executor.execute {
            myRoomDatabase.linkDao().saveLink(link)
            passSuccessResultToUi(link, onResponseListener)
        }
    } fun saveLinks(links: List<com.motiv.example.Link>, onResponseListener: com.motiv.example.OnResponseListener<List<com.motiv.example.Link>>) {
        executor.execute {
            myRoomDatabase.linkDao().saveLinks(links)
            passSuccessResultToUi(links, onResponseListener)
        }
    } fun loadLinks(onResponseListener: com.motiv.example.OnResponseListener<List<com.motiv.example.Link>>) {
        executor.execute {
            var result: List<Link> = myRoomDatabase.linkDao().getLinks()
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun loadLink(id: String, onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.Link>) {
        executor.execute {
            var result: Link = myRoomDatabase.linkDao().getLink(id)
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun saveUserResponse(userResponse: com.motiv.example.UserResponse, onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.UserResponse>) {
        updateUserResponse(userResponse); executor.execute {
            myRoomDatabase.userResponseDao().saveUserResponse(userResponse)
            passSuccessResultToUi(userResponse, onResponseListener)
        }
    } fun saveUserResponses(userResponses: List<com.motiv.example.UserResponse>, onResponseListener: com.motiv.example.OnResponseListener<List<com.motiv.example.UserResponse>>) {
        updateUserResponses(userResponses)
        executor.execute {
            myRoomDatabase.userResponseDao().saveUserResponses(userResponses)
            passSuccessResultToUi(userResponses, onResponseListener)
        }
    } fun loadUserResponses(onResponseListener: com.motiv.example.OnResponseListener<List<com.motiv.example.UserResponse>>) {
        executor.execute {
            val resultWithReferences = myRoomDatabase.userResponseDao().getUserResponses()
            val result = ArrayList<UserResponse>()
            for (withReference: UserResponseWithReferences in resultWithReferences) {
                result.add(withReference.getUserResponse())
            }
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun loadUserResponse(id: String, onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.UserResponse>) {
        executor.execute {
            val resultWithReference = myRoomDatabase.userResponseDao().getUserResponse(id)
            passSuccessResultToUi(resultWithReference.getUserResponse(), onResponseListener)
        }
    } fun saveMeta(meta: com.motiv.example.Meta, onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.Meta>) {
        executor.execute {
            myRoomDatabase.metaDao().saveMeta(meta)
            passSuccessResultToUi(meta, onResponseListener)
        }
    } fun saveMetas(metas: List<com.motiv.example.Meta>, onResponseListener: com.motiv.example.OnResponseListener<List<com.motiv.example.Meta>>) {
        executor.execute {
            myRoomDatabase.metaDao().saveMetas(metas)
            passSuccessResultToUi(metas, onResponseListener)
        }
    } fun loadMetas(onResponseListener: com.motiv.example.OnResponseListener<List<com.motiv.example.Meta>>) {
        executor.execute {
            var result: List<Meta> = myRoomDatabase.metaDao().getMetas()
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun loadMeta(id: String, onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.Meta>) {
        executor.execute {
            var result: Meta = myRoomDatabase.metaDao().getMeta(id)
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun saveUsersResponse(usersResponse: com.motiv.example.UsersResponse, onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.UsersResponse>) {
        updateUsersResponse(usersResponse); executor.execute {
            myRoomDatabase.usersResponseDao().saveUsersResponse(usersResponse)
            passSuccessResultToUi(usersResponse, onResponseListener)
        }
    } fun saveUsersResponses(usersResponses: List<com.motiv.example.UsersResponse>, onResponseListener: com.motiv.example.OnResponseListener<List<com.motiv.example.UsersResponse>>) {
        updateUsersResponses(usersResponses)
        executor.execute {
            myRoomDatabase.usersResponseDao().saveUsersResponses(usersResponses)
            passSuccessResultToUi(usersResponses, onResponseListener)
        }
    } fun loadUsersResponses(onResponseListener: com.motiv.example.OnResponseListener<List<com.motiv.example.UsersResponse>>) {
        executor.execute {
            val resultWithReferences = myRoomDatabase.usersResponseDao().getUsersResponses()
            val result = ArrayList<UsersResponse>()
            for (withReference: UsersResponseWithReferences in resultWithReferences) {
                result.add(withReference.getUsersResponse())
            }
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun loadUsersResponse(id: String, onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.UsersResponse>) {
        executor.execute {
            val resultWithReference = myRoomDatabase.usersResponseDao().getUsersResponse(id)
            passSuccessResultToUi(resultWithReference.getUsersResponse(), onResponseListener)
        }
    } fun savePostsListResponse(postsListResponse: com.motiv.example.PostsListResponse, onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.PostsListResponse>) {
        updatePostsListResponse(postsListResponse); executor.execute {
            myRoomDatabase.postsListResponseDao().savePostsListResponse(postsListResponse)
            passSuccessResultToUi(postsListResponse, onResponseListener)
        }
    } fun savePostsListResponses(postsListResponses: List<com.motiv.example.PostsListResponse>, onResponseListener: com.motiv.example.OnResponseListener<List<com.motiv.example.PostsListResponse>>) {
        updatePostsListResponses(postsListResponses)
        executor.execute {
            myRoomDatabase.postsListResponseDao().savePostsListResponses(postsListResponses)
            passSuccessResultToUi(postsListResponses, onResponseListener)
        }
    } fun loadPostsListResponses(onResponseListener: com.motiv.example.OnResponseListener<List<com.motiv.example.PostsListResponse>>) {
        executor.execute {
            val resultWithReferences = myRoomDatabase.postsListResponseDao().getPostsListResponses()
            val result = ArrayList<PostsListResponse>()
            for (withReference: PostsListResponseWithReferences in resultWithReferences) {
                result.add(withReference.getPostsListResponse())
            }
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun loadPostsListResponse(id: String, onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.PostsListResponse>) {
        executor.execute {
            val resultWithReference = myRoomDatabase.postsListResponseDao().getPostsListResponse(id)
            passSuccessResultToUi(resultWithReference.getPostsListResponse(), onResponseListener)
        }
    } fun savePost(post: com.motiv.example.Post, onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.Post>) {
        updatePost(post); executor.execute {
            myRoomDatabase.postDao().savePost(post)
            passSuccessResultToUi(post, onResponseListener)
        }
    } fun savePosts(posts: List<com.motiv.example.Post>, onResponseListener: com.motiv.example.OnResponseListener<List<com.motiv.example.Post>>) {
        updatePosts(posts)
        executor.execute {
            myRoomDatabase.postDao().savePosts(posts)
            passSuccessResultToUi(posts, onResponseListener)
        }
    } fun loadPosts(onResponseListener: com.motiv.example.OnResponseListener<List<com.motiv.example.Post>>) {
        executor.execute {
            val resultWithReferences = myRoomDatabase.postDao().getPosts()
            val result = ArrayList<Post>()
            for (withReference: PostWithReferences in resultWithReferences) {
                result.add(withReference.getPost())
            }
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun loadPost(id: String, onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.Post>) {
        executor.execute {
            val resultWithReference = myRoomDatabase.postDao().getPost(id)
            passSuccessResultToUi(resultWithReference.getPost(), onResponseListener)
        }
    } fun savePhotosListResponse(photosListResponse: com.motiv.example.PhotosListResponse, onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.PhotosListResponse>) {
        updatePhotosListResponse(photosListResponse); executor.execute {
            myRoomDatabase.photosListResponseDao().savePhotosListResponse(photosListResponse)
            passSuccessResultToUi(photosListResponse, onResponseListener)
        }
    } fun savePhotosListResponses(photosListResponses: List<com.motiv.example.PhotosListResponse>, onResponseListener: com.motiv.example.OnResponseListener<List<com.motiv.example.PhotosListResponse>>) {
        updatePhotosListResponses(photosListResponses)
        executor.execute {
            myRoomDatabase.photosListResponseDao().savePhotosListResponses(photosListResponses)
            passSuccessResultToUi(photosListResponses, onResponseListener)
        }
    } fun loadPhotosListResponses(onResponseListener: com.motiv.example.OnResponseListener<List<com.motiv.example.PhotosListResponse>>) {
        executor.execute {
            val resultWithReferences = myRoomDatabase.photosListResponseDao().getPhotosListResponses()
            val result = ArrayList<PhotosListResponse>()
            for (withReference: PhotosListResponseWithReferences in resultWithReferences) {
                result.add(withReference.getPhotosListResponse())
            }
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun loadPhotosListResponse(id: String, onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.PhotosListResponse>) {
        executor.execute {
            val resultWithReference = myRoomDatabase.photosListResponseDao().getPhotosListResponse(id)
            passSuccessResultToUi(resultWithReference.getPhotosListResponse(), onResponseListener)
        }
    } fun savePhoto(photo: com.motiv.example.Photo, onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.Photo>) {
        updatePhoto(photo); executor.execute {
            myRoomDatabase.photoDao().savePhoto(photo)
            passSuccessResultToUi(photo, onResponseListener)
        }
    } fun savePhotos(photos: List<com.motiv.example.Photo>, onResponseListener: com.motiv.example.OnResponseListener<List<com.motiv.example.Photo>>) {
        updatePhotos(photos)
        executor.execute {
            myRoomDatabase.photoDao().savePhotos(photos)
            passSuccessResultToUi(photos, onResponseListener)
        }
    } fun loadPhotos(onResponseListener: com.motiv.example.OnResponseListener<List<com.motiv.example.Photo>>) {
        executor.execute {
            val resultWithReferences = myRoomDatabase.photoDao().getPhotos()
            val result = ArrayList<Photo>()
            for (withReference: PhotoWithReferences in resultWithReferences) {
                result.add(withReference.getPhoto())
            }
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun loadPhoto(id: String, onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.Photo>) {
        executor.execute {
            val resultWithReference = myRoomDatabase.photoDao().getPhoto(id)
            passSuccessResultToUi(resultWithReference.getPhoto(), onResponseListener)
        }
    } fun saveAuthToken(authToken: com.motiv.example.AuthToken, onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.AuthToken>) {
        executor.execute {
            myRoomDatabase.authTokenDao().saveAuthToken(authToken)
            passSuccessResultToUi(authToken, onResponseListener)
        }
    } fun saveAuthTokens(authTokens: List<com.motiv.example.AuthToken>, onResponseListener: com.motiv.example.OnResponseListener<List<com.motiv.example.AuthToken>>) {
        executor.execute {
            myRoomDatabase.authTokenDao().saveAuthTokens(authTokens)
            passSuccessResultToUi(authTokens, onResponseListener)
        }
    } fun loadAuthTokens(onResponseListener: com.motiv.example.OnResponseListener<List<com.motiv.example.AuthToken>>) {
        executor.execute {
            var result: List<AuthToken> = myRoomDatabase.authTokenDao().getAuthTokens()
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun loadAuthToken(id: String, onResponseListener: com.motiv.example.OnResponseListener<com.motiv.example.AuthToken>) {
        executor.execute {
            var result: AuthToken = myRoomDatabase.authTokenDao().getAuthToken(id)
            passSuccessResultToUi(result, onResponseListener)
        }
    } fun updateUser(user: User) {
        user.setLinksId(user.getLinks()?.getId())
    } fun updateUsers(users: List<User>) {
        for (user: User in users) {
            updateUser(user)
        }
    } fun updateLinks(links: Links) {
        links.setEditId(links.getEdit()?.getId()); links.setSelfId(links.getSelf()?.getId()); links.setAvatarId(links.getAvatar()?.getId())
    } fun updateLinkss(linkss: List<Links>) {
        for (links: Links in linkss) {
            updateLinks(links)
        }
    } fun updateUserResponse(userResponse: UserResponse) {
        userResponse.setResultId(userResponse.getResult()?.getId()); userResponse.setMetaId(userResponse.getMeta()?.getId())
    } fun updateUserResponses(userResponses: List<UserResponse>) {
        for (userResponse: UserResponse in userResponses) {
            updateUserResponse(userResponse)
        }
    } fun updateUsersResponse(usersResponse: UsersResponse) {
        usersResponse.setMetaId(usersResponse.getMeta()?.getId()); for (user: com.motiv.example.User in usersResponse.getResult()) {
            user.setResultOwnerId(usersResponse.getId())
        }
    } fun updateUsersResponses(usersResponses: List<UsersResponse>) {
        for (usersResponse: UsersResponse in usersResponses) {
            updateUsersResponse(usersResponse)
        }
    } fun updatePostsListResponse(postsListResponse: PostsListResponse) {
        postsListResponse.setMetaId(postsListResponse.getMeta()?.getId()); for (post: com.motiv.example.Post in postsListResponse.getResult()) {
            post.setResultOwnerId(postsListResponse.getId())
        }
    } fun updatePostsListResponses(postsListResponses: List<PostsListResponse>) {
        for (postsListResponse: PostsListResponse in postsListResponses) {
            updatePostsListResponse(postsListResponse)
        }
    } fun updatePost(post: Post) {
        post.setLinksId(post.getLinks()?.getId())
    } fun updatePosts(posts: List<Post>) {
        for (post: Post in posts) {
            updatePost(post)
        }
    } fun updatePhotosListResponse(photosListResponse: PhotosListResponse) {
        photosListResponse.setMetaId(photosListResponse.getMeta()?.getId()); for (photo: com.motiv.example.Photo in photosListResponse.getResult()) {
            photo.setResultOwnerId(photosListResponse.getId())
        }
    } fun updatePhotosListResponses(photosListResponses: List<PhotosListResponse>) {
        for (photosListResponse: PhotosListResponse in photosListResponses) {
            updatePhotosListResponse(photosListResponse)
        }
    } fun updatePhoto(photo: Photo) {
        photo.setLinksId(photo.getLinks()?.getId())
    } fun updatePhotos(photos: List<Photo>) {
        for (photo: Photo in photos) {
            updatePhoto(photo)
        }
    } private fun <T> passSuccessResultToUi(result: T, onResponseListener: OnResponseListener<T>) {
        handler.post { onResponseListener.onSuccess(result); }
    }
}
