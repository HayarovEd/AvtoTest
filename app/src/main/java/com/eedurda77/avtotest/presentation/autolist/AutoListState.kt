package com.eedurda77.avtotest.presentation.autolist

import com.eedurda77.avtotest.domain.model.Auto

data class AutoListState(
    val isLoading: Boolean = false,
    val items: List<Auto> = emptyList(),
    val error: String? = null,
    val endReached: Boolean = false,
    val page: Int = 1
)
