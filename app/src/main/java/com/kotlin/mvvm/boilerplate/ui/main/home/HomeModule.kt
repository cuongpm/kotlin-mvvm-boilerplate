package com.kotlin.mvvm.boilerplate.ui.main.home

import com.kotlin.mvvm.boilerplate.di.FragmentScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by cuongpm on 11/29/18.
 */

@Module
abstract class HomeModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): HomeFragment
}