package com.kotlin.mvvm.boilerplate.ui.main.home

import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import com.kotlin.mvvm.boilerplate.data.local.room.NewsEntity
import com.kotlin.mvvm.boilerplate.data.repository.NewsRepository
import com.kotlin.mvvm.boilerplate.ui.main.base.BaseViewModel
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

    val items: ObservableList<NewsEntity> = ObservableArrayList()

    private var disposable: Disposable? = null

    override fun start() {
        getAllNews()
    }

    override fun stop() {
        disposable?.let { if (!it.isDisposed) it.dispose() }
    }

    private fun getAllNews() {
        disposable = newsRepository.getAllNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
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