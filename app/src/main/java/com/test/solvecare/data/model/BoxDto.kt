package com.test.solvecare.data.model

import com.test.solvecare.domain.model.Box
import kotlinx.serialization.Serializable


@Serializable
data class BoxDto(
    val id: Int,
    val height: Int,
    val width: Int
)

fun BoxDto.toDomainModel() = Box(id, width, height)