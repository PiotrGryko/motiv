 
package com.motiv.example
import androidx.fragment.app.*
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*

public interface OnResponseListener<T> {

    public fun onSuccess(response: T): Unit
    public fun onError(error: Exception): Unit
}
