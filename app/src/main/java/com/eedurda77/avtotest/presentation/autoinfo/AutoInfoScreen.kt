package com.eedurda77.avtotest.presentation.autoinfo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.eedurda77.avtotest.R

@Composable
fun AutoInfoScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: AutoInfoViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()
    val info =
        "${state.value.auto?.engine} ${state.value.auto?.transmissionName} ${state.value.auto?.year}"
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = modifier.clickable {
                    navController.popBackStack()
                },
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_back_24),
                contentDescription = "back"
            )
            Text(
                modifier = modifier,
                text = state.value.auto?.name ?: "",
                fontSize = 30.sp
            )
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            verticalAlignment = Alignment.Top
        ) {
            AsyncImage(
                modifier = modifier
                    .size(100.dp)
                    .clip(shape = RoundedCornerShape(10.dp)),
                model = state.value.auto?.pathImage,
                contentDescription = state.value.auto?.name ?: ""
            )
            Column(
                modifier = modifier
                    .padding(start = 5.dp)
            ) {
                Text(
                    modifier = modifier,
                    text = state.value.auto?.brandName ?: "",
                    fontSize = 20.sp
                )
                Text(
                    modifier = modifier.padding(top = 5.dp),
                    text = info,
                    fontSize = 14.sp
                )
                Row(
                    modifier = modifier
                        .padding(top = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        modifier = modifier
                            .size(40.dp)
                            .clip(shape = CircleShape),
                        model = state.value.auto?.pathAvatar,
                        contentDescription = state.value.auto?.userName ?: ""
                    )
                    Text(
                        modifier = modifier.padding(start = 5.dp),
                        text = state.value.auto?.userName ?: "",
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}