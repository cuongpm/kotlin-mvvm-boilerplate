package com.kotlin.mvvm.boilerplate.data.local.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

/**
 * Created by cuongpm on 12/1/18.
 */

@Dao
interface NewsDao {

    /**
     * Select all news from News table
     *
     * @return all news
     */
    @Query("SELECT * FROM News")
    fun getAllNews(): List<NewsEntity>

    /**
     * Insert a news in the database. If the news already exists, replace it
     *
     * @param news the news to be inserted
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(news: NewsEntity)

}