package com.example.plappandroid.ui.discover.viewImage

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.example.plappandroid.R

class ViewImageFragment : Fragment() {

    companion object {
        fun newInstance() = ViewImageFragment()
    }

    private lateinit var viewModel: ViewImageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.view_image_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ViewImageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
