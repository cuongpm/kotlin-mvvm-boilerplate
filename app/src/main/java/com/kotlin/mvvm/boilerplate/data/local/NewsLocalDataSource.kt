package com.kotlin.mvvm.boilerplate.data.local

import com.kotlin.mvvm.boilerplate.data.repository.NewsDataSource
import javax.inject.Inject

/**
 * Created by cuongpm on 11/29/18.
 */

class NewsLocalDataSource @Inject constructor() : NewsDataSource {

    override fun getAllNews() {
    }
}