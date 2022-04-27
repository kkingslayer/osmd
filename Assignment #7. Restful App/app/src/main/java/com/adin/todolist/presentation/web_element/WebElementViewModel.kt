package com.adin.todolist.presentation.web_element

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.adin.todolist.application.App
import com.adin.todolist.data.network.models.Mount
import kotlinx.coroutines.launch
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem


class WebElementViewModel(id: Long) : AndroidViewModel(App.instance) {
    private val _character = MutableLiveData<Mount?>(null)
    val character: LiveData<Mount?>
        get() = _character
    val isLoading = MutableLiveData(true)
    val isPlaying = MutableLiveData(false)
    val player: ExoPlayer = ExoPlayer.Builder(App.context).build()
//        get() = App.player

    fun onPlayClicked() {
        if (player.isPlaying) {
            player.pause()
            isPlaying.value = false
        } else {
            player.play()
            isPlaying.value = true
        }
    }


    fun onBackStack() {
        player.release()
        player.pause()
        player.clearMediaItems()
        player.stop()
    }

    init {
        viewModelScope.launch {
            val mount = App.repository.fetchMount(id)
            _character.postValue(mount)
            mount?.bgm?.let {
                val mediaItem: MediaItem = MediaItem.fromUri(it)
                player.setMediaItem(mediaItem)
                player.prepare()
            }
            isLoading.postValue(false)
        }
    }

}