package com.motiv.example;


public interface BottomNavigationDashboardContract {

    public interface View {

        public void navigationControllerstartDestinationById(int arg0);
    }

    public interface Presenter {

        public void eloonNavigationItemSelected(android.view.MenuItem argument0);
    }
}
