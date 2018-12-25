package com.kotlin.mvvm.boilerplate.di.module

import com.kotlin.mvvm.boilerplate.data.local.NewsLocalDataSource
import com.kotlin.mvvm.boilerplate.data.remote.NewsRemoteDataSource
import com.kotlin.mvvm.boilerplate.data.repository.NewsDataSource
import com.kotlin.mvvm.boilerplate.data.repository.NewsRepository
import com.kotlin.mvvm.boilerplate.di.qualifier.LocalData
import com.kotlin.mvvm.boilerplate.di.qualifier.RemoteData
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
    @LocalData
    abstract fun bindNewsLocalDataSource(newsLocalDataSource: NewsLocalDataSource): NewsDataSource

    @Singleton
    @Binds
    @RemoteData
    abstract fun bindNewsRemoteDataSource(newsRemoteDataSource: NewsRemoteDataSource): NewsDataSource
}