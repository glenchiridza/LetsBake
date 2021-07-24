package com.glencconnnect.bakingapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.glencconnnect.bakingapp.fragments.ListFragment
import com.glencconnnect.bakingapp.fragments.ViewPagerFragment
import com.glencconnnect.bakingapp.models.Recipe

class MainActivity : AppCompatActivity(),ListFragment.OnRecipeSelectedInterface {
    companion object{
        val LIST_FRAGMENT =  "list_fragment"
        val VIEWPAGER_FRAGMENT =  "viewpager_fragment"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val savedFragment = supportFragmentManager.findFragmentById(R.id.value_holder)
        val savedFragment = supportFragmentManager.
                    findFragmentByTag(LIST_FRAGMENT)
        if(savedFragment == null) {
            val fragment = ListFragment()
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.value_holder, fragment, LIST_FRAGMENT)
            fragmentTransaction.commit()
        }

    }

    override fun onRecipeSelected(index: Int) {
        val fragment = ViewPagerFragment()
        val bundle = Bundle()
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX,index)
        fragment.arguments = bundle
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.value_holder, fragment, VIEWPAGER_FRAGMENT)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()

    }
}
