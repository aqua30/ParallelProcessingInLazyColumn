package com.aqua30.parallelprocessingcoroutines.ui.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aqua30.parallelprocessingcoroutines.ui.state.UiEvent

/**
 * Created by Saurabh
 */
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel()
) {

    val state = viewModel.itemsState

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top
    ) {
        items(
            items = state,
            key = {
                it.id
            }
        ) { item ->
            ListItem(
                item = item,
                background = if (item.id % 2 == 0) Color.LightGray else Color.White,
                onItemClick = {
                    viewModel.uiEvent(UiEvent.ItemClick(item))
                }
            )
        }
    }
}