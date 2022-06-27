package com.aqua30.parallelprocessingcoroutines.ui.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aqua30.parallelprocessingcoroutines.ui.model.AppItem
import com.aqua30.parallelprocessingcoroutines.ui.model.TaskStatus

/**
 * Created by Saurabh
 */
@Composable
fun ListItem(
    item: AppItem,
    background: Color,
    onItemClick: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(background)
            .clickable {
                onItemClick(item.id)
            },
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.weight(1f).padding(horizontal = 16.dp),
            text = item.text,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
        Box(
            modifier = Modifier.size(60.dp),
            contentAlignment = Alignment.Center
        ) {
            /** show indicator only for loading state */
            if (item.taskStatus == TaskStatus.IN_PROGRESS)
                CircularProgressIndicator(
                    modifier = Modifier.size(30.dp),
                    strokeWidth = 3.dp,
                    color = Color.Magenta,
                )
            else
                Icon(
                    if (item.taskStatus == TaskStatus.NOT_STARTED)
                        Icons.Default.PlayArrow
                    else Icons.Default.Check,
                    "action icon",
                    tint = if (item.taskStatus == TaskStatus.NOT_STARTED)
                        Color.Gray
                    else
                        Color.Blue,
                )
        }
    }
}