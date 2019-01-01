package com.kotlin.mvvm.boilerplate.util.ext

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

/**
 * Created by cuongpm on 11/29/18.
 */

inline fun AppCompatActivity.addFragment(containerViewId: Int, f: () -> Fragment): Fragment? {
    return f().apply { supportFragmentManager?.beginTransaction()?.add(containerViewId, this)?.commit() }
}

inline fun AppCompatActivity.addFragment(containerViewId: Int, bundle: Bundle, f: () -> Fragment): Fragment? {
    return f().apply {
        arguments = bundle
        supportFragmentManager?.beginTransaction()?.add(containerViewId, this)?.commit()
    }
}

inline fun AppCompatActivity.replaceFragment(containerViewId: Int, f: () -> Fragment): Fragment? {
    return f().apply { supportFragmentManager?.beginTransaction()?.replace(containerViewId, this)?.commit() }
}