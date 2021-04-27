package com.example.testandroidx.testRoom

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
     var userId : Int = 0
    ,var name: String = ""
    ,var address: String = ""
)
