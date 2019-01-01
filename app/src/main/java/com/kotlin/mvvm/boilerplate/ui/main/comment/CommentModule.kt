package com.kotlin.mvvm.boilerplate.ui.main.comment

import com.kotlin.mvvm.boilerplate.di.FragmentScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by cuongpm on 12/31/18.
 */

@Module
abstract class CommentModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindCommentFragment(): CommentFragment
}