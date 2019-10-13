package com.motiv.example;

import androidx.fragment.app.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public interface OnResponseListener<T> {

    public void onSuccess(T response);

    public void onError(Exception error);
}
