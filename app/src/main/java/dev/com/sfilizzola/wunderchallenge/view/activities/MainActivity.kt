package dev.com.sfilizzola.wunderchallenge.view.activities


import android.databinding.DataBindingUtil
import android.os.Bundle
import dev.com.sfilizzola.wunderchallenge.R
import dev.com.sfilizzola.wunderchallenge.databinding.ActivityMainBinding
import dev.com.sfilizzola.wunderchallenge.view.fragments.ListFragment
import dev.com.sfilizzola.wunderchallenge.view.fragments.MapFragment


class MainActivity : BaseAcitvity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setUpNavigationBar()
        startListFragment()
    }

    private fun setUpNavigationBar() {

        binding.mainNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.list_view -> {
                    startListFragment()
                    true
                }
                R.id.map_view -> {
                    startMapFragment()
                    true
                } else -> false
            }
        }
    }

    private fun startListFragment(){
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = ListFragment()
        transaction.replace(R.id.main_content,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun startMapFragment(){
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = MapFragment()
        transaction.replace(R.id.main_content,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}