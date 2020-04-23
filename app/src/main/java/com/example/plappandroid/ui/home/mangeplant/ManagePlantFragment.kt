package com.example.plappandroid.ui.home.mangeplant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.example.plappandroid.R
import com.example.plappandroid.internal.ArgNotFoundException
import com.example.plappandroid.ui.base.ScopedFragment
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.factory

class ManagePlantFragment : ScopedFragment(), KodeinAware {
    override val kodein by closestKodein()
    private val managePlantViewmodelInstanceFactory: ((Long) -> ManagePlantViewmodelFactory ) by factory()



    private lateinit var viewModel: ManagePlantViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.manage_plant_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val safeArgs = arguments?.let {ManagePlantFragmentArgs.fromBundle(it)}
        val plantId = safeArgs?.plantId ?: throw ArgNotFoundException()
        viewModel = ViewModelProvider(this, managePlantViewmodelInstanceFactory(plantId)).get(ManagePlantViewModel::class.java)

        bindUI()
    }

    fun bindUI(){

    }

}
