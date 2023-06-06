package com.eedurda77.avtotest.data.paginator

import com.eedurda77.avtotest.domain.paginator.AutosPaginator
import javax.inject.Inject

class AutosPaginatorDefault<Key, Item> @Inject constructor(
    initialKey: Key,
    private inline val onLoadUpdated: (Boolean) -> Unit,
    private inline val onRequest: suspend (nextKey: Key) -> Result<List<Item>>,
    private inline val getNextKey: suspend (List<Item>) -> Key,
    private inline val onError: suspend (Throwable?) -> Unit,
    private inline val onSuccess: suspend (items: List<Item>, newKey: Key) -> Unit
) : AutosPaginator<Key, Item> {
    private var currentKey = initialKey
    private var isMakingRequest = false
    override suspend fun loadNextAutos() {
        if(isMakingRequest) {
            return
        }
        isMakingRequest = true
        onLoadUpdated(true)
        val result = onRequest(currentKey)
        isMakingRequest = false
        val items = result.getOrElse {
            onError(it)
            onLoadUpdated(false)
            return
        }
        currentKey = getNextKey(items)
        onSuccess(items, currentKey)
        onLoadUpdated(false)
    }
}