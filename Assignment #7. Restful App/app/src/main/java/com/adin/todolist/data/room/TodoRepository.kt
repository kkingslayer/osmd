package com.adin.todolist.data.room

import com.adin.todolist.data.network.models.Mount
import com.adin.todolist.data.room.dao.TodoDao
import com.adin.todolist.data.room.entities.TodoEntity

class TodoRepository(private val dictionaryDao: TodoDao) {

    suspend fun selectAllTodos(): List<TodoEntity> = dictionaryDao.selectAllTodos()

    suspend fun insertTodo(todo: TodoEntity) = dictionaryDao.insertTodo(todo)

    suspend fun insertTodos(todo: List<TodoEntity>) = dictionaryDao.insertTodos(todo)

    suspend fun deleteTodo(todo: TodoEntity) = dictionaryDao.deleteTodo(todo)

    suspend fun updateTodo(todo: TodoEntity) = dictionaryDao.updateTodo(todo)

    suspend fun insertMount(mount: List<Mount>) =
        dictionaryDao.insertMount(mount)

    suspend fun getMount(id: Long) = dictionaryDao.getMount(id)

    suspend fun getMounts(): List<Mount> = dictionaryDao.getMounts()
}