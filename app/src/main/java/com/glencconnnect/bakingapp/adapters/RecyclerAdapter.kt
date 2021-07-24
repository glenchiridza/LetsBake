/**
 * Created by glenc on Jul 2021
 **/
package com.glencconnnect.bakingapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.glencconnnect.bakingapp.R
import com.glencconnnect.bakingapp.fragments.ListFragment
import com.glencconnnect.bakingapp.models.Recipe

abstract class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(getLayoutID(),parent,false)
        return ListViewHolder(view)
    }

    abstract fun getLayoutID():Int


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bindView(position)
    }

    override fun getItemCount(): Int {
        return Recipe.names.size
    }


    inner class ListViewHolder(itemView:View): RecyclerView.ViewHolder(itemView), View.OnClickListener{


        private var recipeText: TextView = itemView.findViewById(R.id.tv_recipe_name)
        private var recipeImage: ImageView = itemView.findViewById(R.id.tv_recipe_image)


        init {
            itemView.setOnClickListener(this)
        }

        fun bindView(pos:Int){

            recipeText.text = Recipe.names[pos]
            recipeImage.setImageResource(Recipe.resourceIds[pos])
        }
        override fun onClick(view: View?) {

            onRecipeSelected(adapterPosition)
        }

    }

    abstract fun onRecipeSelected(adapterPosition: Int)

}