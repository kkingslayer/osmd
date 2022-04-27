package com.adin.todolist.data.room.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.adin.todolist.data.network.models.Mount
import com.adin.todolist.data.room.entities.TodoEntity

@Database(
    entities = [TodoEntity::class, Mount::class],
    version = 5,
    exportSchema = false
)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun dictionaryDao(): TodoDao

    companion object {
        const val DATABASE_NAME = "todo_room_database"
        const val NOT_EXIST_ID = 0L
    }
}

