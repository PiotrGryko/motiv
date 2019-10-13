package com.motiv.example;

import androidx.fragment.app.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public interface PostDetailsActivityContract {

    public interface View {

        public void textview10setText(java.lang.CharSequence arg0);

        public void textview11setText(java.lang.CharSequence arg0);
    }

    public interface Presenter {

        public void daoRepositoryloadPost(java.lang.String arg0);
    }
}
