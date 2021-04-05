package edu.kabi.live

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.kabi.live.ui.RecordActivity
import edu.kabi.live.ui.fragment.AccountFragment
import edu.kabi.live.ui.fragment.FavoriteFragment
import edu.kabi.live.ui.live.HomeFragment
import edu.kabi.live.ui.sort.SortFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val sortFragment = SortFragment()
        val favoriteFragment = FavoriteFragment()
        val accountFragment = AccountFragment()

        val fab: FloatingActionButton = findViewById(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(this, RecordActivity::class.java).putExtra(
                "url", "rtmp://47.94.222.34:1935/stream" + "jakevin"
            )
            startActivity(intent)
        }

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bar_home -> {
                    replaceFragment(homeFragment)
                    true
                }

                R.id.bar_sort -> {
                    replaceFragment(sortFragment)
                    true
                }

                R.id.bar_favorite -> {
                    replaceFragment(favoriteFragment)
                    true
                }

                R.id.bar_account -> {
                    replaceFragment(accountFragment)
                    true
                }

                else -> true
            }
        }
//
//        supportFragmentManager.beginTransaction()
//            .add(R.id.fragmentContainerView, myFragment)
//            .commit()

//        val homeButton: Button = findViewById(R.id.bar_home);
//        val sortButton: Button = findViewById(R.id.bar_sort);
//        val favoriteButton: Button = findViewById(R.id.bar_favorite);
//        val accountButton: Button = findViewById(R.id.bar_account);
//
//        homeButton.setOnClickListener {
//
//        }
//
//        accountButton.setOnClickListener {
//
//        }


    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_main, fragment)
            .commit()
    }
}