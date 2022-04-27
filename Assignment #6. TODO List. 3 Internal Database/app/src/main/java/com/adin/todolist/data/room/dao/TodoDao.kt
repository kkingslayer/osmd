package com.adin.todolist.data.room.dao

import androidx.room.*
import com.adin.todolist.data.network.models.Mount
import com.adin.todolist.data.room.entities.TodoEntity

@Dao
interface TodoDao {

    @Query("SELECT * FROM ${TodoEntity.TABLE_NAME}")
    suspend fun selectAllTodos(): List<TodoEntity>

    @Insert
    suspend fun insertTodo(todo: TodoEntity)

    @Insert
    suspend fun insertTodos(todo: List<TodoEntity>)

    @Delete
    suspend fun deleteTodo(todo: TodoEntity)

    @Update
    suspend fun updateTodo(todo: TodoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMount(characters: List<Mount>)

    @Query("SELECT * FROM ${Mount.TABLE_NAME} WHERE id like :id")
    suspend fun getMount(id: Long): Mount

    @Query("SELECT * FROM ${Mount.TABLE_NAME}")
    suspend fun getMounts(): List<Mount>
}