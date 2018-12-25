package com.kotlin.mvvm.boilerplate.ui.main.signup

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.mvvm.boilerplate.databinding.FragmentSignupBinding
import com.kotlin.mvvm.boilerplate.di.ActivityScoped
import com.kotlin.mvvm.boilerplate.ui.main.base.BaseFragment
import com.kotlin.mvvm.boilerplate.ui.main.home.MainActivity
import javax.inject.Inject

/**
 * Created by cuongpm on 11/29/18.
 */

@ActivityScoped
class SignupFragment @Inject constructor() : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var signupViewModel: SignupViewModel

    private lateinit var dataBinding: FragmentSignupBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        signupViewModel = ViewModelProviders.of(this, viewModelFactory).get(SignupViewModel::class.java)
        dataBinding = FragmentSignupBinding.inflate(inflater, container, false).apply {
            this.viewModel = signupViewModel
        }

        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLoginEvent()
    }

    private fun observeLoginEvent() {
        signupViewModel.loginEvent.observe(activity as SignupActivity, Observer {
            startActivity(Intent(context, MainActivity::class.java))
        })
    }
}