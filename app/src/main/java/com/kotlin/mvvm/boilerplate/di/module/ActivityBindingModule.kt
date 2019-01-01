package com.kotlin.mvvm.boilerplate.di.module

import com.kotlin.mvvm.boilerplate.di.ActivityScoped
import com.kotlin.mvvm.boilerplate.ui.main.comment.CommentActivity
import com.kotlin.mvvm.boilerplate.ui.main.comment.CommentModule
import com.kotlin.mvvm.boilerplate.ui.main.home.HomeModule
import com.kotlin.mvvm.boilerplate.ui.main.home.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by cuongpm on 11/29/18.
 */

@Module
internal abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [HomeModule::class])
    internal abstract fun bindMainActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [CommentModule::class])
    internal abstract fun bindCommentActivity(): CommentActivity
}