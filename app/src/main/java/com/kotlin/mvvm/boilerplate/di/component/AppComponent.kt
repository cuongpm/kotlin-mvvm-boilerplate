package com.kotlin.mvvm.boilerplate.di.component

import com.kotlin.mvvm.boilerplate.App
import com.kotlin.mvvm.boilerplate.di.module.ActivityBindingModule
import com.kotlin.mvvm.boilerplate.di.module.AppModule
import com.kotlin.mvvm.boilerplate.di.module.RepositoryModule
import com.kotlin.mvvm.boilerplate.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by cuongpm on 11/29/18.
 */

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class,
    RepositoryModule::class, ViewModelModule::class, ActivityBindingModule::class])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent
    }
}