package com.adin.todolist.data.network

import com.adin.todolist.data.network.models.FFXIVMounts
import com.adin.todolist.data.network.models.Mount
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FFXIVMountsApi {
    @GET("mounts")
    fun fetchMounts(): Call<FFXIVMounts>

    @GET("mounts/{id}")
    fun fetchMount(@Path("id") id: Long): Call<Mount>
}