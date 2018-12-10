package com.kotlin.mvvm.boilerplate.ui.main.home

import android.content.Context
import android.databinding.ObservableField
import com.kotlin.mvvm.boilerplate.data.local.room.NewsEntity
import com.kotlin.mvvm.boilerplate.data.repository.NewsRepository
import com.kotlin.mvvm.boilerplate.di.qualifier.ApplicationContext
import com.kotlin.mvvm.boilerplate.ui.main.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by cuongpm on 11/29/18.
 */

class HomeViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val newsRepository: NewsRepository
) : BaseViewModel() {

    companion object {
        private const val name = "Cuong Pham"
        private const val avatar = "https://avatars3.githubusercontent.com/u/2792438"
    }

    val userName = ObservableField<String>()
    val userAvatar = ObservableField<String>()

    override fun start() {
        getAllNews()
    }

    private fun getAllNews() {
        val news = NewsEntity(id = "id", title = name, content = avatar)

        // update UI
        userName.set(news.title)
        userAvatar.set(news.content)
    }
}