package com.kotlin.mvvm.boilerplate.data.local.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by cuongpm on 12/1/18.
 */

@Entity(tableName = "News")
data class NewsEntity constructor(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "content")
    var content: String
)