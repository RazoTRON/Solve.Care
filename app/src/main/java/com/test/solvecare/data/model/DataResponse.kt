package com.test.solvecare.data.model

import com.test.solvecare.domain.model.BoxProperties
import kotlinx.serialization.Serializable

@Serializable
data class DataResponse(
    val boxColor: String,
    val spaceBetweenBox: Int,
    val boxes: List<BoxDto>,
)

fun DataResponse.toDomainModel() = BoxProperties(boxColor.toLong(radix = 16), spaceBetweenBox, boxes.map {
    it.toDomainModel()
})