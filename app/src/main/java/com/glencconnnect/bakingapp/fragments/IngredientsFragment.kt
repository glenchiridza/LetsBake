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

class IngredientsFragment: Fragment() {

    companion object{
        private val KEY_CHECKBOX: String = "key_checked_box"
    }
    private lateinit var checkBoxes:Array<CheckBox>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val index:Int? = arguments?.getInt(ViewPagerFragment.KEY_RECIPE_INDEX)
        val view:View = inflater.inflate(R.layout.fragment_ingredients,container,false)

        val constraintLayout:LinearLayoutCompat = view.findViewById(R.id.ingredientsLayout)
        var ingredients:List<String> = Recipe.ingredients[index!!].split("`")

        checkBoxes = Array<CheckBox>(ingredients.size){CheckBox(context)}
        var checkedBoxes = BooleanArray(checkBoxes.size)

        if(savedInstanceState?.getBooleanArray(KEY_CHECKBOX) != null){
            checkedBoxes = savedInstanceState.getBooleanArray(KEY_CHECKBOX)!!
        }

        setUpCheckBoxes(ingredients,constraintLayout,checkedBoxes)

        return view
    }

    private fun setUpCheckBoxes(
        ingredients: List<String>,
        container: ViewGroup,
        checkedBoxes: BooleanArray
    ) {

        for ((i, ingredient) in ingredients.withIndex()) {
            checkBoxes[i] = CheckBox(activity)
            checkBoxes[i].setPadding(8, 16, 8, 16)
            checkBoxes[i].textSize = 20f
            checkBoxes[i].text = ingredient
            container.addView(checkBoxes[i])

            if (checkedBoxes[i]) checkBoxes[i].toggle()

        }

    }
       override fun onSaveInstanceState(outState: Bundle) {
            val checkBoxState = BooleanArray(checkBoxes.size)

            for ((i, checkbox) in checkBoxes.withIndex()) {
                checkBoxState[i] = checkbox.isChecked
            }
            outState.putBooleanArray(KEY_CHECKBOX, checkBoxState)
            super.onSaveInstanceState(outState)
        }

}