package com.eedurda77.avtotest.presentation.autolist


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun AutoListScreen(
    modifier: Modifier = Modifier,
    viewModel: AutoListViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val state = viewModel.state.collectAsState()
    LazyColumn(modifier = modifier.fillMaxSize()) {
        if (state.value.error!=null) {
            item{
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = modifier,
                        text = state.value.error?:"Unknown error",
                        fontSize = 16.sp
                    )
                }
            }
        }
        items(state.value.items.size) { number ->
            val auto = state.value.items[number]
            if (number >= state.value.items.size - 1 && !state.value.endReached && !state.value.isLoading) {
                viewModel.loadNextItems()
            }
            ItemAuto(
                navController = navController,
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