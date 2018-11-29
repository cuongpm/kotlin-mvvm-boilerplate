package com.kotlin.mvvm.boilerplate.ui.main.signup

import com.kotlin.mvvm.boilerplate.di.FragmentScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by cuongpm on 11/29/18.
 */

@Module
abstract class SignupModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindSignupFragment(): SignupFragment
}