package com.example.testandroidx.testRoom

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Single

@Dao
interface UserDao {

    @Query("select * from userentity where userId = :id")
    fun getOne(id :String) : Single<UserEntity>

    @Query("select * from userentity")
    fun getAll() : List<UserEntity>

    @Insert
    fun insertAll(user : UserEntity)

    @Delete
    fun delete(User : UserEntity)
}
