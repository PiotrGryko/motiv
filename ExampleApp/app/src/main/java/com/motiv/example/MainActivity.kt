 
package com.motiv.example
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.motiv.example.dao.DaoRepository
import com.motiv.example.dao.LocalStorage
import kotlinx.android.synthetic.main.mainactivity.*

public class MainActivity : AppCompatActivity(), MainActivityContract.View {

    private lateinit var presenter: MainActivityContract.Presenter

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
        setContentView(R.layout.mainactivity)

        usersListAdapter = UsersListAdapter()
        postsAdapter = PostsAdapter()
        photosPagerAdapter = PhotosPagerAdapter()
        viewPagerFragmentsAdapter = ViewPagerFragmentsAdapter(this@MainActivity.getSupportFragmentManager())
        localStorage = LocalStorage.getInstance(this@MainActivity)
        navigationController = NavigationController(this@MainActivity)
        goApi = GoApiFactory.getInstance(localStorage)
        authApi = AuthApiFactory.getInstance(localStorage)
        linearlayout00 = findViewById<LinearLayout>(R.id.linearlayout00)
        edittext10 = findViewById<EditText>(R.id.edittext10)
        button11 = findViewById<Button>(R.id.button11)

        presenter = MainActivityPresenter(this@MainActivity, goApi, authApi, daoRepository, localStorage)

        button11.setOnClickListener(object : android.view.View.OnClickListener {
            override fun onClick(argument0: android.view.View) {
                presenter.eloonClick(argument0)
            } 
        })
    } override fun edittext10getText(): CharSequence {
        return edittext10.getText().toString()
    } override fun showToast(arg0: String) {
        Toast.makeText(this@MainActivity, arg0, Toast.LENGTH_LONG).show()
    } override fun navigationControllerstartDrawerDashboard(arg0: com.motiv.example.User) {
        navigationController.startDrawerDashboard(arg0)
    }
}
