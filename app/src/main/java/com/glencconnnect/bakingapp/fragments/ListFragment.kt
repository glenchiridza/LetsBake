/**
 * Created by glenc on Jul 2021
 **/
package com.glencconnnect.bakingapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.glencconnnect.bakingapp.R
import com.glencconnnect.bakingapp.adapters.ListAdapter

class ListFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view:View = inflater.inflate(R.layout.fragment_list,container,false)

        val recyclerView: RecyclerView = view.findViewById(R.id.list_recycler)
        val adapter:ListAdapter = ListAdapter()
        recyclerView.adapter = adapter
        val linearLayoutManager:LinearLayoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = linearLayoutManager



        return view
    }


}