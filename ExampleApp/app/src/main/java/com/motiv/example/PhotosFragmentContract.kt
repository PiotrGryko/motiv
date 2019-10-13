 
package com.motiv.example
import kotlin.collections.List

public interface PhotosFragmentContract {

    public interface View {

        public fun photosPagerAdaptersetData(arg0: List<com.motiv.example.Photo>): Unit
    }

    public interface Presenter {

        public fun goApigetPhotos(): Unit
    }
}
