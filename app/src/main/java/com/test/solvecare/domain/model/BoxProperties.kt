package com.test.solvecare.domain.model

data class BoxProperties(
    val boxColor: Long,
    val spaceBetweenBox: Int,
    val boxes: List<Box>,
)