package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.create_account_project.R

class RecipeAdapter(
    private val recipes: List<Recipe>,
    private val itemClickListener: (Recipe) -> Unit,
    private val likeClickListener: (Recipe) -> Unit,
    private val shareClickListener: (Recipe) -> Unit
) : RecyclerView.Adapter<RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(recipes[position], itemClickListener, likeClickListener, shareClickListener)
    }

    override fun getItemCount(): Int = recipes.size
}