package com.kotlin.mvvm.boilerplate.data.local.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.kotlin.mvvm.boilerplate.util.getRelativeTime

/**
 * Created by cuongpm on 12/1/18.
 */

@Entity(tableName = "News")
data class NewsEntity constructor(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    var id: Int = 0,

    @ColumnInfo(name = "by")
    @SerializedName("by")
    @Expose
    var by: String = "",

    @ColumnInfo(name = "title")
    @SerializedName("title")
    @Expose
    var title: String = "",

    @ColumnInfo(name = "url")
    @SerializedName("url")
    @Expose
    var url: String = "",

    @ColumnInfo(name = "score")
    @SerializedName("score")
    @Expose
    var score: Int = 0,

    @ColumnInfo(name = "time")
    @SerializedName("time")
    @Expose
    var time: Long = 0,

    @SerializedName("kids")
    @Expose
    @Ignore
    var commentIds: List<Int> = emptyList()
) {

    var authorAndPoints = ""
        get() = "$score points by $by"

    var timeAndComment = ""
        get() = "${getRelativeTime(time)}  |  ${commentIds.size} comments"

}