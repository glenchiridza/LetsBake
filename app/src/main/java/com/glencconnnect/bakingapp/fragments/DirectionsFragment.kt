/**
 * Created by glenc on Jul 2021
 **/
package com.glencconnnect.bakingapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import com.glencconnnect.bakingapp.R
import com.glencconnnect.bakingapp.models.Recipe

class DirectionsFragment: Fragment() {

    companion object{
        private const val KEY_CHECKED_BOX: String = "checked_box"
    }

    private lateinit var checkboxes:Array<CheckBox>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val index:Int? = arguments?.getInt(ViewPagerFragment.KEY_RECIPE_INDEX)
        val view:View = inflater.inflate(R.layout.fragment_directions,container,false)

        val linearlayout:LinearLayoutCompat  = view.findViewById<LinearLayoutCompat>(R.id.directionsLayout)

        val directions:List<String> = Recipe.directions[index!!].split("`")
        checkboxes = Array(directions.size){CheckBox(context)}
        var checkedBoxes = BooleanArray(checkboxes.size)
        if(savedInstanceState?.getBooleanArray(KEY_CHECKED_BOX) != null){
            checkedBoxes = savedInstanceState?.getBooleanArray(KEY_CHECKED_BOX)!!
        }
        getDirections(directions,linearlayout,checkedBoxes)



        return view
    }

    private fun getDirections(
        directions: List<String>,
        container: ViewGroup,
        checkedBoxes: BooleanArray
    ) {

        for((i,direction) in directions.withIndex()){
            checkboxes[i].setPadding(8,16,8,16)
            checkboxes[i].text = direction
            checkboxes[i].textSize = 20f
            container.addView(checkboxes[i])
            if (checkedBoxes[i]) checkboxes[i].toggle()

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        val checkedBoxState = BooleanArray(checkboxes.size)

        for((i,checkbox) in  checkboxes.withIndex()){
            checkedBoxState[i] = checkbox.isChecked
        }
        outState.putBooleanArray(KEY_CHECKED_BOX,checkedBoxState)
        super.onSaveInstanceState(outState)
    }
}