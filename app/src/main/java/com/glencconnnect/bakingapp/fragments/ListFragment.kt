/**
 * Created by glenc on Jul 2021
 **/
package com.glencconnnect.bakingapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.glencconnnect.bakingapp.R
import com.glencconnnect.bakingapp.adapters.ListAdapter

class ListFragment : Fragment(){

    interface OnRecipeSelectedInterface {
        fun onRecipeSelected(index:Int)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val listener: OnRecipeSelectedInterface? = activity as OnRecipeSelectedInterface
        var view:View = inflater.inflate(R.layout.fragment_list,container,false)

        val recyclerView: RecyclerView = view.findViewById(R.id.list_recycler)
        val adapter = ListAdapter(listener)
        recyclerView.adapter = adapter
        val linearLayoutManager:LinearLayoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = linearLayoutManager



        return view
    }


}