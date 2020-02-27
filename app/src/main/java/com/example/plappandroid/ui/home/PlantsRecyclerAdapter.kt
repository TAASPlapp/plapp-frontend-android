package com.example.plappandroid.ui.home

import android.graphics.drawable.LayerDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.plappandroid.R
import com.example.plappandroid.models.Plant
import kotlinx.android.synthetic.main.plant_list_elem.view.*

class PlantsRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<Plant> = ArrayList()


    //metodo responsabili nella creazione delle singole view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PlantViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.plant_list_elem, parent, false)
        )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is PlantViewHolder ->{
                holder.bind((items[position]))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(plantList: List<Plant>){
        items = plantList
    }

    //clsse che gestisce coem verranno mostrati gli oggetti nella lista
    class PlantViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val plantImage = itemView.plantImage
        val plantName = itemView.plantName
        val plantDescription = itemView.plantDescription

        fun bind(plant: Plant) {
            plantName.setText(plant.name)
            plantDescription.setText(plant.description)

            // per le immagini usiamo Glide -> servono opzioni in caso non sia diponibile l'immagine
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions )
                .load(plant.image)
                .into(plantImage)


        }

    }

}