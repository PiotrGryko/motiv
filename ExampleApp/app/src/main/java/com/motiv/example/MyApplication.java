package com.motiv.example;

import android.app.Activity;
import android.app.Application;
import androidx.fragment.app.*;
import com.motiv.example.di.AppComponent;
import com.motiv.example.di.AppModule;
import com.motiv.example.di.DaggerAppComponent;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import io.realm.*;
import javax.inject.*;

public class MyApplication extends Application implements HasActivityInjector {

    @Inject DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
    private AppComponent appComponent;

    @Override
    public void onCreate() {

        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {

        return dispatchingAndroidInjector;
    }

    public AppComponent getAppComponent() {

        return appComponent;
    }
}
