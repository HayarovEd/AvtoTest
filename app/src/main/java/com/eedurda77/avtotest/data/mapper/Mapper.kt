package com.eedurda77.avtotest.data.mapper

import com.eedurda77.avtotest.data.remote.dto.autoinfo.AutoInfoDto
import com.eedurda77.avtotest.data.remote.dto.autos.AutoDtoItem
import com.eedurda77.avtotest.domain.model.Auto
import com.eedurda77.avtotest.domain.model.AutoInfo

fun List<AutoDtoItem>.mapToAuto(): List<Auto> {
    return map { autoDtoItem ->
        Auto(
            id = autoDtoItem.id,
            name = autoDtoItem.name,
            imagePath = autoDtoItem.image
        )
    }
}

fun AutoInfoDto.mapToAuto(): AutoInfo {
    return AutoInfo(
        id = this.car.id,
        name = this.car.name,
        brandName = this.car.brandName,
        modelName = this.car.modelName,
        year = this.car.year,
        transmissionName = this.car.transmissionName,
        engine = this.car.engine,
        pathImage = this.car.images.first().url,
        userName = this.user.username,
        pathAvatar = this.user.avatar.url
    )
}