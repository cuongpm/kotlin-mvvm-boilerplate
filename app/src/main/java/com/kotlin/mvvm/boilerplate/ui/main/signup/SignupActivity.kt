package com.kotlin.mvvm.boilerplate.ui.main.signup

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import com.kotlin.mvvm.boilerplate.R
import com.kotlin.mvvm.boilerplate.ui.main.base.BaseActivity
import com.kotlin.mvvm.boilerplate.ui.main.home.MainActivity
import com.kotlin.mvvm.boilerplate.util.ext.addFragment
import javax.inject.Inject

/**
 * Created by cuongpm on 11/29/18.
 */

class SignupActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: SignupViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singup)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SignupViewModel::class.java).apply {
            loginEvent.observe(this@SignupActivity, Observer {
                startActivity(Intent(this@SignupActivity, MainActivity::class.java))
            })
        }

        addFragment(R.id.content_frame, ::SignupFragment)
    }

}
