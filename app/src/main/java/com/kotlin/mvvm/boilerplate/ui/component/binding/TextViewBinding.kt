package com.kotlin.mvvm.boilerplate.ui.component.binding

import android.databinding.BindingAdapter
import android.text.Html
import android.widget.TextView

/**
 * Created by cuongpm on 1/2/19.
 */

object TextViewBinding {

    @BindingAdapter("app:textHtml")
    @JvmStatic
    fun TextView.textHtml(text: String?) {
        text?.let { setText(Html.fromHtml(it)) }
    }
}