package com.kotlin.mvvm.boilerplate.ui.main.home

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.kotlin.mvvm.boilerplate.R
import com.kotlin.mvvm.boilerplate.ui.main.base.BaseActivity
import com.kotlin.mvvm.boilerplate.util.ext.addFragment
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singup)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)

        addFragment(R.id.content_frame, ::HomeFragment)
    }

}