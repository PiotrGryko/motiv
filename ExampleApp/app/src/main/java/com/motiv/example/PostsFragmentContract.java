package com.motiv.example;

import androidx.fragment.app.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public interface PostsFragmentContract {

    public interface View {

        public void postsAdaptersetData(java.util.List<com.motiv.example.Post> arg0);

        public void navigationControllerstartPostDetailsActivity(java.lang.String arg0);
    }

    public interface Presenter {

        public void goApigetPostsList();

        public void eloonItemClick(int argument0, com.motiv.example.Post argument1);
    }
}
