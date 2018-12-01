package com.kotlin.mvvm.boilerplate.ui.main.home

import android.arch.lifecycle.ViewModel
import android.content.Context
import android.databinding.ObservableField
import com.kotlin.mvvm.boilerplate.data.local.room.UserEntity
import com.kotlin.mvvm.boilerplate.data.repository.UserRepository
import javax.inject.Inject

/**
 * Created by cuongpm on 11/29/18.
 */

class HomeViewModel @Inject constructor(
    private val context: Context,
    private val userRepository: UserRepository
) : ViewModel() {

    companion object {
        private const val name = "Cuong Pham"
        private const val avatar = "https://avatars3.githubusercontent.com/u/2792438"
    }

    val userName = ObservableField<String>()
    val userAvatar = ObservableField<String>()

    fun start() {
        getUserInfo()
    }

    fun getUserInfo() {
        val user = UserEntity(id = "id", name = name, avatar = avatar)

        // update UI
        userName.set(user.name)
        userAvatar.set(user.avatar)
    }
}