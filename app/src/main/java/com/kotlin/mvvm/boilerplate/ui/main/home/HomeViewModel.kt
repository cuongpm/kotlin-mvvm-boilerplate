package com.kotlin.mvvm.boilerplate.ui.main.home

import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableList
import com.kotlin.mvvm.boilerplate.data.local.room.NewsEntity
import com.kotlin.mvvm.boilerplate.data.repository.NewsRepository
import com.kotlin.mvvm.boilerplate.ui.main.base.BaseViewModel
import com.kotlin.mvvm.boilerplate.util.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by cuongpm on 11/29/18.
 */

class HomeViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : BaseViewModel() {

    val isRefreshing = ObservableBoolean(false)
    val items: ObservableList<NewsEntity> = ObservableArrayList()
    val onNewsOpenEvent = SingleLiveEvent<NewsEntity>()

    private var disposable: Disposable? = null

    override fun start() {
        getAllNews(false)
    }

    override fun stop() {
        disposable?.let { if (!it.isDisposed) it.dispose() }
    }

    fun refreshNews() {
        getAllNews(true)
    }

    fun openNews(news: NewsEntity) {
        onNewsOpenEvent.value = news
    }

    private fun getAllNews(isRefresh: Boolean) {
        if (isRefresh) newsRepository.refreshNews()

        disposable = newsRepository.getAllNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { isRefreshing.set(true) }
            .doAfterTerminate { isRefreshing.set(false) }
            .subscribe({ news ->
                with(items) {
                    clear()
                    addAll(news)
                }
            }, { error ->
                error.printStackTrace()
            })
    }
}