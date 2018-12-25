package com.kotlin.mvvm.boilerplate.data.repository

import com.kotlin.mvvm.boilerplate.data.local.room.CommentEntity
import com.kotlin.mvvm.boilerplate.data.local.room.NewsEntity
import com.kotlin.mvvm.boilerplate.di.qualifier.LocalData
import com.kotlin.mvvm.boilerplate.di.qualifier.RemoteData
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by cuongpm on 11/29/18.
 */

@Singleton
class NewsRepository @Inject constructor(
    @LocalData private val localDataSource: NewsDataSource,
    @RemoteData private val remoteDataSource: NewsDataSource
) : NewsDataSource() {

    private var cachedNews = listOf<NewsEntity>()

    private var cacheIsDirty = true

    override fun getAllNews(): Flowable<List<NewsEntity>> {

        if (cachedNews.isNotEmpty() && !cacheIsDirty) {
            return Flowable.just(cachedNews)
        }

        val remoteNews = getAndSaveRemoteNews()

        return if (cacheIsDirty) remoteNews else {
            val localNews = getAndCacheLocalNews()
            Flowable.concat(localNews, remoteNews)
                .firstOrError()
                .toFlowable()
        }
    }

    private fun getAndSaveRemoteNews(): Flowable<List<NewsEntity>> {
        return remoteDataSource.getAllNews().doOnNext { news ->
            localDataSource.saveAllNews(news)
            cachedNews = news
        }
    }

    private fun getAndCacheLocalNews(): Flowable<List<NewsEntity>> {
        return localDataSource.getAllNews().doOnNext { news -> cachedNews = news }
    }

    override fun getAllComments(newsId: Int): Flowable<List<CommentEntity>> {
        return Flowable.empty()
    }

    override fun saveAllNews(news: List<NewsEntity>) {
    }

    override fun saveAllComments(comments: List<CommentEntity>) {
    }
}