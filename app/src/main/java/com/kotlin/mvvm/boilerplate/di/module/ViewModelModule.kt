package com.kotlin.mvvm.boilerplate.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.kotlin.mvvm.boilerplate.di.ViewModelKey
import com.kotlin.mvvm.boilerplate.ui.main.comment.CommentViewModel
import com.kotlin.mvvm.boilerplate.ui.main.home.HomeViewModel
import com.kotlin.mvvm.boilerplate.util.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

/**
 * Created by cuongpm on 11/29/18.
 */

@Module(includes = [AppModule::class, RepositoryModule::class])
abstract class ViewModelModule {

    @Singleton
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CommentViewModel::class)
    abstract fun bindCommentViewModel(viewModel: CommentViewModel): ViewModel
}