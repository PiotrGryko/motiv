 
package com.motiv.example
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.LocalStorage
import com.motiv.example.databinding.MainactivityBinding
import kotlinx.android.synthetic.main.mainactivity.*

public class MainActivity : AppCompatActivity() {

    private lateinit var mainactivityBinding: MainactivityBinding

    private lateinit var usersListAdapter: UsersListAdapter

    private lateinit var postsAdapter: PostsAdapter

    private lateinit var photosPagerAdapter: PhotosPagerAdapter

    private lateinit var viewPagerFragmentsAdapter: ViewPagerFragmentsAdapter

    private lateinit var goApi: GoApi

    private lateinit var authApi: AuthApi

    private var daoRepository: DaoRepository = DaoRepositoryFactory.getInstance(this@MainActivity)

    private lateinit var localStorage: LocalStorage

    private lateinit var navigationController: NavigationController

    private lateinit var linearlayout00: LinearLayout

    private lateinit var edittext10: EditText

    private lateinit var button11: Button

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        mainactivityBinding = DataBindingUtil.setContentView(this, R.layout.mainactivity)

        usersListAdapter = UsersListAdapter()
        postsAdapter = PostsAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        viewPagerFragmentsAdapter = ViewPagerFragmentsAdapter(this@MainActivity.getSupportFragmentManager())
        localStorage = LocalStorage.getInstance(this@MainActivity)
        navigationController = NavigationController(this@MainActivity)
        goApi = GoApiFactory.getInstance(localStorage)
        authApi = AuthApiFactory.getInstance(localStorage)
        linearlayout00 = mainactivityBinding.linearlayout00
        edittext10 = mainactivityBinding.edittext10
        button11 = mainactivityBinding.button11

        button11.setOnClickListener(object : android.view.View.OnClickListener {
            override fun onClick(argument0: android.view.View) {
                authApi.getToken(object : com.motiv.example.OnResponseListener<com.motiv.example.AuthToken> {
                    override fun onSuccess(argument0: com.motiv.example.AuthToken) {
                        localStorage.putString("token", argument0.getToken())
                        goApi.getUser(
                            edittext10.getText().toString(),
                            object : com.motiv.example.OnResponseListener<com.motiv.example.UserResponse> {
                                override fun onSuccess(argument0: com.motiv.example.UserResponse) {
                                    Toast.makeText(this@MainActivity, argument0.getMeta().getMessage(), Toast.LENGTH_LONG).show()
                                    navigationController.startDrawerDashboard(argument0.getResult())
                                } override fun onError(argument0: Exception) {
                                } 
                            }
                        )
                    } override fun onError(argument0: Exception) {
                    } 
                })
            } 
        })
    }
}
