package com.kotlin.mvvm.boilerplate.util

import android.text.format.DateUtils

/**
 * Created by cuongpm on 1/2/19.
 */

fun getRelativeTime(time: Long): String {
    return DateUtils.getRelativeTimeSpanString(
        time * 1000,
        System.currentTimeMillis(),
        DateUtils.DAY_IN_MILLIS,
        DateUtils.FORMAT_ABBREV_ALL
    ).toString()
}