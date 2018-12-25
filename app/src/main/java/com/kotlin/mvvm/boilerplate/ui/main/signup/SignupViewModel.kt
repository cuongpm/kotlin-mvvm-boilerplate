package com.kotlin.mvvm.boilerplate.ui.main.signup

import android.content.Context
import com.kotlin.mvvm.boilerplate.data.repository.NewsRepository
import com.kotlin.mvvm.boilerplate.di.qualifier.ApplicationContext
import com.kotlin.mvvm.boilerplate.ui.main.base.BaseViewModel
import com.kotlin.mvvm.boilerplate.util.SingleLiveEvent
import javax.inject.Inject

/**
 * Created by cuongpm on 11/29/18.
 */

class SignupViewModel @Inject constructor(
//    @ApplicationContext private val context: Context,
//    private val userRepository: NewsRepository
) : BaseViewModel() {

    val loginEvent = SingleLiveEvent<Void>()

    override fun start() {
    }

    override fun stop() {
    }

    fun login() {
        loginEvent.call()
    }
}