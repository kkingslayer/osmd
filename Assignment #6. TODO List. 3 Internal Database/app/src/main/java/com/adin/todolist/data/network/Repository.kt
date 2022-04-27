package com.adin.todolist.data.network

import com.adin.todolist.application.App
import com.adin.todolist.data.network.models.Mount
import com.adin.todolist.data.room.TodoRepository

class Repository(
    private var api: ClientApi = ClientApi(),
    private var todoRepository: TodoRepository = App.todoRepository
) {


    suspend fun fetchMounts(): List<Mount>? = catching {
        val list: List<Mount>? = catching { api.fetchMounts()?.results }
        if (list != null)
            todoRepository.insertMount(list)
        if (list.isNullOrEmpty())
            return@catching todoRepository.getMounts()
        return@catching list
    }

    suspend fun fetchMount(id: Long): Mount? = catching {
        catching { api.fetchMount(id) } ?: todoRepository.getMount(id)
    }
}