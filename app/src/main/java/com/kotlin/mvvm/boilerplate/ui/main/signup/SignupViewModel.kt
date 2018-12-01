package com.kotlin.mvvm.boilerplate.ui.main.signup

import android.arch.lifecycle.ViewModel
import android.content.Context
import com.kotlin.mvvm.boilerplate.data.repository.UserRepository
import com.kotlin.mvvm.boilerplate.util.SingleLiveEvent
import javax.inject.Inject

/**
 * Created by cuongpm on 11/29/18.
 */

class SignupViewModel @Inject constructor(
    private val context: Context,
    private val userRepository: UserRepository
) : ViewModel() {

    val loginEvent = SingleLiveEvent<Void>()

    fun login() {
        loginEvent.call()
    }
}