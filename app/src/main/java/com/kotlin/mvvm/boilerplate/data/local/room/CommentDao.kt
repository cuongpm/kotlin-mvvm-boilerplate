package com.kotlin.mvvm.boilerplate.data.local.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

/**
 * Created by cuongpm on 12/12/18.
 */

@Dao
interface CommentDao {

    /**
     * Select all comments from Comment table
     *
     * @return all comments
     */
    @Query("SELECT * FROM Comment")
    fun getAllComment(): List<CommentEntity>

    /**
     * Insert a comment in the database. If the comment already exists, replace it
     *
     * @param comment the comment to be inserted
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertComment(comment: CommentEntity)

}