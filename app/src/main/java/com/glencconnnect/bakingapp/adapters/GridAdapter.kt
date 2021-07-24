package com.glencconnnect.bakingapp.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.glencconnnect.bakingapp.R
import com.glencconnnect.bakingapp.fragments.GridFragment

class GridAdapter(var listener:GridFragment.OnGridRecipeSelectedInterface) : RecyclerAdapter() {


    override fun getLayoutID(): Int {
        return R.layout.grid_item
    }

    override fun onRecipeSelected(index: Int) {
        listener!!.onGridRecipeSelected(index)
    }




}