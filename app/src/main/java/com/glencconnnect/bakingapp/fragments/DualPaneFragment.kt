/**
 * Created by glenc on Jul 2021
 **/
package com.glencconnnect.bakingapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.glencconnnect.bakingapp.R
import com.glencconnnect.bakingapp.models.Recipe

class DualPaneFragment: Fragment() {


    companion object{

        const val INGREDIENTS_FRAGMENT: String = "ingredients_frgament"
        const val DIRECTIONS_FRAGMENT: String = "DIRECTIONS_FRAGMENT"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val index = arguments?.getInt(ViewPagerFragment.KEY_RECIPE_INDEX)
        activity?.title = Recipe.names[index!!]
        val view: View = inflater.inflate(R.layout.fragment_dualpane, container, false)

        val fragmentManager = childFragmentManager
        val savedIngredientsFragment:IngredientsFragment = 
            fragmentManager.findFragmentByTag(INGREDIENTS_FRAGMENT) as IngredientsFragment


        if(savedIngredientsFragment == null){
            val ingredientsFragment = IngredientsFragment()
            var bundle = Bundle()
            bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index)
            ingredientsFragment.arguments = bundle

            fragmentManager.beginTransaction()
                .add(R.id.left_placeholder,ingredientsFragment, INGREDIENTS_FRAGMENT)
                .commit()
        }
        val savedDirectionsFragment:DirectionsFragment =
            fragmentManager.findFragmentByTag(DIRECTIONS_FRAGMENT) as DirectionsFragment

        if(savedDirectionsFragment == null){
            val directionsFragment = DirectionsFragment()
            val bundle = Bundle()
            bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index)
            directionsFragment.arguments = bundle

            fragmentManager.beginTransaction()
                .add(R.id.right_placeholder,directionsFragment, INGREDIENTS_FRAGMENT)
                .commit()
        }


        return view
    }

}