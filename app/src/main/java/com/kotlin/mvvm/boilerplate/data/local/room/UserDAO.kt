package com.kotlin.mvvm.boilerplate.data.local.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

/**
 * Created by cuongpm on 12/1/18.
 */

@Dao
interface UserDAO {

    /**
     * Select all users from User table
     *
     * @return all users
     */
    @Query("SELECT * FROM user")
    fun getAllUsers(): List<UserEntity>

    /**
     * Insert a user in the database. If the user already exists, replace it
     *
     * @param task the task to be inserted
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserEntity)

}