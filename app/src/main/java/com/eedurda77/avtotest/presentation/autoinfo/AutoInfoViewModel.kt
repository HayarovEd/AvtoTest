package com.eedurda77.avtotest.presentation.autoinfo

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eedurda77.avtotest.domain.repository.RepositoryAuto
import com.eedurda77.avtotest.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AutoInfoViewModel @Inject constructor(
    private val repositoryAuto: RepositoryAuto,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    private var _state = MutableStateFlow(AutoInfoState())
    val state = _state.asStateFlow()

    init {
        getRemoteData()
    }

    private fun getRemoteData() {
        viewModelScope.launch {
            val id = savedStateHandle.get<Int>("id") ?: return@launch
            when (val result = repositoryAuto.getAutoInfoById(id = id)) {
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
}