package com.kotlin.mvvm.boilerplate.ui.component.binding

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kotlin.mvvm.boilerplate.R

/**
 * Created by cuongpm on 12/1/18.
 */

object ImageBinding {

    @BindingAdapter("app:imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String?) {
        Glide.with(imageView.context).load(url).apply(
            RequestOptions().circleCrop().placeholder(R.drawable.ic_launcher_background)
        ).into(imageView)
    }
}