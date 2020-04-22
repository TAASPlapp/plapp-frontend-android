package com.example.plappandroid.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.plappandroid.R
import com.example.plappandroid.network.ApiGatewayService
import com.example.plappandroid.ui.base.ScopedFragment
import kotlinx.android.synthetic.main.fragment_login.view.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein

class Login : ScopedFragment(), KodeinAware {
    override val kodein by closestKodein()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        view.loginToRegister.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_login_to_register,
                null
            )
        )
        view.loginB.setOnClickListener { v ->
            var eamil = view.email
            var password = view.password
            ApiGatewayService

        }


        // Inflate the layout for this fragment
        return view
    }

}
