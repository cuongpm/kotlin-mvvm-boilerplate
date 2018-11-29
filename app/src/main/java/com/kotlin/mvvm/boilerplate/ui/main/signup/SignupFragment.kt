package com.kotlin.mvvm.boilerplate.ui.main.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.mvvm.boilerplate.databinding.FragmentSignupBinding
import com.kotlin.mvvm.boilerplate.di.ActivityScoped
import com.kotlin.mvvm.boilerplate.ui.main.base.BaseFragment
import javax.inject.Inject

/**
 * Created by cuongpm on 11/29/18.
 */

@ActivityScoped
class SignupFragment @Inject constructor() : BaseFragment() {

    private lateinit var dataBinding: FragmentSignupBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = FragmentSignupBinding.inflate(inflater, container, false).apply {
            viewModel = (activity as SignupActivity).viewModel
        }

        return dataBinding.root
    }

}