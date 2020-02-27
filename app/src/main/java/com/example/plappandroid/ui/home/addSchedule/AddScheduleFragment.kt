package com.example.plappandroid.ui.home.addSchedule

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.example.plappandroid.R

class AddScheduleFragment : Fragment() {

    companion object {
        fun newInstance() = AddScheduleFragment()
    }

    private lateinit var viewModel: AddScheduleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_schedule_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddScheduleViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
