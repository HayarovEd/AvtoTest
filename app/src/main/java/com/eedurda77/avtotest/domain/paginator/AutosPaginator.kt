package com.eedurda77.avtotest.domain.paginator

interface AutosPaginator<Key, Item> {
    suspend fun loadNextAutos()
}