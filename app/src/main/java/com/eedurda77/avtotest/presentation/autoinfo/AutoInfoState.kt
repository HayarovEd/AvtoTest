package com.eedurda77.avtotest.presentation.autoinfo

import com.eedurda77.avtotest.domain.model.AutoInfo
import com.eedurda77.avtotest.domain.model.PostAuto

data class AutoInfoState(
    val isLoading: Boolean = false,
    val auto: AutoInfo? = null,
    val items: List<PostAuto> = emptyList(),
    val error: String? = null,
    val endReached: Boolean = false,
    val page: Int = 1
)
