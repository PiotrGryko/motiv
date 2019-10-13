package com.motiv.example;


public interface DrawerDashboardContract {

    public interface View {

        public void navigationControllerstartUserActivity(com.motiv.example.User arg0);

        public com.motiv.example.User getuser();

        public void navigationControllerstartDestinationById(int arg0);
    }

    public interface Presenter {

        public void eloonClick(android.view.View argument0);

        public void eloonNavigationItemSelected(android.view.MenuItem argument0);
    }
}
