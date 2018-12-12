package com.kotlin.mvvm.boilerplate.data.repository

import com.kotlin.mvvm.boilerplate.di.qualifier.LocalData
import com.kotlin.mvvm.boilerplate.di.qualifier.RemoteData
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by cuongpm on 11/29/18.
 */

@Singleton
class NewsRepository @Inject constructor(
    @LocalData private val localDataSource: NewsDataSource,
    @RemoteData private val remoteDataSource: NewsDataSource
) : NewsDataSource {

    override fun getAllNews() {
    }

    override fun getAllComments() {
    }
}