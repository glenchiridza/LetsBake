/**
 * Created by glenc on Jul 2021
 **/
package com.glencconnnect.bakingapp.adapters

import com.glencconnnect.bakingapp.R
import com.glencconnnect.bakingapp.fragments.ListFragment

class ListAdapter(var listener: ListFragment.OnRecipeSelectedInterface?) :RecyclerAdapter() {


    override fun getLayoutID(): Int {
        return R.layout.list_item
    }

    override fun onRecipeSelected(index: Int) {
        listener!!.onRecipeSelected(index)
    }




}