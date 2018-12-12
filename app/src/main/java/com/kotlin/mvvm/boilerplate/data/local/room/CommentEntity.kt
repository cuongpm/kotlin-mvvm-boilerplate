package com.kotlin.mvvm.boilerplate.data.local.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by cuongpm on 12/12/18.
 */

@Entity(tableName = "Comment")
data class CommentEntity constructor(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "author")
    var author: String,

    @ColumnInfo(name = "comment")
    var comment: String
)