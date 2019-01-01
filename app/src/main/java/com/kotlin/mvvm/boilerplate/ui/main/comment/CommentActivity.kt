package com.kotlin.mvvm.boilerplate.ui.main.comment

import android.os.Bundle
import com.kotlin.mvvm.boilerplate.R
import com.kotlin.mvvm.boilerplate.ui.main.base.BaseActivity
import com.kotlin.mvvm.boilerplate.util.ext.addFragment

/**
 * Created by cuongpm on 12/31/18.
 */

class CommentActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        addFragment(R.id.content_frame, intent.extras, ::CommentFragment)
    }

}