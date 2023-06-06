package com.eedurda77.avtotest.presentation.autolist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.eedurda77.avtotest.domain.model.Auto

@Composable
fun ItemAuto(
    modifier: Modifier = Modifier,
    auto: Auto
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {

            }
    ) {
        AsyncImage(
            modifier = modifier.fillMaxWidth(),
            model = auto.imagePath,
            contentDescription = auto.name
        )
        Text(
            modifier = modifier
                .padding(start = 10.dp, top = 10.dp),
            text = auto.name,
            fontSize = 22.sp
        )
    }
}