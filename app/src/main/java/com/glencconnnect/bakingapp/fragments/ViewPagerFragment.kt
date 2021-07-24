/**
 * Created by glenc on Jul 2021
 **/
package com.glencconnnect.bakingapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.glencconnnect.bakingapp.R
import com.glencconnnect.bakingapp.models.Recipe

class ViewPagerFragment:Fragment() {

    companion object{
        val  KEY_RECIPE_INDEX = "recipe_index"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val index = arguments?.getInt(KEY_RECIPE_INDEX)
//        Toast.makeText(activity, Recipe.names[index!!], Toast.LENGTH_SHORT).show()
        activity?.title = Recipe.names[index!!]
        val view:View = inflater.inflate(R.layout.fragment_viewpager,container,false)

        val ingredientsFragment = IngredientsFragment()

        val directionsFragment = DirectionsFragment()

        val viewpager = view.findViewById<ViewPager2>(R.id.viewpager)

        viewpager.adapter = object: FragmentStateAdapter(this@ViewPagerFragment){
            override fun getItemCount(): Int {
                return 2
            }

            override fun createFragment(position: Int): Fragment {

                return if (position == 0) ingredientsFragment else directionsFragment
            }

        }

        return view
    }

    override fun onStop() {
        super.onStop()
        activity!!.title = resources.getString(R.string.app_name)
    }

}