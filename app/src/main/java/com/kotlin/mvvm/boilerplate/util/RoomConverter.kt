package com.kotlin.mvvm.boilerplate.util

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by cuongpm on 1/4/19.
 */

class RoomConverter {

    @TypeConverter
    fun convertStringToList(data: String?): List<Int> {
        data?.let {
            val listType = object : TypeToken<List<Int>>() {}.type
            return Gson().fromJson(it, listType)
        }

        return emptyList()
    }

    @TypeConverter
    fun convertListToString(objects: List<Int>): String {
        return Gson().toJson(objects)
    }
}