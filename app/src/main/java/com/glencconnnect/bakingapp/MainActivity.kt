package com.glencconnnect.bakingapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.glencconnnect.bakingapp.fragments.ListFragment
import com.glencconnnect.bakingapp.models.Recipe

class MainActivity : AppCompatActivity(),ListFragment.OnRecipeSelectedInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment: ListFragment = ListFragment()
        val fragmentManager:FragmentManager = supportFragmentManager
        val fragmentTransaction:FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.value_holder,fragment)
        fragmentTransaction.commit()

    }

    override fun onRecipeSelected(index: Int) {
        Toast.makeText(this@MainActivity,Recipe.names[index],Toast.LENGTH_SHORT).show()
    }
}
