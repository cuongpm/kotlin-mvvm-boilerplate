package com.kotlin.mvvm.boilerplate.di.module

import android.arch.persistence.room.Room
import com.kotlin.mvvm.boilerplate.BLApplication
import com.kotlin.mvvm.boilerplate.data.local.room.AppDatabase
import com.kotlin.mvvm.boilerplate.data.local.room.CommentDao
import com.kotlin.mvvm.boilerplate.data.local.room.NewsDao
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
    fun provideNewsDao(database: AppDatabase): NewsDao = database.newsDao()

    @Singleton
    @Provides
    fun provideCommentDao(database: AppDatabase): CommentDao = database.commentDao()
}