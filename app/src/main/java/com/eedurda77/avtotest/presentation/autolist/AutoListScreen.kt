package com.eedurda77.avtotest.presentation.autolist


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun AutoListScreen(
    modifier: Modifier = Modifier,
    viewModel: AutoListViewModel = hiltViewModel()
) {
    val state = viewModel.state
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(state.value.items.size) { number ->
            val auto = state.value.items[number]
            if (number >= state.value.items.size - 1 && !state.value.endReached && !state.value.isLoading) {
                viewModel.loadNextItems()
            }
            ItemAuto(
                auto = auto
            )
        }
        item {
            if (state.value.isLoading) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}