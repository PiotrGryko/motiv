package com.motiv.example;

import androidx.fragment.app.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public interface UsersFragmentContract {

    public interface View {

        public void usersListAdaptersetData(java.util.List<com.motiv.example.User> arg0);

        public void showToast(java.lang.String arg0);

        public void navigationControllerstartUserActivity(com.motiv.example.User arg0);
    }

    public interface Presenter {

        public void goApigetUsersList();

        public void eloonItemClick(int argument0, com.motiv.example.User argument1);
    }
}
