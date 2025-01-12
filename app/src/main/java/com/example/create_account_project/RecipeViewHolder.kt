package com.example.myapplication

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.create_account_project.R

class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val image: ImageView = itemView.findViewById(R.id.image)
    private val title: TextView = itemView.findViewById(R.id.title)
    private val btnLike: ImageButton = itemView.findViewById(R.id.btn_like)
    private val btnShare: ImageButton = itemView.findViewById(R.id.btn_share)

    fun bind(
        recipe: Recipe,
        itemClickListener: (Recipe) -> Unit,
        likeClickListener: (Recipe) -> Unit,
        shareClickListener: (Recipe) -> Unit
    ) {
        image.setImageResource(recipe.imageResId)
        title.text = recipe.title
        itemView.setOnClickListener { itemClickListener(recipe) }
        btnLike.setOnClickListener { likeClickListener(recipe) }
        btnShare.setOnClickListener { shareClickListener(recipe) }
    }
}