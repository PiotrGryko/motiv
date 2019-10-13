package com.motiv.example;


public interface PhotosFragmentContract {

    public interface View {

        public void photosPagerAdaptersetData(java.util.List<com.motiv.example.Photo> arg0);
    }

    public interface Presenter {

        public void goApigetPhotos();
    }
}
