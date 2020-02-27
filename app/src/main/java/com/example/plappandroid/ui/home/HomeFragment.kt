package com.example.plappandroid.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plappandroid.R
import com.example.plappandroid.models.HealthStatus
import com.example.plappandroid.models.Plant
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var plantAdapter : PlantsRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        view.addPlant.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_navigation_home_to_plant,
                null
            )
        )

        initRecyclerView(view);
        addDataSet()

        return view
    }

    private fun initRecyclerView(view: View){
        //apply mi permette di referenziare la rec view
        view.recyclerViewPlants.layoutManager = LinearLayoutManager(activity)
        plantAdapter = PlantsRecyclerAdapter()
        view.recyclerViewPlants.adapter = plantAdapter
        view.recyclerViewPlants.addItemDecoration(TopSpacingItemDecoration(30))

    }

    //dovrà parlare con rest api
    private fun addDataSet(){
        plantAdapter.submitList(plants)
    }



    private val plants = listOf(
        Plant(1,124,"Giuseppina", "magnificent plant", "Peony", HealthStatus.Health, "https://source.unsplash.com/XEmaJaM-4nE/300x300"),
        Plant(2,124,"Giorgia", "magnificent plant", "Cactus", HealthStatus.Health, "https://source.unsplash.com/f7PfM2NklZ4/300x300"),
        Plant(3,124,"Beppe", "magnificent plant", "Thyme", HealthStatus.Health, "https://source.unsplash.com/Wnr2ohKUIYw/300x300")
    )
}

