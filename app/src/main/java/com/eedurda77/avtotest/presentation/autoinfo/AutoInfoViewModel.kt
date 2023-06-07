package com.eedurda77.avtotest.presentation.autoinfo

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eedurda77.avtotest.data.paginator.PaginatorDefault
import com.eedurda77.avtotest.domain.repository.RepositoryAuto
import com.eedurda77.avtotest.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class AutoInfoViewModel @Inject constructor(
    private val repositoryAuto: RepositoryAuto,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private var _state = MutableStateFlow(AutoInfoState())
    val state = _state.asStateFlow()

    val id = savedStateHandle.get<String>("id") ?: "0"
    val paginator = PaginatorDefault(
        initialKey = _state.value.page,
        onLoadUpdated = {
            _state.value = _state.value.copy(isLoading = it)
        },
        onRequest = { nextPage ->
            repositoryAuto.getPostByAuto(
                autoId = id.toInt(),
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
        getRemoteData()
        loadNextItems()
    }

    private fun getRemoteData() {
        viewModelScope.launch {
            when (val result = repositoryAuto.getAutoInfoById(id = id.toInt())) {
                is Resource.Error -> {
                    _state.update { currentState ->
                        currentState.copy(
                            error = result.message
                        )
                    }
                }

                is Resource.Success -> {
                    _state.update { currentState ->
                        currentState.copy(
                            auto = result.data
                        )
                    }
                }
            }
        }
    }


    fun loadNextItems() {
        viewModelScope.launch {
            paginator.loadNextItems()
        }
    }

}