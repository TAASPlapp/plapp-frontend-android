package com.example.plappandroid.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plappandroid.R
import com.example.plappandroid.data.db.entity.Plant
import com.example.plappandroid.ui.base.ScopedFragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class HomeFragment : ScopedFragment(), KodeinAware {

    override val kodein by closestKodein()
    private lateinit var homeViewModel: HomeViewModel
    private val homeViewModelFactory: HomeViewModelFactory by instance()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view.addPlant.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_navigation_home_to_plant,
                null
            )
        )

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        homeViewModel = ViewModelProvider(this, homeViewModelFactory).get(HomeViewModel::class.java)
        bindUI()
    }


    private fun bindUI() = launch(Dispatchers.Main) {
        val plants = homeViewModel.plants.await()
        plants.observe(viewLifecycleOwner, Observer {
            if (it == null) return@Observer
            group_loading.visibility = View.GONE
            initRecyclerView(it.toPlantList())
        })
    }

    private fun List<Plant>.toPlantList(): List<ListItemPlant> {
        return this.map {
            ListItemPlant(it)
        }
    }


    private fun initRecyclerView(items: List<ListItemPlant>) {
        val groupAdapter = GroupAdapter<ViewHolder>().apply {
            addAll(items)
        }
        recyclerViewPlants.apply {
            layoutManager = LinearLayoutManager(this@HomeFragment.context)
            adapter = groupAdapter
            addItemDecoration(TopSpacingItemDecoration(30))
        }
        groupAdapter.setOnItemClickListener { item, view ->
            Toast.makeText(this@HomeFragment.context, "clicked", Toast.LENGTH_SHORT).show()
        }


    }


}

