package com.adin.todolist.application

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.adin.todolist.data.network.Repository
import com.adin.todolist.data.room.TodoRepository
import com.adin.todolist.data.room.dao.DatabaseBuilder
import com.adin.todolist.data.room.dao.TodoDatabase
import com.google.android.exoplayer2.ExoPlayer


class App : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        lateinit var todoDatabase: TodoDatabase
        lateinit var todoRepository: TodoRepository
        lateinit var repository: Repository
        lateinit var instance: Application
        lateinit var player: ExoPlayer
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
        context = baseContext
        todoDatabase = DatabaseBuilder.build(context)
        todoRepository = TodoRepository(todoDatabase.dictionaryDao())
        repository = Repository()
        player = ExoPlayer.Builder(App.context).build()
    }

}