package dev.com.sfilizzola.wunderchallenge.view.activities


import android.databinding.DataBindingUtil
import android.os.Bundle
import dev.com.sfilizzola.wunderchallenge.R
import dev.com.sfilizzola.wunderchallenge.databinding.ActivityMainBinding
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import dev.com.sfilizzola.wunderchallenge.view.fragments.ListFragment


class MainActivity : BaseAcitvity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setUpNavigationBar()
    }

    private fun setUpNavigationBar() {
        val transaction = supportFragmentManager.beginTransaction()

        binding.mainNavigation.setOnNavigationItemSelectedListener( object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
               return when(item.itemId){
                   R.id.list_view -> {
                       val fragment = ListFragment()
                       transaction.replace(R.id.main_content,fragment)
                       transaction.addToBackStack(null)
                       transaction.commit()
                       true
                   }
                   R.id.map_view -> {
                       //TODO - replace fragment
                       true
                   } else -> false
               }
            }

        })
    }



}