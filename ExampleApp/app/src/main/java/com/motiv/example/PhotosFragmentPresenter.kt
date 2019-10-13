 
package com.motiv.example
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.LocalStorage

public class PhotosFragmentPresenter(val view: PhotosFragmentContract.View, val goApi: GoApi, val authApi: AuthApi, val daoRepository: DaoRepository, val localStorage: LocalStorage) : PhotosFragmentContract.Presenter {

    override fun goApigetPhotos() {
        goApi.getPhotos(object : com.motiv.example.OnResponseListener<com.motiv.example.PhotosListResponse> {
            override fun onSuccess(argument0: com.motiv.example.PhotosListResponse) {
                view.photosPagerAdaptersetData(argument0.getResult())
            } override fun onError(argument0: Exception) {
            } 
        })
    }
}
