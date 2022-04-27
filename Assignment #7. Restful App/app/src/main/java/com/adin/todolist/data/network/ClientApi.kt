package com.adin.todolist.data.network

import com.adin.todolist.data.network.models.FFXIVMounts
import com.adin.todolist.data.network.models.Mount
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class ClientApi {
    private fun okHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .build()


    private fun retrofit(): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient())
            .baseUrl("https://ffxivcollect.com/api/")
            .build()

    private var api = retrofit().create(FFXIVMountsApi::class.java)


    suspend fun fetchMounts(): FFXIVMounts? = safeCall(api?.fetchMounts())
    suspend fun fetchMount(id: Long): Mount? = safeCall(api?.fetchMount(id))


    private suspend inline fun <T> safeCall(call: Call<T>?): T? {
        val req = call?.awaitResponse() ?: return null
        return when {
            req.isSuccessful -> req.body()
            else -> null
        }
    }
}


suspend inline fun <reified T> catching(crossinline block: suspend () -> T) = try {
    block()
} catch (e: java.lang.Exception) {
    e.printStackTrace()
    null
}

