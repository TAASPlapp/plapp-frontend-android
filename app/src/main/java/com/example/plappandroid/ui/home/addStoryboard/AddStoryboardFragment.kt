package com.example.plappandroid.ui.home.addStoryboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.example.plappandroid.R

class AddStoryboardFragment : Fragment() {

    companion object {
        fun newInstance() = AddStoryboardFragment()
    }

    private lateinit var viewModel: AddStoryboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_storyboard_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddStoryboardViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
