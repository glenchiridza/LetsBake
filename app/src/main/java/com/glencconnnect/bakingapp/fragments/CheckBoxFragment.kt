/**
 * Created by glenc on Jul 2021
 **/
package com.glencconnnect.bakingapp.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import com.glencconnnect.bakingapp.R
import com.glencconnnect.bakingapp.models.Recipe

abstract class CheckBoxFragment: Fragment() {

    companion object{
        private const val KEY_CHECKBOX: String = "key_checked_box"
    }
    private lateinit var checkBoxes:Array<CheckBox>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val index:Int? = arguments?.getInt(ViewPagerFragment.KEY_RECIPE_INDEX)

        val view:View = inflater.inflate(R.layout.fragment_checkbox,container,false)

        val constraintLayout:LinearLayoutCompat = view.findViewById(R.id.checkboxesLayout)
        var contents:List<String> = getContents(index)


        checkBoxes = Array<CheckBox>(contents.size){CheckBox(context)}
        var checkedBoxes = BooleanArray(checkBoxes.size)

        if(savedInstanceState?.getBooleanArray(KEY_CHECKBOX) != null){
            checkedBoxes = savedInstanceState.getBooleanArray(KEY_CHECKBOX)!!
        }

        setUpCheckBoxes(contents,constraintLayout,checkedBoxes)

        return view
    }

    abstract fun getContents(index: Int?): List<String>

    private fun setUpCheckBoxes(
        contents: List<String>,
        container: ViewGroup,
        checkedBoxes: BooleanArray
    ) {

        for ((i, content) in contents.withIndex()) {
            checkBoxes[i] = CheckBox(activity)
            checkBoxes[i].setPadding(8, 16, 8, 16)
            checkBoxes[i].textSize = 20f
            checkBoxes[i].setTextColor(Color.DKGRAY)
            checkBoxes[i].text = content
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