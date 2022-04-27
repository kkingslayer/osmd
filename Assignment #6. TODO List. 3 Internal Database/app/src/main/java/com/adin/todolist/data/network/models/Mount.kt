package com.adin.todolist.data.network.models

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Mount(
    val bgm: String?,
    val description: String,
    val enhanced_description: String,
    val icon: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val image: String,
    val movement: String,
    val name: String,
    val patch: String,
    val seats: Int,
    val tooltip: String
){
    companion object{
        const val TABLE_NAME = "mount"
    }
}