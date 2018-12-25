package com.kotlin.mvvm.boilerplate.di.module

import android.app.Application
import android.content.Context
import com.kotlin.mvvm.boilerplate.BLApplication
import com.kotlin.mvvm.boilerplate.di.qualifier.ApplicationContext
import dagger.Binds
import dagger.Module

/**
 * Created by cuongpm on 11/29/18.
 */

@Module
abstract class AppModule {

    @Binds
    @ApplicationContext
    abstract fun bindApplicationContext(application: BLApplication): Context

    @Binds
    abstract fun bindApplication(application: BLApplication): Application
}