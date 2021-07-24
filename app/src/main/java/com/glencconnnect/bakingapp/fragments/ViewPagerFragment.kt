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

        return view
    }

    override fun onStop() {
        super.onStop()
        activity!!.title = resources.getString(R.string.app_name)
    }
}