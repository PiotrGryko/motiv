package com.motiv.example;

import androidx.fragment.app.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public interface BottomNavigationDashboardContract {

    public interface View {

        public void navigationControllerstartDestinationById(int arg0);
    }

    public interface Presenter {

        public void eloonNavigationItemSelected(android.view.MenuItem argument0);
    }
}
