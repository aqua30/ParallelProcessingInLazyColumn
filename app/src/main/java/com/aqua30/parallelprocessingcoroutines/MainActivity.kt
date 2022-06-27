package com.aqua30.parallelprocessingcoroutines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.aqua30.parallelprocessingcoroutines.ui.presentation.HomeScreen
import com.aqua30.parallelprocessingcoroutines.ui.theme.ParallelProcessingCoroutinesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ParallelProcessingCoroutinesTheme {
                HomeScreen()
            }
        }
    }
}