package com.example.plappandroid.ui.home.mangeplant

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.example.plappandroid.R

class ManagePlantFragment : Fragment() {

    companion object {
        fun newInstance() = ManagePlantFragment()
    }

    private lateinit var viewModel: ManagePlantViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.manage_plant_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ManagePlantViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
