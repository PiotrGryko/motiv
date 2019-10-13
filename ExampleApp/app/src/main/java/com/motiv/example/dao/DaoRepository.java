package com.motiv.example.dao;

import android.os.Handler;
import com.motiv.example.AuthToken;
import com.motiv.example.Link;
import com.motiv.example.Links;
import com.motiv.example.LinksWithReferences;
import com.motiv.example.Meta;
import com.motiv.example.OnResponseListener;
import com.motiv.example.Photo;
import com.motiv.example.PhotoWithReferences;
import com.motiv.example.PhotosListResponse;
import com.motiv.example.PhotosListResponseWithReferences;
import com.motiv.example.Post;
import com.motiv.example.PostWithReferences;
import com.motiv.example.PostsListResponse;
import com.motiv.example.PostsListResponseWithReferences;
import com.motiv.example.User;
import com.motiv.example.UserResponse;
import com.motiv.example.UserResponseWithReferences;
import com.motiv.example.UserWithReferences;
import com.motiv.example.UsersResponse;
import com.motiv.example.UsersResponseWithReferences;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class DaoRepository {

    private MyRoomDatabase myRoomDatabase;
    private Handler handler;
    private Executor executor;

    public DaoRepository(Handler handler, MyRoomDatabase myRoomDatabase, Executor executor) {
        this.handler = handler;
        this.myRoomDatabase = myRoomDatabase;
        this.executor = executor;
    }

    public void saveUser(
            final com.motiv.example.User user,
            final com.motiv.example.OnResponseListener<com.motiv.example.User> onResponseListener) {
        updateUser(user);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.userDao().saveUser(user);
                        passSuccessResultToUi(user, onResponseListener);
                    }
                });
    }

    public void saveUsers(
            final java.util.List<com.motiv.example.User> users,
            final com.motiv.example.OnResponseListener<java.util.List<com.motiv.example.User>>
                    onResponseListener) {
        updateUsers(users);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.userDao().saveUsers(users);
                        passSuccessResultToUi(users, onResponseListener);
                    }
                });
    }

    public void loadUsers(
            final com.motiv.example.OnResponseListener<java.util.List<com.motiv.example.User>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<UserWithReferences> resultWithReferences =
                                myRoomDatabase.userDao().getUsers();
                        List<User> result = new ArrayList<>();
                        for (UserWithReferences withReference : resultWithReferences) {
                            result.add(withReference.getUser());
                        }

                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void loadUser(
            final java.lang.String id,
            final com.motiv.example.OnResponseListener<com.motiv.example.User> onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final UserWithReferences resultWithReference =
                                myRoomDatabase.userDao().getUser(id);
                        passSuccessResultToUi(resultWithReference.getUser(), onResponseListener);
                    }
                });
    }

    public void saveLinks(
            final com.motiv.example.Links links,
            final com.motiv.example.OnResponseListener<com.motiv.example.Links>
                    onResponseListener) {
        updateLinks(links);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.linksDao().saveLinks(links);
                        passSuccessResultToUi(links, onResponseListener);
                    }
                });
    }

    public void saveLinkss(
            final java.util.List<com.motiv.example.Links> linkss,
            final com.motiv.example.OnResponseListener<java.util.List<com.motiv.example.Links>>
                    onResponseListener) {
        updateLinkss(linkss);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.linksDao().saveLinkss(linkss);
                        passSuccessResultToUi(linkss, onResponseListener);
                    }
                });
    }

    public void loadLinkss(
            final com.motiv.example.OnResponseListener<java.util.List<com.motiv.example.Links>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<LinksWithReferences> resultWithReferences =
                                myRoomDatabase.linksDao().getLinkss();
                        List<Links> result = new ArrayList<>();
                        for (LinksWithReferences withReference : resultWithReferences) {
                            result.add(withReference.getLinks());
                        }

                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void loadLinks(
            final java.lang.String id,
            final com.motiv.example.OnResponseListener<com.motiv.example.Links>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final LinksWithReferences resultWithReference =
                                myRoomDatabase.linksDao().getLinks(id);
                        passSuccessResultToUi(resultWithReference.getLinks(), onResponseListener);
                    }
                });
    }

    public void saveLink(
            final com.motiv.example.Link link,
            final com.motiv.example.OnResponseListener<com.motiv.example.Link> onResponseListener) {
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.linkDao().saveLink(link);
                        passSuccessResultToUi(link, onResponseListener);
                    }
                });
    }

    public void saveLinks(
            final java.util.List<com.motiv.example.Link> links,
            final com.motiv.example.OnResponseListener<java.util.List<com.motiv.example.Link>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.linkDao().saveLinks(links);
                        passSuccessResultToUi(links, onResponseListener);
                    }
                });
    }

    public void loadLinks(
            final com.motiv.example.OnResponseListener<java.util.List<com.motiv.example.Link>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<Link> result = myRoomDatabase.linkDao().getLinks();
                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void loadLink(
            final java.lang.String id,
            final com.motiv.example.OnResponseListener<com.motiv.example.Link> onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final Link result = myRoomDatabase.linkDao().getLink(id);
                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void saveUserResponse(
            final com.motiv.example.UserResponse userResponse,
            final com.motiv.example.OnResponseListener<com.motiv.example.UserResponse>
                    onResponseListener) {
        updateUserResponse(userResponse);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.userResponseDao().saveUserResponse(userResponse);
                        passSuccessResultToUi(userResponse, onResponseListener);
                    }
                });
    }

    public void saveUserResponses(
            final java.util.List<com.motiv.example.UserResponse> userResponses,
            final com.motiv.example.OnResponseListener<
                            java.util.List<com.motiv.example.UserResponse>>
                    onResponseListener) {
        updateUserResponses(userResponses);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.userResponseDao().saveUserResponses(userResponses);
                        passSuccessResultToUi(userResponses, onResponseListener);
                    }
                });
    }

    public void loadUserResponses(
            final com.motiv.example.OnResponseListener<
                            java.util.List<com.motiv.example.UserResponse>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<UserResponseWithReferences> resultWithReferences =
                                myRoomDatabase.userResponseDao().getUserResponses();
                        List<UserResponse> result = new ArrayList<>();
                        for (UserResponseWithReferences withReference : resultWithReferences) {
                            result.add(withReference.getUserResponse());
                        }

                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void loadUserResponse(
            final java.lang.String id,
            final com.motiv.example.OnResponseListener<com.motiv.example.UserResponse>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final UserResponseWithReferences resultWithReference =
                                myRoomDatabase.userResponseDao().getUserResponse(id);
                        passSuccessResultToUi(
                                resultWithReference.getUserResponse(), onResponseListener);
                    }
                });
    }

    public void saveMeta(
            final com.motiv.example.Meta meta,
            final com.motiv.example.OnResponseListener<com.motiv.example.Meta> onResponseListener) {
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.metaDao().saveMeta(meta);
                        passSuccessResultToUi(meta, onResponseListener);
                    }
                });
    }

    public void saveMetas(
            final java.util.List<com.motiv.example.Meta> metas,
            final com.motiv.example.OnResponseListener<java.util.List<com.motiv.example.Meta>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.metaDao().saveMetas(metas);
                        passSuccessResultToUi(metas, onResponseListener);
                    }
                });
    }

    public void loadMetas(
            final com.motiv.example.OnResponseListener<java.util.List<com.motiv.example.Meta>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<Meta> result = myRoomDatabase.metaDao().getMetas();
                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void loadMeta(
            final java.lang.String id,
            final com.motiv.example.OnResponseListener<com.motiv.example.Meta> onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final Meta result = myRoomDatabase.metaDao().getMeta(id);
                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void saveUsersResponse(
            final com.motiv.example.UsersResponse usersResponse,
            final com.motiv.example.OnResponseListener<com.motiv.example.UsersResponse>
                    onResponseListener) {
        updateUsersResponse(usersResponse);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.usersResponseDao().saveUsersResponse(usersResponse);
                        passSuccessResultToUi(usersResponse, onResponseListener);
                    }
                });
    }

    public void saveUsersResponses(
            final java.util.List<com.motiv.example.UsersResponse> usersResponses,
            final com.motiv.example.OnResponseListener<
                            java.util.List<com.motiv.example.UsersResponse>>
                    onResponseListener) {
        updateUsersResponses(usersResponses);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.usersResponseDao().saveUsersResponses(usersResponses);
                        passSuccessResultToUi(usersResponses, onResponseListener);
                    }
                });
    }

    public void loadUsersResponses(
            final com.motiv.example.OnResponseListener<
                            java.util.List<com.motiv.example.UsersResponse>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<UsersResponseWithReferences> resultWithReferences =
                                myRoomDatabase.usersResponseDao().getUsersResponses();
                        List<UsersResponse> result = new ArrayList<>();
                        for (UsersResponseWithReferences withReference : resultWithReferences) {
                            result.add(withReference.getUsersResponse());
                        }

                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void loadUsersResponse(
            final java.lang.String id,
            final com.motiv.example.OnResponseListener<com.motiv.example.UsersResponse>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final UsersResponseWithReferences resultWithReference =
                                myRoomDatabase.usersResponseDao().getUsersResponse(id);
                        passSuccessResultToUi(
                                resultWithReference.getUsersResponse(), onResponseListener);
                    }
                });
    }

    public void savePostsListResponse(
            final com.motiv.example.PostsListResponse postsListResponse,
            final com.motiv.example.OnResponseListener<com.motiv.example.PostsListResponse>
                    onResponseListener) {
        updatePostsListResponse(postsListResponse);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase
                                .postsListResponseDao()
                                .savePostsListResponse(postsListResponse);
                        passSuccessResultToUi(postsListResponse, onResponseListener);
                    }
                });
    }

    public void savePostsListResponses(
            final java.util.List<com.motiv.example.PostsListResponse> postsListResponses,
            final com.motiv.example.OnResponseListener<
                            java.util.List<com.motiv.example.PostsListResponse>>
                    onResponseListener) {
        updatePostsListResponses(postsListResponses);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase
                                .postsListResponseDao()
                                .savePostsListResponses(postsListResponses);
                        passSuccessResultToUi(postsListResponses, onResponseListener);
                    }
                });
    }

    public void loadPostsListResponses(
            final com.motiv.example.OnResponseListener<
                            java.util.List<com.motiv.example.PostsListResponse>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<PostsListResponseWithReferences> resultWithReferences =
                                myRoomDatabase.postsListResponseDao().getPostsListResponses();
                        List<PostsListResponse> result = new ArrayList<>();
                        for (PostsListResponseWithReferences withReference : resultWithReferences) {
                            result.add(withReference.getPostsListResponse());
                        }

                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void loadPostsListResponse(
            final java.lang.String id,
            final com.motiv.example.OnResponseListener<com.motiv.example.PostsListResponse>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final PostsListResponseWithReferences resultWithReference =
                                myRoomDatabase.postsListResponseDao().getPostsListResponse(id);
                        passSuccessResultToUi(
                                resultWithReference.getPostsListResponse(), onResponseListener);
                    }
                });
    }

    public void savePost(
            final com.motiv.example.Post post,
            final com.motiv.example.OnResponseListener<com.motiv.example.Post> onResponseListener) {
        updatePost(post);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.postDao().savePost(post);
                        passSuccessResultToUi(post, onResponseListener);
                    }
                });
    }

    public void savePosts(
            final java.util.List<com.motiv.example.Post> posts,
            final com.motiv.example.OnResponseListener<java.util.List<com.motiv.example.Post>>
                    onResponseListener) {
        updatePosts(posts);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.postDao().savePosts(posts);
                        passSuccessResultToUi(posts, onResponseListener);
                    }
                });
    }

    public void loadPosts(
            final com.motiv.example.OnResponseListener<java.util.List<com.motiv.example.Post>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<PostWithReferences> resultWithReferences =
                                myRoomDatabase.postDao().getPosts();
                        List<Post> result = new ArrayList<>();
                        for (PostWithReferences withReference : resultWithReferences) {
                            result.add(withReference.getPost());
                        }

                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void loadPost(
            final java.lang.String id,
            final com.motiv.example.OnResponseListener<com.motiv.example.Post> onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final PostWithReferences resultWithReference =
                                myRoomDatabase.postDao().getPost(id);
                        passSuccessResultToUi(resultWithReference.getPost(), onResponseListener);
                    }
                });
    }

    public void savePhotosListResponse(
            final com.motiv.example.PhotosListResponse photosListResponse,
            final com.motiv.example.OnResponseListener<com.motiv.example.PhotosListResponse>
                    onResponseListener) {
        updatePhotosListResponse(photosListResponse);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase
                                .photosListResponseDao()
                                .savePhotosListResponse(photosListResponse);
                        passSuccessResultToUi(photosListResponse, onResponseListener);
                    }
                });
    }

    public void savePhotosListResponses(
            final java.util.List<com.motiv.example.PhotosListResponse> photosListResponses,
            final com.motiv.example.OnResponseListener<
                            java.util.List<com.motiv.example.PhotosListResponse>>
                    onResponseListener) {
        updatePhotosListResponses(photosListResponses);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase
                                .photosListResponseDao()
                                .savePhotosListResponses(photosListResponses);
                        passSuccessResultToUi(photosListResponses, onResponseListener);
                    }
                });
    }

    public void loadPhotosListResponses(
            final com.motiv.example.OnResponseListener<
                            java.util.List<com.motiv.example.PhotosListResponse>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<PhotosListResponseWithReferences> resultWithReferences =
                                myRoomDatabase.photosListResponseDao().getPhotosListResponses();
                        List<PhotosListResponse> result = new ArrayList<>();
                        for (PhotosListResponseWithReferences withReference :
                                resultWithReferences) {
                            result.add(withReference.getPhotosListResponse());
                        }

                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void loadPhotosListResponse(
            final java.lang.String id,
            final com.motiv.example.OnResponseListener<com.motiv.example.PhotosListResponse>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final PhotosListResponseWithReferences resultWithReference =
                                myRoomDatabase.photosListResponseDao().getPhotosListResponse(id);
                        passSuccessResultToUi(
                                resultWithReference.getPhotosListResponse(), onResponseListener);
                    }
                });
    }

    public void savePhoto(
            final com.motiv.example.Photo photo,
            final com.motiv.example.OnResponseListener<com.motiv.example.Photo>
                    onResponseListener) {
        updatePhoto(photo);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.photoDao().savePhoto(photo);
                        passSuccessResultToUi(photo, onResponseListener);
                    }
                });
    }

    public void savePhotos(
            final java.util.List<com.motiv.example.Photo> photos,
            final com.motiv.example.OnResponseListener<java.util.List<com.motiv.example.Photo>>
                    onResponseListener) {
        updatePhotos(photos);
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.photoDao().savePhotos(photos);
                        passSuccessResultToUi(photos, onResponseListener);
                    }
                });
    }

    public void loadPhotos(
            final com.motiv.example.OnResponseListener<java.util.List<com.motiv.example.Photo>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<PhotoWithReferences> resultWithReferences =
                                myRoomDatabase.photoDao().getPhotos();
                        List<Photo> result = new ArrayList<>();
                        for (PhotoWithReferences withReference : resultWithReferences) {
                            result.add(withReference.getPhoto());
                        }

                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void loadPhoto(
            final java.lang.String id,
            final com.motiv.example.OnResponseListener<com.motiv.example.Photo>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final PhotoWithReferences resultWithReference =
                                myRoomDatabase.photoDao().getPhoto(id);
                        passSuccessResultToUi(resultWithReference.getPhoto(), onResponseListener);
                    }
                });
    }

    public void saveAuthToken(
            final com.motiv.example.AuthToken authToken,
            final com.motiv.example.OnResponseListener<com.motiv.example.AuthToken>
                    onResponseListener) {
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.authTokenDao().saveAuthToken(authToken);
                        passSuccessResultToUi(authToken, onResponseListener);
                    }
                });
    }

    public void saveAuthTokens(
            final java.util.List<com.motiv.example.AuthToken> authTokens,
            final com.motiv.example.OnResponseListener<java.util.List<com.motiv.example.AuthToken>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        myRoomDatabase.authTokenDao().saveAuthTokens(authTokens);
                        passSuccessResultToUi(authTokens, onResponseListener);
                    }
                });
    }

    public void loadAuthTokens(
            final com.motiv.example.OnResponseListener<java.util.List<com.motiv.example.AuthToken>>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<AuthToken> result =
                                myRoomDatabase.authTokenDao().getAuthTokens();
                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public void loadAuthToken(
            final java.lang.String id,
            final com.motiv.example.OnResponseListener<com.motiv.example.AuthToken>
                    onResponseListener) {

        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final AuthToken result = myRoomDatabase.authTokenDao().getAuthToken(id);
                        passSuccessResultToUi(result, onResponseListener);
                    }
                });
    }

    public static void updateUser(User user) {
        user.setLinksId(user.getLinks().getId());
    }

    public static void updateUsers(java.util.List<User> users) {
        for (User user : users) {
            updateUser(user);
        }
    }

    public static void updateLinks(Links links) {
        links.setEditId(links.getEdit().getId());
        links.setSelfId(links.getSelf().getId());
        links.setAvatarId(links.getAvatar().getId());
    }

    public static void updateLinkss(java.util.List<Links> linkss) {
        for (Links links : linkss) {
            updateLinks(links);
        }
    }

    public static void updateUserResponse(UserResponse userResponse) {
        userResponse.setResultId(userResponse.getResult().getId());
        userResponse.setMetaId(userResponse.getMeta().getId());
    }

    public static void updateUserResponses(java.util.List<UserResponse> userResponses) {
        for (UserResponse userResponse : userResponses) {
            updateUserResponse(userResponse);
        }
    }

    public static void updateUsersResponse(UsersResponse usersResponse) {
        usersResponse.setMetaId(usersResponse.getMeta().getId());
        for (com.motiv.example.User user : usersResponse.getResult()) {
            user.setResultOwnerId(usersResponse.getId());
        }
    }

    public static void updateUsersResponses(java.util.List<UsersResponse> usersResponses) {
        for (UsersResponse usersResponse : usersResponses) {
            updateUsersResponse(usersResponse);
        }
    }

    public static void updatePostsListResponse(PostsListResponse postsListResponse) {
        postsListResponse.setMetaId(postsListResponse.getMeta().getId());
        for (com.motiv.example.Post post : postsListResponse.getResult()) {
            post.setResultOwnerId(postsListResponse.getId());
        }
    }

    public static void updatePostsListResponses(
            java.util.List<PostsListResponse> postsListResponses) {
        for (PostsListResponse postsListResponse : postsListResponses) {
            updatePostsListResponse(postsListResponse);
        }
    }

    public static void updatePost(Post post) {
        post.setLinksId(post.getLinks().getId());
    }

    public static void updatePosts(java.util.List<Post> posts) {
        for (Post post : posts) {
            updatePost(post);
        }
    }

    public static void updatePhotosListResponse(PhotosListResponse photosListResponse) {
        photosListResponse.setMetaId(photosListResponse.getMeta().getId());
        for (com.motiv.example.Photo photo : photosListResponse.getResult()) {
            photo.setResultOwnerId(photosListResponse.getId());
        }
    }

    public static void updatePhotosListResponses(
            java.util.List<PhotosListResponse> photosListResponses) {
        for (PhotosListResponse photosListResponse : photosListResponses) {
            updatePhotosListResponse(photosListResponse);
        }
    }

    public static void updatePhoto(Photo photo) {
        photo.setLinksId(photo.getLinks().getId());
    }

    public static void updatePhotos(java.util.List<Photo> photos) {
        for (Photo photo : photos) {
            updatePhoto(photo);
        }
    }

    private <T> void passSuccessResultToUi(
            final T result, final OnResponseListener<T> onResponseListener) {
        handler.post(
                new Runnable() {
                    @Override
                    public void run() {
                        onResponseListener.onSuccess(result);
                    }
                });
    }
}
