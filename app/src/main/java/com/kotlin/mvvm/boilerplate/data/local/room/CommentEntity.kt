package com.kotlin.mvvm.boilerplate.data.local.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by cuongpm on 12/12/18.
 */

@Entity(tableName = "Comment")
data class CommentEntity constructor(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    var id: Int,

    @ColumnInfo(name = "by")
    @SerializedName("by")
    @Expose
    var by: String,

    @ColumnInfo(name = "text")
    @SerializedName("text")
    @Expose
    var text: String,

    @ColumnInfo(name = "parent")
    @SerializedName("parent")
    @Expose
    var parent: Int,

    @ColumnInfo(name = "time")
    @SerializedName("time")
    @Expose
    var time: Long
)