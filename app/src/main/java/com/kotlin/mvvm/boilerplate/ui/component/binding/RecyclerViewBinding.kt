package com.kotlin.mvvm.boilerplate.ui.component.binding

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.kotlin.mvvm.boilerplate.data.local.room.NewsEntity
import com.kotlin.mvvm.boilerplate.ui.component.adapter.NewsAdapter

/**
 * Created by cuongpm on 12/13/18.
 */

object RecyclerViewBinding {

    @BindingAdapter("app:items")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, items: List<NewsEntity>) {
        with(recyclerView.adapter as NewsAdapter?) {
            this?.setData(items)
        }
    }
}