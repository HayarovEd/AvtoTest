package com.eedurda77.avtotest.presentation.autoinfo

import com.eedurda77.avtotest.data.remote.dto.post.Post
import com.eedurda77.avtotest.domain.model.AutoInfo

data class AutoInfoState(
    val isLoading: Boolean = false,
    val auto: AutoInfo? = null,
    val items: List<Post> = emptyList(),
    val error: String? = null,
    val endReached: Boolean = false,
    val page: Int = 1
)
