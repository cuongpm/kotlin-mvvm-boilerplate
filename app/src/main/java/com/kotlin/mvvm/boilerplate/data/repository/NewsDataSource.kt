package com.kotlin.mvvm.boilerplate.data.repository

import com.kotlin.mvvm.boilerplate.data.local.room.CommentEntity
import com.kotlin.mvvm.boilerplate.data.local.room.NewsEntity
import io.reactivex.Flowable

/**
 * Created by cuongpm on 11/29/18.
 */

abstract class NewsDataSource {

    abstract fun getAllNews(): Flowable<List<NewsEntity>>

    abstract fun getAllComments(newsId: Int): Flowable<List<CommentEntity>>

    open fun saveAllNews(news: List<NewsEntity>) {}

    open fun saveAllComments(comments: List<CommentEntity>) {}
}