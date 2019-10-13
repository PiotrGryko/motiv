package com.motiv.example;

import androidx.fragment.app.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public interface PhotosFragmentContract {

    public interface View {

        public void photosPagerAdaptersetData(java.util.List<com.motiv.example.Photo> arg0);
    }

    public interface Presenter {

        public void goApigetPhotos();
    }
}
