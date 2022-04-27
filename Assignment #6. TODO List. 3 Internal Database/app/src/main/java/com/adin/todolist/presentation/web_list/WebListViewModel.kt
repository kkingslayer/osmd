package com.adin.todolist.presentation.web_list

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.adin.todolist.application.App
import com.adin.todolist.data.network.models.Mount
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WebListViewModel : AndroidViewModel(App.instance) {
    private val _mountList = MutableLiveData<List<Mount>?>(null)
    val mountList: LiveData<List<Mount>?>
        get() = _mountList
    val isLoading = MutableLiveData(true)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val list = App.repository.fetchMounts()
            list?.let {
                _mountList.postValue(it)
            }
            isLoading.postValue(false)
        }
    }
}