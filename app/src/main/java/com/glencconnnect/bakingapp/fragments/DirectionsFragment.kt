/**
 * Created by glenc on Jul 2021
 **/
package com.glencconnnect.bakingapp.fragments

import com.glencconnnect.bakingapp.models.Recipe


class DirectionsFragment:CheckBoxFragment(){
    override fun getContents(index: Int?): List<String> {
        return Recipe.directions[index!!].split("`")
    }

}