package com.adin.todolist.presentation.web_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.adin.astralearner.utils.Dimens
import com.adin.astralearner.utils.TextSizes
import com.adin.todolist.presentation.components.Colors
import com.adin.todolist.presentation.components.DashedCard
import com.adin.todolist.presentation.components.RowElement
import com.adin.todolist.presentation.main.AppScreen

@Composable
fun WebListScreen(
    navController: NavController,
    viewModel: WebListViewModel = WebListViewModel()
) {
    val _mounts by viewModel.mountList.observeAsState()
    val isLoading by viewModel.isLoading.observeAsState(true)
    Scaffold(
        backgroundColor = Colors.colorPrimaryDark,
        topBar = {
            TopAppBar(backgroundColor = Colors.colorPrimaryDark) {
                Text(
                    text = "FFXIVMountApi",
                    fontSize = TextSizes.M,
                    color = Colors.colorOnPrimary
                )
            }
        }) {
        it
        if (isLoading)
            return@Scaffold Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = Colors.colorSecondary)
            }
        _mounts?.let { mount ->
            LazyColumn() {
                items(mount) { mount ->
                    DashedCard(
                        modifier = Modifier.clickable { navController.navigate(AppScreen.WebElementScreen.route + "?id=${mount.id}") },
                        title = {
                            Text(
                                text = mount.name,
                                modifier = Modifier.padding(
                                    horizontal = Dimens.XS,
                                    vertical = Dimens.S
                                ),
                                fontSize = TextSizes.M,
                                color = Colors.colorOnPrimary
                            )
                        }) {
                        RowElement("Пол", mount.name)
                        RowElement("Передвижение", mount.movement)
                        RowElement("Сиденья", mount.seats.toString())
                        RowElement("Патч", mount.patch)
                    }
                }

            }
        }

    }
}