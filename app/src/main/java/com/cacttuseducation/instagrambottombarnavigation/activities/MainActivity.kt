package com.cacttuseducation.instagrambottombarnavigation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.cacttuseducation.instagrambottombarnavigation.R
import com.cacttuseducation.instagrambottombarnavigation.databinding.ActivityMainBinding
import com.cacttuseducation.instagrambottombarnavigation.fragments.ExploreFragment
import com.cacttuseducation.instagrambottombarnavigation.fragments.HomeFragment
import com.cacttuseducation.instagrambottombarnavigation.fragments.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onBottomNavigationClickHandler()
    }

    private fun onBottomNavigationClickHandler() {
        val homeFragment = HomeFragment()
        val exploreFragment = ExploreFragment()
        val profileFragment = ProfileFragment()

        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.homeMenuId -> setCurrentFragment(homeFragment)
                R.id.exploreMenuId -> setCurrentFragment(exploreFragment)
                R.id.profileMenuId -> setCurrentFragment(profileFragment)
            }
            true

        }
    }

    private fun setCurrentFragment(currentFragment : Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer,currentFragment)
            addToBackStack(null)
            commit()
        }
    }


}