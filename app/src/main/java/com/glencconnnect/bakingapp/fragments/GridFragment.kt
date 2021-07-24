/**
 * Created by glenc on Jul 2021
 **/
package com.glencconnnect.bakingapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.glencconnnect.bakingapp.R
import com.glencconnnect.bakingapp.adapters.GridAdapter

class GridFragment : Fragment(){

    interface OnGridRecipeSelectedInterface {
        fun onGridRecipeSelected(index:Int)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val listener: OnGridRecipeSelectedInterface = activity as OnGridRecipeSelectedInterface
        var view:View = inflater.inflate(R.layout.fragment_list,container,false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerview)
        val adapter = GridAdapter(listener)
        recyclerView.adapter = adapter
        val displayMetrics = resources.displayMetrics
        val dpWidth = displayMetrics.widthPixels / displayMetrics.density
        var num_of_columns = (dpWidth / 200) as Int
        val linearLayoutManager:LinearLayoutManager = GridLayoutManager(activity, num_of_columns)
        recyclerView.layoutManager = linearLayoutManager



        return view
    }


    override fun onStop() {
        activity?.title = resources.getString(R.string.app_name)
        super.onStop()
    }
}