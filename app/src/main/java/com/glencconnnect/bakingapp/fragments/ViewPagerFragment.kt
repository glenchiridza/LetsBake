/**
 * Created by glenc on Jul 2021
 **/
package com.glencconnnect.bakingapp.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.glencconnnect.bakingapp.R
import com.glencconnnect.bakingapp.models.Recipe
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerFragment:Fragment() {

    companion object{
       const val  KEY_RECIPE_INDEX = "recipe_index"
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
        var bundle = Bundle()
        bundle.putInt(KEY_RECIPE_INDEX,index)
        ingredientsFragment.arguments = bundle

        val directionsFragment = DirectionsFragment()
        bundle = Bundle()
        bundle.putInt(KEY_RECIPE_INDEX,index)
        directionsFragment.arguments = bundle


        val viewpager = view.findViewById<ViewPager2>(R.id.viewpager)

        viewpager.adapter = object: FragmentStateAdapter(this@ViewPagerFragment){
            override fun getItemCount(): Int {
                return 2
            }

            override fun createFragment(position: Int): Fragment {

                return if (position == 0) ingredientsFragment else directionsFragment
            }


        }

        val tablayout = view.findViewById<TabLayout>(R.id.tablayout)

        tablayout.setTabTextColors(Color.DKGRAY,Color.WHITE)
        TabLayoutMediator(tablayout,viewpager){tab, position ->
            tab.text = if (position == 0) "Ingredients" else "Directions"

        }.attach()


        return view
    }

    override fun onStop() {
        super.onStop()
        activity?.title = resources.getString(R.string.app_name)
    }

}