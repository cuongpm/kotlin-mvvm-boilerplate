package com.kotlin.mvvm.boilerplate.ui.component.binding

import android.databinding.BindingAdapter
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.DividerItemDecoration.HORIZONTAL
import android.support.v7.widget.DividerItemDecoration.VERTICAL
import android.support.v7.widget.RecyclerView
import com.kotlin.mvvm.boilerplate.data.local.room.CommentEntity
import com.kotlin.mvvm.boilerplate.data.local.room.NewsEntity
import com.kotlin.mvvm.boilerplate.ui.component.adapter.CommentAdapter
import com.kotlin.mvvm.boilerplate.ui.component.adapter.NewsAdapter

/**
 * Created by cuongpm on 12/13/18.
 */

object RecyclerViewBinding {

    @BindingAdapter("app:addVerticalItemDecoration")
    @JvmStatic
    fun RecyclerView.addVerticalItemDecoration(isVertical: Boolean) {
        addItemDecoration(DividerItemDecoration(context, if (isVertical) VERTICAL else HORIZONTAL))
    }

    @BindingAdapter("app:items")
    @JvmStatic
    fun setListNews(recyclerView: RecyclerView, items: List<NewsEntity>) {
        with(recyclerView.adapter as NewsAdapter?) {
            this?.setData(items)
        }
    }

    @BindingAdapter("app:items")
    @JvmStatic
    fun setListComments(recyclerView: RecyclerView, items: List<CommentEntity>) {
        with(recyclerView.adapter as CommentAdapter?) {
            this?.setData(items)
        }
    }
}