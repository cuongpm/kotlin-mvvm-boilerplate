package com.kotlin.mvvm.boilerplate.data.remote

import com.kotlin.mvvm.boilerplate.data.local.room.CommentEntity
import com.kotlin.mvvm.boilerplate.data.local.room.NewsEntity
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Created by cuongpm on 12/1/18.
 */

interface NewsService {

    @GET("topstories.json")
    fun getTopNewsIds(): Flowable<List<Int>>

    @GET("item/{news_id}.json")
    fun getNews(@Path("news_id") newsId: Int): Flowable<NewsEntity>

    @GET("item/{comment_id}.json")
    fun getComment(@Path("comment_id") commentId: Int): Flowable<CommentEntity>
}