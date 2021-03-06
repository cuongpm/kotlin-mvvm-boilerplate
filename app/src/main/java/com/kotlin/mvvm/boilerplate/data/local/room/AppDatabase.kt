package com.kotlin.mvvm.boilerplate.data.local.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by cuongpm on 12/1/18.
 */

@Database(entities = [NewsEntity::class, CommentEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao

    abstract fun commentDao(): CommentDao
}