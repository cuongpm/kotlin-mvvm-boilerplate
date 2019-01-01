package com.kotlin.mvvm.boilerplate.ui.component.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kotlin.mvvm.boilerplate.R
import com.kotlin.mvvm.boilerplate.data.local.room.NewsEntity
import com.kotlin.mvvm.boilerplate.databinding.ItemNewsBinding
import com.kotlin.mvvm.boilerplate.ui.main.home.HomeViewModel

/**
 * Created by cuongpm on 12/10/18.
 */

class NewsAdapter(
    private var news: List<NewsEntity>,
    private val homeViewModel: HomeViewModel?
) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = DataBindingUtil.inflate<ItemNewsBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_news, parent, false
        )

        return NewsViewHolder(binding)
    }

    override fun getItemCount() = news.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) =
        holder.bind(news[position], object : NewsListener {
            override fun onNewsSelected(news: NewsEntity) {
                homeViewModel?.openNews(news)
            }
        })

    class NewsViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(newsEntity: NewsEntity, newsListener: NewsListener) {
            with(binding)
            {
                news = newsEntity
                listener = newsListener
                executePendingBindings()
            }
        }
    }

    fun setData(news: List<NewsEntity>) {
        this.news = news
        notifyDataSetChanged()
    }
}

interface NewsListener {
    fun onNewsSelected(news: NewsEntity)
}
