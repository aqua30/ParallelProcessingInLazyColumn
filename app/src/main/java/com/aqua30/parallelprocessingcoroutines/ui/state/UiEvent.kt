package com.aqua30.parallelprocessingcoroutines.ui.state

import com.aqua30.parallelprocessingcoroutines.ui.model.AppItem

/**
 * Created by Saurabh
 */
sealed class UiEvent {
    data class ItemClick(val item: AppItem): UiEvent()
}
