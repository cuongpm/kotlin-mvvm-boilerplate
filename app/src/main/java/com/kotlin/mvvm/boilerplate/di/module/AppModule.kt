package com.kotlin.mvvm.boilerplate.di.module

import android.content.Context
import com.kotlin.mvvm.boilerplate.BLApplication
import dagger.Binds
import dagger.Module

/**
 * Created by cuongpm on 11/29/18.
 */

@Module
abstract class AppModule {

    @Binds
    abstract fun bindApplicationContext(application: BLApplication): Context
}