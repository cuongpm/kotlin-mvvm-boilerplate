package com.kotlin.mvvm.boilerplate.data.local

import com.kotlin.mvvm.boilerplate.data.repository.UserDataSource
import javax.inject.Inject

/**
 * Created by cuongpm on 11/29/18.
 */

class UserLocalDataSource @Inject constructor() : UserDataSource {

    override fun getUser(userId: String) {
    }
}