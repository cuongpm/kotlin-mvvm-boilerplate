package com.kotlin.mvvm.boilerplate.di.module

import com.kotlin.mvvm.boilerplate.data.local.UserLocalDataSource
import com.kotlin.mvvm.boilerplate.data.remote.UserRemoteDataSource
import com.kotlin.mvvm.boilerplate.data.repository.UserDataSource
import com.kotlin.mvvm.boilerplate.di.Local
import com.kotlin.mvvm.boilerplate.di.Remote
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created by cuongpm on 11/29/18.
 */

@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    @Local
    abstract fun bindUserLocalDataSource(userLocalDataSource: UserLocalDataSource): UserDataSource

    @Singleton
    @Binds
    @Remote
    abstract fun bindUserRemoteDataSource(userRemoteDataSource: UserRemoteDataSource): UserDataSource
}