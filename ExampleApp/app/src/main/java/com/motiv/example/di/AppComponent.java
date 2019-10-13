package com.motiv.example.di;

import androidx.fragment.app.*;
import com.motiv.example.AuthApi;
import com.motiv.example.GoApi;
import com.motiv.example.MyApplication;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

@Singleton
@Component(modules = {AppModule.class, AndroidSupportInjectionModule.class, AppContributions.class})
public interface AppComponent {

    GoApi goApi();

    AuthApi authApi();

    void inject(MyApplication myApplication);
}
