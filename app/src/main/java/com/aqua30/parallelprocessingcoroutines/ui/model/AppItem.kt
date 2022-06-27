package com.aqua30.parallelprocessingcoroutines.ui.model

/**
 * Created by Saurabh
 */
data class AppItem(
    val id: Int,
    val text: String,
    val taskStatus: TaskStatus = TaskStatus.NOT_STARTED
)

enum class TaskStatus {
    NOT_STARTED,
    IN_PROGRESS,
    COMPLETED
}