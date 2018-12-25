package com.kotlin.mvvm.boilerplate.data.local.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable

/**
 * Created by cuongpm on 12/12/18.
 */

@Dao
interface CommentDao {

    @Query("SELECT * FROM Comment")
    fun getAllCommentByNewsId(): Flowable<List<CommentEntity>>

    @Query("SELECT * FROM Comment WHERE id = :commentId")
    fun getCommentById(commentId: Int): Flowable<CommentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertComment(comment: CommentEntity)
}