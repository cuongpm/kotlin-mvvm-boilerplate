package com.kotlin.mvvm.boilerplate.di.module

import com.kotlin.mvvm.boilerplate.data.local.LocalDataSource
import com.kotlin.mvvm.boilerplate.data.remote.RemoteDataSource
import com.kotlin.mvvm.boilerplate.data.repository.DataSource
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
    abstract fun bindLocalDataSource(localDataSource: LocalDataSource): DataSource

    @Singleton
    @Binds
    @Remote
    abstract fun bindRemoteDataSource(remoteDataSource: RemoteDataSource): DataSource
}