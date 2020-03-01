package com.example.plappandroid.ui.home

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.plappandroid.R
import com.example.plappandroid.data.db.entity.Plant
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.plant_list_elem.*

class ListItemPlant (
    val plant:Plant
) : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.apply {
            plantName.text = plant.name
            plantDescription.text = plant.description
            updateImage()
        }
    }

    override fun getLayout() = R.layout.plant_list_elem

    private fun ViewHolder.updateImage(){
        // per le immagini usiamo Glide -> servono opzioni in caso non sia diponibile l'immagine
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        Glide.with(this.containerView)
            .applyDefaultRequestOptions(requestOptions)
            .load(plant.image)
            .into(plantImage)
    }
}