package com.kotlin.mvvm.boilerplate.ui.main.comment

import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableList
import com.kotlin.mvvm.boilerplate.data.local.room.CommentEntity
import com.kotlin.mvvm.boilerplate.data.local.room.NewsEntity
import com.kotlin.mvvm.boilerplate.data.repository.NewsRepository
import com.kotlin.mvvm.boilerplate.ui.main.base.BaseViewModel
import com.kotlin.mvvm.boilerplate.util.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by cuongpm on 12/31/18.
 */

class CommentViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : BaseViewModel() {

    var newsEntity: NewsEntity? = null

    val isRefreshing = ObservableBoolean(false)
    val title = ObservableField("")
    val items: ObservableList<CommentEntity> = ObservableArrayList()
    val onBackPressedEvent = SingleLiveEvent<Void>()

    private var disposable: Disposable? = null

    override fun start() {
        getAllComments()
    }

    override fun stop() {
        disposable?.let { if (!it.isDisposed) it.dispose() }
    }

    fun refreshComments() {
        getAllComments()
    }


    fun pressNavigationIcon() {
        onBackPressedEvent.call()
    }

    fun showNewsInfo() {
        newsEntity?.let {
            title.set(it.title)
        }
    }

    fun getAllComments() {
        newsEntity?.let {
            disposable = newsRepository.getAllComments(it.id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { isRefreshing.set(true) }
                .doAfterTerminate { isRefreshing.set(false) }
                .subscribe({ comments ->
                    with(items) {
                        clear()
                        addAll(comments)
                    }
                }, { error ->
                    error.printStackTrace()
                })
        }
    }
}