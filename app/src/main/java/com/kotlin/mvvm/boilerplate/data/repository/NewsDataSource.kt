package com.kotlin.mvvm.boilerplate.data.repository

import com.kotlin.mvvm.boilerplate.data.local.room.CommentEntity
import com.kotlin.mvvm.boilerplate.data.local.room.NewsEntity
import io.reactivex.Flowable

/**
 * Created by cuongpm on 11/29/18.
 */

interface NewsDataSource {

    fun getAllNews(): Flowable<List<NewsEntity>>

    fun getAllComments(newsId: Int): Flowable<List<CommentEntity>>

    fun saveAllNews(news: List<NewsEntity>)

    fun saveAllComments(comments: List<CommentEntity>)

    fun refreshNews()

    fun refreshComments()
}