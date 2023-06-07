package com.eedurda77.avtotest.presentation.autolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eedurda77.avtotest.data.paginator.PaginatorDefault
import com.eedurda77.avtotest.domain.repository.RepositoryAuto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AutoListViewModel @Inject constructor(
    private val repositoryAuto: RepositoryAuto
): ViewModel() {
    private var _state = MutableStateFlow(AutoListState())
    val state = _state.asStateFlow()

    private val paginator = PaginatorDefault(
        initialKey = _state.value.page,
        onLoadUpdated = {
            _state.value = _state.value.copy(isLoading = it)
        },
        onRequest = { nextPage ->
            repositoryAuto.getAutos(
                page = nextPage,
                pageSize = 10
            )
        },
        getNextKey = {
            _state.value.page + 1
        },
        onError = {
            _state.value = _state.value.copy(error = it)
        },
        onSuccess = { items, newKey ->
            _state.value = _state.value.copy(
                items = _state.value.items + items,
                page = newKey,
                endReached = items.isEmpty()
            )
        }
    )

    init {
        loadNextItems()
    }

    fun loadNextItems() {
        viewModelScope.launch {
            paginator.loadNextItems()
        }
    }
}