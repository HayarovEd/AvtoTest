package com.eedurda77.avtotest.data.mapper

import com.eedurda77.avtotest.data.remote.dto.autos.AutoDtoItem
import com.eedurda77.avtotest.domain.model.Auto

fun List<AutoDtoItem>.mapToAuto(): List<Auto> {
    return map { autoDtoItem->
        Auto(
            id = autoDtoItem.id,
            name = autoDtoItem.name,
            imagePath = autoDtoItem.image
        )
    }
}