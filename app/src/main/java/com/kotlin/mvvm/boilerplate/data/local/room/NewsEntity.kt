package com.kotlin.mvvm.boilerplate.data.local.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by cuongpm on 12/1/18.
 */

@Entity(tableName = "News")
data class NewsEntity constructor(
    @PrimaryKey
    @ColumnInfo(name = "idDefault")
    var idDefault: String = UUID.randomUUID().toString(),
    @SerializedName("id")
    @Expose
    var id: Int = 0,
    @SerializedName("by")
    @Expose
    var by: String = "",
    @SerializedName("title")
    @Expose
    var title: String = "",
    @SerializedName("url")
    @Expose
    var url: String = "",
    @SerializedName("score")
    @Expose
    var score: Int = 0,
    @SerializedName("time")
    @Expose
    var time: Long = 0,
    @SerializedName("kids")
    @Expose
    @Ignore
    var commentIds: List<Int> = emptyList()
)