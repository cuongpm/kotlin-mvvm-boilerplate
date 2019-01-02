package com.kotlin.mvvm.boilerplate.ui.component.binding

import android.databinding.BindingAdapter
import android.support.v7.widget.Toolbar
import android.view.View

/**
 * Created by cuongpm on 1/1/19.
 */

object ToolbarBinding {

    @BindingAdapter("app:navigationOnClickListener")
    @JvmStatic
    fun Toolbar.setNavigationOnClickListener(onClickListener: View.OnClickListener) {
        setNavigationOnClickListener(onClickListener)
    }
}