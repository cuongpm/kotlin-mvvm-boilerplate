package com.kotlin.mvvm.boilerplate.ui.main.signup

import android.os.Bundle
import com.kotlin.mvvm.boilerplate.R
import com.kotlin.mvvm.boilerplate.ui.main.base.BaseActivity
import com.kotlin.mvvm.boilerplate.util.ext.addFragment

/**
 * Created by cuongpm on 11/29/18.
 */

class SignupActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singup)

        addFragment(R.id.content_frame, ::SignupFragment)
    }

}
