package com.eedurda77.avtotest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.eedurda77.avtotest.presentation.autolist.AutoListScreen
import com.eedurda77.avtotest.ui.theme.AvtoTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AvtoTestTheme {
                AutoListScreen()
            }
        }
    }
}