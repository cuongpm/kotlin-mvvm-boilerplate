package com.kotlin.mvvm.boilerplate.di.module

import android.arch.persistence.room.Room
import com.kotlin.mvvm.boilerplate.BLApplication
import com.kotlin.mvvm.boilerplate.data.local.room.AppDatabase
import com.kotlin.mvvm.boilerplate.data.local.room.NewsDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by cuongpm on 11/29/18.
 */

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(application: BLApplication): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "bl.db").build()
    }

    @Singleton
    @Provides
    fun provideNewsDAO(database: AppDatabase): NewsDAO = database.newsDAO()
}