package com.kotlin.mvvm.boilerplate.data.local

import com.kotlin.mvvm.boilerplate.data.local.room.CommentDao
import com.kotlin.mvvm.boilerplate.data.local.room.CommentEntity
import com.kotlin.mvvm.boilerplate.data.local.room.NewsDao
import com.kotlin.mvvm.boilerplate.data.local.room.NewsEntity
import com.kotlin.mvvm.boilerplate.data.repository.NewsDataSource
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by cuongpm on 11/29/18.
 */

@Singleton
class NewsLocalDataSource @Inject constructor(
    private val newsDao: NewsDao,
    private val commentDao: CommentDao
) : NewsDataSource() {

    override fun getAllNews(): Flowable<List<NewsEntity>> {
        return newsDao.getAllNews()
    }

    override fun getAllComments(newsId: Int): Flowable<List<CommentEntity>> {
        return commentDao.getAllCommentByNewsId()
    }

    override fun saveAllNews(news: List<NewsEntity>) {
    }

    override fun saveAllComments(comments: List<CommentEntity>) {
    }
}