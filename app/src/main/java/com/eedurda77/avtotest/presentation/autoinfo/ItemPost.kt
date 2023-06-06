package com.eedurda77.avtotest.presentation.autoinfo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.eedurda77.avtotest.R
import com.eedurda77.avtotest.domain.model.PostAuto

@Composable
fun ItemPost(
    modifier: Modifier = Modifier,
    post: PostAuto
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        AsyncImage(
            modifier = modifier
                .fillMaxWidth(),
            model = post.pathPost,
            contentDescription = post.id.toString()
        )
        Spacer(
            modifier = modifier
                .height(10.dp)
        )
        Text(
            modifier = modifier
                .padding(start = 10.dp),
            text = post.datePost,
            fontSize = 16.sp
        )
        Spacer(
            modifier = modifier
                .height(10.dp)
        )
        Text(
            modifier = modifier
                .padding(horizontal = 10.dp),
            text = post.content,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            fontSize = 16.sp
        )
        Spacer(
            modifier = modifier
                .height(10.dp)
        )
        Row(
            modifier = modifier
                .padding(start = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = modifier,
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_favorite),
                contentDescription = "like")
            Text(
                modifier = modifier
                    .padding(start = 5.dp),
                text = post.likeCount.toString(),
                fontSize = 16.sp
            )
            Icon(
                modifier = modifier
                    .padding(start = 10.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_notes),
                contentDescription = "commit")
            Text(
                modifier = modifier
                    .padding(start = 5.dp),
                text = post.commentCount.toString(),
                fontSize = 16.sp
            )
        }
    }
}