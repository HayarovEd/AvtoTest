package com.eedurda77.avtotest.data.paginator

import com.eedurda77.avtotest.domain.paginator.Paginator
import com.eedurda77.avtotest.utils.Resource
import javax.inject.Inject

class PaginatorDefault<Key, Item> @Inject constructor(
    initialKey: Key,
    private inline val onLoadUpdated: (Boolean) -> Unit,
    private inline val onRequest: suspend (nextKey: Key) -> Resource<List<Item>>,
    private inline val getNextKey: suspend (List<Item>) -> Key,
    private inline val onError: suspend (String?) -> Unit,
    private inline val onSuccess: suspend (items: List<Item>, newKey: Key) -> Unit
) : Paginator<Key, Item> {
    private var currentKey = initialKey
    private var isMakingRequest = false
    override suspend fun loadNextItems() {
        if(isMakingRequest) {
            return
        }
        isMakingRequest = true
        onLoadUpdated(true)
        val result = onRequest(currentKey)
        isMakingRequest = false
        when (result) {
            is Resource.Error -> {
                onError(result.message)
                onLoadUpdated(false)
            }
            is Resource.Success -> {
                result.data.let {items->
                    if (items != null) {
                        currentKey = getNextKey(items)
                        onSuccess(items, currentKey)
                    }
                    onLoadUpdated(false)
                }
            }
        }
    }
}