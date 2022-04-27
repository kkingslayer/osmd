package com.adin.todolist.presentation.web_element

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.adin.astralearner.utils.TextSizes
import com.adin.todolist.presentation.components.Colors
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.filled.LocalPlay
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.adin.astralearner.utils.Dimens
import kotlin.system.exitProcess

@Composable
fun WebElementScreen(
    navController: NavController,
    id: Long,
    viewModel: WebElementViewModel = WebElementViewModel(id)
) {
    val _mount by viewModel.character.observeAsState()
    val isLoading by viewModel.isLoading.observeAsState(true)
    val isPlaying by viewModel.isPlaying.observeAsState()
    BackHandler() {
        viewModel.onBackStack()
        navController.navigateUp()
    }
    Scaffold(backgroundColor = Colors.colorPrimaryDark, topBar = {
        TopAppBar(backgroundColor = Colors.colorPrimaryDark, navigationIcon = {
            IconButton(onClick = {
                viewModel.onBackStack()
                navController.navigateUp()
            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Colors.colorOnPrimary
                )
            }
        }, title = {
            Text(
                text = _mount?.name ?: "Загрузка...",
                fontSize = TextSizes.M,
                color = Colors.colorOnPrimary
            )
        }, actions = {
            _mount?.bgm?.let {
                IconButton(onClick = { viewModel.onPlayClicked() }) {
                    Icon(
                        imageVector = if (isPlaying == true) Icons.Filled.Pause else Icons.Filled.PlayArrow,
                        contentDescription = "Play",
                        tint = Colors.colorOnPrimary
                    )
                }
            }
        })
    }) {
        it
        if (isLoading)
            return@Scaffold Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = Colors.colorSecondary)
            }
        _mount?.let { mount ->
            Column {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(Dimens.M),
                ) {
                    SubcomposeAsyncImage(
                        modifier = Modifier
                            .size(128.dp)
                            .clip(CircleShape),
                        model = mount.image,
                        loading = {
                            CircularProgressIndicator(
                                color = Colors.colorSecondary, modifier = Modifier
                                    .size(Dimens.SXL)
                            )
                        },
                        contentDescription = ""
                    )
                }

                TextItem(mount.description)
                TextItem(mount.tooltip)
            }

        }

    }

}

@Composable
fun TextItem(text: String) {
    Text(
        text = text,
        fontSize = TextSizes.M,
        color = Colors.colorOnPrimary
    )
}