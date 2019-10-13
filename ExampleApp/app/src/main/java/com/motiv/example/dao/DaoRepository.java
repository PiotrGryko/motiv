package com.motiv.example.dao;

import com.motiv.example.AuthToken;
import com.motiv.example.Link;
import com.motiv.example.Links;
import com.motiv.example.Meta;
import com.motiv.example.OnResponseListener;
import com.motiv.example.Photo;
import com.motiv.example.PhotosListResponse;
import com.motiv.example.Post;
import com.motiv.example.PostsListResponse;
import com.motiv.example.User;
import com.motiv.example.UserResponse;
import com.motiv.example.UsersResponse;
import io.realm.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class DaoRepository {

    private Realm myDatabase;

    public DaoRepository(Realm myDatabase) {
        this.myDatabase = myDatabase;
    }

    public void saveUsers(
            final java.util.List<com.motiv.example.User> users,
            final OnResponseListener<java.util.List<com.motiv.example.User>> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {

                    @Override
                    public void execute(Realm realm) {

                        for (User user : users) {
                            realm.copyToRealm(user);
                        }
                    }
                },
                new Realm.Transaction.OnSuccess() {

                    @Override
                    public void onSuccess() {

                        onResponseListener.onSuccess(users);
                    }
                });
    }

    public void loadUser(
            final java.lang.String id,
            final OnResponseListener<com.motiv.example.User> onResponseListener) {
        User realmResponse = myDatabase.where(User.class).equalTo("id", id).findFirst();
        User result = myDatabase.copyFromRealm(realmResponse);
        onResponseListener.onSuccess(result);
    }

    public void loadUsers(
            final OnResponseListener<java.util.List<com.motiv.example.User>> onResponseListener) {
        RealmResults<User> result = myDatabase.where(User.class).findAll();
        final List<User> users = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            users.add(myDatabase.copyFromRealm(result.get(i)));
        }
        onResponseListener.onSuccess(users);
    }

    public void saveUser(final User user, final OnResponseListener<User> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealm(user);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        onResponseListener.onSuccess(user);
                    }
                });
    }

    public void saveLinkss(
            final java.util.List<com.motiv.example.Links> linkss,
            final OnResponseListener<java.util.List<com.motiv.example.Links>> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {

                    @Override
                    public void execute(Realm realm) {

                        for (Links links : linkss) {
                            realm.copyToRealm(links);
                        }
                    }
                },
                new Realm.Transaction.OnSuccess() {

                    @Override
                    public void onSuccess() {

                        onResponseListener.onSuccess(linkss);
                    }
                });
    }

    public void loadLinks(
            final java.lang.String id,
            final OnResponseListener<com.motiv.example.Links> onResponseListener) {
        Links realmResponse = myDatabase.where(Links.class).equalTo("id", id).findFirst();
        Links result = myDatabase.copyFromRealm(realmResponse);
        onResponseListener.onSuccess(result);
    }

    public void loadLinkss(
            final OnResponseListener<java.util.List<com.motiv.example.Links>> onResponseListener) {
        RealmResults<Links> result = myDatabase.where(Links.class).findAll();
        final List<Links> linkss = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            linkss.add(myDatabase.copyFromRealm(result.get(i)));
        }
        onResponseListener.onSuccess(linkss);
    }

    public void saveLinks(final Links links, final OnResponseListener<Links> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealm(links);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        onResponseListener.onSuccess(links);
                    }
                });
    }

    public void saveLinks(
            final java.util.List<com.motiv.example.Link> links,
            final OnResponseListener<java.util.List<com.motiv.example.Link>> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {

                    @Override
                    public void execute(Realm realm) {

                        for (Link link : links) {
                            realm.copyToRealm(link);
                        }
                    }
                },
                new Realm.Transaction.OnSuccess() {

                    @Override
                    public void onSuccess() {

                        onResponseListener.onSuccess(links);
                    }
                });
    }

    public void loadLink(
            final java.lang.String id,
            final OnResponseListener<com.motiv.example.Link> onResponseListener) {
        Link realmResponse = myDatabase.where(Link.class).equalTo("id", id).findFirst();
        Link result = myDatabase.copyFromRealm(realmResponse);
        onResponseListener.onSuccess(result);
    }

    public void loadLinks(
            final OnResponseListener<java.util.List<com.motiv.example.Link>> onResponseListener) {
        RealmResults<Link> result = myDatabase.where(Link.class).findAll();
        final List<Link> links = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            links.add(myDatabase.copyFromRealm(result.get(i)));
        }
        onResponseListener.onSuccess(links);
    }

    public void saveLink(final Link link, final OnResponseListener<Link> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealm(link);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        onResponseListener.onSuccess(link);
                    }
                });
    }

    public void saveUserResponses(
            final java.util.List<com.motiv.example.UserResponse> userResponses,
            final OnResponseListener<java.util.List<com.motiv.example.UserResponse>>
                    onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {

                    @Override
                    public void execute(Realm realm) {

                        for (UserResponse userResponse : userResponses) {
                            realm.copyToRealm(userResponse);
                        }
                    }
                },
                new Realm.Transaction.OnSuccess() {

                    @Override
                    public void onSuccess() {

                        onResponseListener.onSuccess(userResponses);
                    }
                });
    }

    public void loadUserResponse(
            final java.lang.String id,
            final OnResponseListener<com.motiv.example.UserResponse> onResponseListener) {
        UserResponse realmResponse =
                myDatabase.where(UserResponse.class).equalTo("id", id).findFirst();
        UserResponse result = myDatabase.copyFromRealm(realmResponse);
        onResponseListener.onSuccess(result);
    }

    public void loadUserResponses(
            final OnResponseListener<java.util.List<com.motiv.example.UserResponse>>
                    onResponseListener) {
        RealmResults<UserResponse> result = myDatabase.where(UserResponse.class).findAll();
        final List<UserResponse> userResponses = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            userResponses.add(myDatabase.copyFromRealm(result.get(i)));
        }
        onResponseListener.onSuccess(userResponses);
    }

    public void saveUserResponse(
            final UserResponse userResponse,
            final OnResponseListener<UserResponse> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealm(userResponse);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        onResponseListener.onSuccess(userResponse);
                    }
                });
    }

    public void saveMetas(
            final java.util.List<com.motiv.example.Meta> metas,
            final OnResponseListener<java.util.List<com.motiv.example.Meta>> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {

                    @Override
                    public void execute(Realm realm) {

                        for (Meta meta : metas) {
                            realm.copyToRealm(meta);
                        }
                    }
                },
                new Realm.Transaction.OnSuccess() {

                    @Override
                    public void onSuccess() {

                        onResponseListener.onSuccess(metas);
                    }
                });
    }

    public void loadMeta(
            final java.lang.String id,
            final OnResponseListener<com.motiv.example.Meta> onResponseListener) {
        Meta realmResponse = myDatabase.where(Meta.class).equalTo("id", id).findFirst();
        Meta result = myDatabase.copyFromRealm(realmResponse);
        onResponseListener.onSuccess(result);
    }

    public void loadMetas(
            final OnResponseListener<java.util.List<com.motiv.example.Meta>> onResponseListener) {
        RealmResults<Meta> result = myDatabase.where(Meta.class).findAll();
        final List<Meta> metas = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            metas.add(myDatabase.copyFromRealm(result.get(i)));
        }
        onResponseListener.onSuccess(metas);
    }

    public void saveMeta(final Meta meta, final OnResponseListener<Meta> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealm(meta);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        onResponseListener.onSuccess(meta);
                    }
                });
    }

    public void saveUsersResponses(
            final java.util.List<com.motiv.example.UsersResponse> usersResponses,
            final OnResponseListener<java.util.List<com.motiv.example.UsersResponse>>
                    onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {

                    @Override
                    public void execute(Realm realm) {

                        for (UsersResponse usersResponse : usersResponses) {
                            realm.copyToRealm(usersResponse);
                        }
                    }
                },
                new Realm.Transaction.OnSuccess() {

                    @Override
                    public void onSuccess() {

                        onResponseListener.onSuccess(usersResponses);
                    }
                });
    }

    public void loadUsersResponse(
            final java.lang.String id,
            final OnResponseListener<com.motiv.example.UsersResponse> onResponseListener) {
        UsersResponse realmResponse =
                myDatabase.where(UsersResponse.class).equalTo("id", id).findFirst();
        UsersResponse result = myDatabase.copyFromRealm(realmResponse);
        onResponseListener.onSuccess(result);
    }

    public void loadUsersResponses(
            final OnResponseListener<java.util.List<com.motiv.example.UsersResponse>>
                    onResponseListener) {
        RealmResults<UsersResponse> result = myDatabase.where(UsersResponse.class).findAll();
        final List<UsersResponse> usersResponses = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            usersResponses.add(myDatabase.copyFromRealm(result.get(i)));
        }
        onResponseListener.onSuccess(usersResponses);
    }

    public void saveUsersResponse(
            final UsersResponse usersResponse,
            final OnResponseListener<UsersResponse> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealm(usersResponse);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        onResponseListener.onSuccess(usersResponse);
                    }
                });
    }

    public void savePostsListResponses(
            final java.util.List<com.motiv.example.PostsListResponse> postsListResponses,
            final OnResponseListener<java.util.List<com.motiv.example.PostsListResponse>>
                    onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {

                    @Override
                    public void execute(Realm realm) {

                        for (PostsListResponse postsListResponse : postsListResponses) {
                            realm.copyToRealm(postsListResponse);
                        }
                    }
                },
                new Realm.Transaction.OnSuccess() {

                    @Override
                    public void onSuccess() {

                        onResponseListener.onSuccess(postsListResponses);
                    }
                });
    }

    public void loadPostsListResponse(
            final java.lang.String id,
            final OnResponseListener<com.motiv.example.PostsListResponse> onResponseListener) {
        PostsListResponse realmResponse =
                myDatabase.where(PostsListResponse.class).equalTo("id", id).findFirst();
        PostsListResponse result = myDatabase.copyFromRealm(realmResponse);
        onResponseListener.onSuccess(result);
    }

    public void loadPostsListResponses(
            final OnResponseListener<java.util.List<com.motiv.example.PostsListResponse>>
                    onResponseListener) {
        RealmResults<PostsListResponse> result =
                myDatabase.where(PostsListResponse.class).findAll();
        final List<PostsListResponse> postsListResponses = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            postsListResponses.add(myDatabase.copyFromRealm(result.get(i)));
        }
        onResponseListener.onSuccess(postsListResponses);
    }

    public void savePostsListResponse(
            final PostsListResponse postsListResponse,
            final OnResponseListener<PostsListResponse> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealm(postsListResponse);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        onResponseListener.onSuccess(postsListResponse);
                    }
                });
    }

    public void savePosts(
            final java.util.List<com.motiv.example.Post> posts,
            final OnResponseListener<java.util.List<com.motiv.example.Post>> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {

                    @Override
                    public void execute(Realm realm) {

                        for (Post post : posts) {
                            realm.copyToRealm(post);
                        }
                    }
                },
                new Realm.Transaction.OnSuccess() {

                    @Override
                    public void onSuccess() {

                        onResponseListener.onSuccess(posts);
                    }
                });
    }

    public void loadPost(
            final java.lang.String id,
            final OnResponseListener<com.motiv.example.Post> onResponseListener) {
        Post realmResponse = myDatabase.where(Post.class).equalTo("id", id).findFirst();
        Post result = myDatabase.copyFromRealm(realmResponse);
        onResponseListener.onSuccess(result);
    }

    public void loadPosts(
            final OnResponseListener<java.util.List<com.motiv.example.Post>> onResponseListener) {
        RealmResults<Post> result = myDatabase.where(Post.class).findAll();
        final List<Post> posts = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            posts.add(myDatabase.copyFromRealm(result.get(i)));
        }
        onResponseListener.onSuccess(posts);
    }

    public void savePost(final Post post, final OnResponseListener<Post> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealm(post);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        onResponseListener.onSuccess(post);
                    }
                });
    }

    public void savePhotosListResponses(
            final java.util.List<com.motiv.example.PhotosListResponse> photosListResponses,
            final OnResponseListener<java.util.List<com.motiv.example.PhotosListResponse>>
                    onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {

                    @Override
                    public void execute(Realm realm) {

                        for (PhotosListResponse photosListResponse : photosListResponses) {
                            realm.copyToRealm(photosListResponse);
                        }
                    }
                },
                new Realm.Transaction.OnSuccess() {

                    @Override
                    public void onSuccess() {

                        onResponseListener.onSuccess(photosListResponses);
                    }
                });
    }

    public void loadPhotosListResponse(
            final java.lang.String id,
            final OnResponseListener<com.motiv.example.PhotosListResponse> onResponseListener) {
        PhotosListResponse realmResponse =
                myDatabase.where(PhotosListResponse.class).equalTo("id", id).findFirst();
        PhotosListResponse result = myDatabase.copyFromRealm(realmResponse);
        onResponseListener.onSuccess(result);
    }

    public void loadPhotosListResponses(
            final OnResponseListener<java.util.List<com.motiv.example.PhotosListResponse>>
                    onResponseListener) {
        RealmResults<PhotosListResponse> result =
                myDatabase.where(PhotosListResponse.class).findAll();
        final List<PhotosListResponse> photosListResponses = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            photosListResponses.add(myDatabase.copyFromRealm(result.get(i)));
        }
        onResponseListener.onSuccess(photosListResponses);
    }

    public void savePhotosListResponse(
            final PhotosListResponse photosListResponse,
            final OnResponseListener<PhotosListResponse> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealm(photosListResponse);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        onResponseListener.onSuccess(photosListResponse);
                    }
                });
    }

    public void savePhotos(
            final java.util.List<com.motiv.example.Photo> photos,
            final OnResponseListener<java.util.List<com.motiv.example.Photo>> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {

                    @Override
                    public void execute(Realm realm) {

                        for (Photo photo : photos) {
                            realm.copyToRealm(photo);
                        }
                    }
                },
                new Realm.Transaction.OnSuccess() {

                    @Override
                    public void onSuccess() {

                        onResponseListener.onSuccess(photos);
                    }
                });
    }

    public void loadPhoto(
            final java.lang.String id,
            final OnResponseListener<com.motiv.example.Photo> onResponseListener) {
        Photo realmResponse = myDatabase.where(Photo.class).equalTo("id", id).findFirst();
        Photo result = myDatabase.copyFromRealm(realmResponse);
        onResponseListener.onSuccess(result);
    }

    public void loadPhotos(
            final OnResponseListener<java.util.List<com.motiv.example.Photo>> onResponseListener) {
        RealmResults<Photo> result = myDatabase.where(Photo.class).findAll();
        final List<Photo> photos = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            photos.add(myDatabase.copyFromRealm(result.get(i)));
        }
        onResponseListener.onSuccess(photos);
    }

    public void savePhoto(final Photo photo, final OnResponseListener<Photo> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealm(photo);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        onResponseListener.onSuccess(photo);
                    }
                });
    }

    public void saveAuthTokens(
            final java.util.List<com.motiv.example.AuthToken> authTokens,
            final OnResponseListener<java.util.List<com.motiv.example.AuthToken>>
                    onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {

                    @Override
                    public void execute(Realm realm) {

                        for (AuthToken authToken : authTokens) {
                            realm.copyToRealm(authToken);
                        }
                    }
                },
                new Realm.Transaction.OnSuccess() {

                    @Override
                    public void onSuccess() {

                        onResponseListener.onSuccess(authTokens);
                    }
                });
    }

    public void loadAuthToken(
            final java.lang.String id,
            final OnResponseListener<com.motiv.example.AuthToken> onResponseListener) {
        AuthToken realmResponse = myDatabase.where(AuthToken.class).equalTo("id", id).findFirst();
        AuthToken result = myDatabase.copyFromRealm(realmResponse);
        onResponseListener.onSuccess(result);
    }

    public void loadAuthTokens(
            final OnResponseListener<java.util.List<com.motiv.example.AuthToken>>
                    onResponseListener) {
        RealmResults<AuthToken> result = myDatabase.where(AuthToken.class).findAll();
        final List<AuthToken> authTokens = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            authTokens.add(myDatabase.copyFromRealm(result.get(i)));
        }
        onResponseListener.onSuccess(authTokens);
    }

    public void saveAuthToken(
            final AuthToken authToken, final OnResponseListener<AuthToken> onResponseListener) {
        myDatabase.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealm(authToken);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        onResponseListener.onSuccess(authToken);
                    }
                });
    }
}
