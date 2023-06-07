package com.eedurda77.avtotest.domain.paginator

interface Paginator<Key, Item> {
    suspend fun loadNextItems()
}