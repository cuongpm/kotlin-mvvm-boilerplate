package com.kotlin.mvvm.boilerplate.di.module

import android.content.Context
import com.kotlin.mvvm.boilerplate.App
import dagger.Binds
import dagger.Module

/**
 * Created by cuongpm on 11/29/18.
 */

@Module
abstract class AppModule {

    @Binds
    abstract fun bindApplicationContext(app: App): Context
}