package com.eedurda77.avtotest.data.mapper

import com.eedurda77.avtotest.data.remote.dto.autoinfo.AutoInfoDto
import com.eedurda77.avtotest.data.remote.dto.autos.AutoDtoItem
import com.eedurda77.avtotest.data.remote.dto.post.PostDto
import com.eedurda77.avtotest.domain.model.Auto
import com.eedurda77.avtotest.domain.model.AutoInfo
import com.eedurda77.avtotest.domain.model.PostAuto

fun List<AutoDtoItem>.mapToAuto(): List<Auto> {
    return map { autoDtoItem ->
        Auto(
            id = autoDtoItem.id,
            name = autoDtoItem.name,
            imagePath = autoDtoItem.image
        )
    }
}

fun AutoInfoDto.mapAutoInfo(): AutoInfo {
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

fun PostDto.mapToPostAuto(): List<PostAuto> {
    return this.posts.map { postDto ->
        PostAuto(
            id = postDto.id,
            pathPost = postDto.img,
            datePost = postDto.createdAt.substring(0, 10),
            content = postDto.text,
            likeCount = postDto.likeCount,
            commentCount = postDto.commentCount
        )
    }
}