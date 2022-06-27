package com.aqua30.parallelprocessingcoroutines.ui.presentation

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aqua30.parallelprocessingcoroutines.ui.model.AppItem
import com.aqua30.parallelprocessingcoroutines.ui.model.TaskStatus
import com.aqua30.parallelprocessingcoroutines.ui.state.UiEvent
import kotlinx.coroutines.*
import kotlin.random.Random

/**
 * Created by Saurabh
 */
class HomeViewModel: ViewModel() {

    private val itemList = (0..20).map { i ->
        AppItem(
            id = i,
            text = "Item ${i+1}"
        )
    }

    private val _itemsState = mutableStateListOf<AppItem>()
    val itemsState: List<AppItem> = _itemsState

    init {
        _itemsState.addAll(itemList)
    }

    fun uiEvent(event: UiEvent) {
        when(event) {
            is UiEvent.ItemClick -> {
                val item = event.item
                if (item.taskStatus == TaskStatus.NOT_STARTED) {
                    _itemsState[item.id] = itemsState[item.id].copy(
                        taskStatus = TaskStatus.IN_PROGRESS
                    )
                    processTask(item.id)
                }
            }
        }
    }

    private fun processTask(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                Log.e("Tag","thread = ${Thread.currentThread().name}")
                backgroundTask(id)
            } finally {
                Log.e("Tag","cancelled $id")
            }
        }
    }

    private suspend fun backgroundTask(id: Int) {
        val delay = id + Random.nextInt(5)
        Log.e("Tag","delay for id $id is $delay")
        delay(delay * 1000L)
        _itemsState[id] = itemsState[id].copy(
            taskStatus = TaskStatus.COMPLETED
        )
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}