package com.kotlin.mvvm.boilerplate.data.repository

import com.kotlin.mvvm.boilerplate.di.Local
import com.kotlin.mvvm.boilerplate.di.Remote
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by cuongpm on 11/29/18.
 */

@Singleton
class UserRepository @Inject constructor(
    @Local private val localDataSource: UserDataSource,
    @Remote private val remoteDataSource: UserDataSource
) : UserDataSource {

    override fun getUser(userId: String) {
    }
}