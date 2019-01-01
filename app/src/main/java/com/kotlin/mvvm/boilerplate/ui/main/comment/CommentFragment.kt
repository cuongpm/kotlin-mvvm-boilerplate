package com.kotlin.mvvm.boilerplate.ui.main.comment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.kotlin.mvvm.boilerplate.data.local.room.NewsEntity
import com.kotlin.mvvm.boilerplate.databinding.FragmentCommentBinding
import com.kotlin.mvvm.boilerplate.di.ActivityScoped
import com.kotlin.mvvm.boilerplate.ui.component.adapter.CommentAdapter
import com.kotlin.mvvm.boilerplate.ui.main.base.BaseFragment
import javax.inject.Inject

/**
 * Created by cuongpm on 12/31/18.
 */

@ActivityScoped
class CommentFragment @Inject constructor() : BaseFragment() {

    companion object {
        const val NEWS_DATA = "news_data"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var commentViewModel: CommentViewModel

    private lateinit var dataBinding: FragmentCommentBinding

    private lateinit var commentAdapter: CommentAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        commentViewModel = ViewModelProviders.of(this, viewModelFactory).get(CommentViewModel::class.java)
        commentAdapter = CommentAdapter(ArrayList(0))

        dataBinding = FragmentCommentBinding.inflate(inflater, container, false).apply {
            this.viewModel = commentViewModel
            this.adapter = commentAdapter
        }

        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        commentViewModel.newsEntity = arguments?.getString(NEWS_DATA)?.let {
            Gson().fromJson(it, NewsEntity::class.java)
        }

        commentViewModel.start()
        commentViewModel.showNewsInfo()
        handleUIEvent()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        commentViewModel.stop()
    }

    private fun handleUIEvent() {
        commentViewModel.onBackPressedEvent.observe(this, Observer { activity?.finish() })
    }
}