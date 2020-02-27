package com.example.plappandroid.ui.home.addPlant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.example.plappandroid.R

class AddPlantFragment : Fragment() {

    companion object {
        fun newInstance() = AddPlantFragment()
    }

    private lateinit var viewModel: AddPlantViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_plant_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddPlantViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
